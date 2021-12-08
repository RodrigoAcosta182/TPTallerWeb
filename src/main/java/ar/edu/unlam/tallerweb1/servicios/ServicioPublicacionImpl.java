package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service("servicioPublicacion")
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion {

    private final RepositorioPublicacion repositorioPublicacion;

    @Autowired
    public ServicioPublicacionImpl(RepositorioPublicacion repositorioPublicacion) {
        this.repositorioPublicacion = repositorioPublicacion;
    }

    @Autowired
    ServletContext servletContext;

    @Override
    public Publicacion registrarPublicacion(DatosRegistroMascota mascota, Usuario usuario) throws Exception {


        Publicacion nuevaPublicacion = new Publicacion();
        Mascota nuevaMascota = mascota.toMascota();
        Tipo tipoMascota = this.obtenerTipoDeMascotaPorId(mascota.getTipo().getId());
        Estado estadoMascota = this.obtenerEstadoDeMascotaPorId(mascota.getEstado().getId());
        Localidad localidad = this.getLocalidadPorDescripcion(mascota.getPublicacion().getLocalidad().getDescripcion());

        //Esto guarda en base
        Integer randomNumber = (int)Math.random() * 10 + 1;
        String nombreConRuta = "img/"+ randomNumber + mascota.getImagen().getOriginalFilename();
        nuevaMascota.setImagen(nombreConRuta);
        //Esto guarda en disco
        String filename = "C:\\Taller WEB\\TPTallerWeb\\src\\main\\webapp\\img\\"+ randomNumber + mascota.getImagen().getOriginalFilename();
        mascota.getImagen().transferTo(new File(filename));

        nuevaMascota.setTipo(tipoMascota);
        nuevaMascota.setEstado(estadoMascota);
        nuevaPublicacion.setFechaPublicacion(new Date());
        nuevaPublicacion.setUsuario(usuario);
        nuevaPublicacion.setMascota(nuevaMascota);
        nuevaPublicacion.setLocalidad(localidad);

        repositorioPublicacion.guardarPublicacion(nuevaPublicacion);

        return nuevaPublicacion;
    }

    @Override
    public void finalizarPublicacion(DatosRegistroMascota mascota,Publicacion publicacion, HttpServletRequest request) throws Exception {
        Publicacion publi = repositorioPublicacion.buscarPublicacionPorId(publicacion.getId());
        buscarUsuarioParaSumarYFinalizar(mascota.getEmail());
        publi.setFinalizado(true);
        repositorioPublicacion.finalizarPublicacion(publi);
    }

    @Override
    public void eliminarPublicacion(Long id) {
        Publicacion publicacion = repositorioPublicacion.buscarPublicacionPorId(id);
        List<ChatUsuario> chatUsuario = repositorioPublicacion.buscarChatUsuarioPorPublicacion(id);
        for (ChatUsuario chat: chatUsuario) {
            repositorioPublicacion.eliminarChatUsuarioPorPublicacion(chat);
        }
        repositorioPublicacion.eliminarPublicacion(publicacion);
    }

    @Override
    public List<ChatUsuario> obtenerComentariosPorIdPublicacion(Long id) {
        return repositorioPublicacion.buscarComentariosPorIdPublicacion(id);
    }

    @Override
    public void modificarPublicacion(DatosRegistroMascota mascota, Publicacion publicacion) throws Exception {
        Publicacion publi = repositorioPublicacion.buscarPublicacionPorId(publicacion.getId());
        Mascota miMascota = mascota.toMascotaModificar(publi.getMascota());
        Tipo tipoMascota = this.obtenerTipoDeMascotaPorId(mascota.getTipo().getId());
        Estado estadoMascota = this.obtenerEstadoDeMascotaPorId(mascota.getEstado().getId());
        Localidad localidad = this.getLocalidadPorDescripcion(mascota.getPublicacion().getLocalidad().getDescripcion());
        miMascota.setImagen(publi.getMascota().getImagen());

        if (mascota.getImagen().isEmpty()){
            miMascota.setImagen(publi.getMascota().getImagen());
        }else{
            Integer randomNumber = (int)Math.random() * 10 + 1;
            String nombreConRuta = "img/"+ randomNumber + mascota.getImagen().getOriginalFilename();
            miMascota.setImagen(nombreConRuta);
            String filename = "C:\\Taller WEB\\TPTallerWeb\\src\\main\\webapp\\img\\"+ randomNumber + mascota.getImagen().getOriginalFilename();
            mascota.getImagen().transferTo(new File(filename));
        }

        miMascota.setTipo(tipoMascota);
        miMascota.setEstado(estadoMascota);
        publi.setMascota(miMascota);
        publi.setLocalidad(localidad);

        repositorioPublicacion.modificarPublicacion(publi);
    }

    @Override
    public void buscarUsuarioParaSumarYFinalizar( String email) throws Exception {
        if (email != ""){
            if (email != null){
                Usuario user = repositorioPublicacion.buscarUsuarioPorEmailParaSumar(email);
                user.setPuntos(user.getPuntos() + 50);
                repositorioPublicacion.sumarPuntosAlUsuario(user);
            }
        }
    }

    @Override
    public List<Usuario> buscarUsuarioPorEmail(String email) throws Exception{
        return repositorioPublicacion.buscarUsuarioPorEmail(email);
    }

    @Override
    public List<Localidad> getLocalidades() {
        return repositorioPublicacion.obtenerTodasLasLocalidades();
    }

    @Override
    public Localidad getLocalidadPorDescripcion(String localidadDescripcion) {
        return repositorioPublicacion.obtenerLocalidadPorDescripcion(localidadDescripcion);
    }

    @Override
    public List<Tipo> getTiposDeMascota() {
        return repositorioPublicacion.obtenerTodosLosTiposDeMascota();
    }

    @Override
    public Tipo obtenerTipoDeMascotaPorId(long id) {
        return repositorioPublicacion.obtenerTipoDeMascotaPorId(id);
    }

    @Override
    public List<Estado> getEstadosDeMascota() {
        return repositorioPublicacion.obtenerTodosLosEstadosDeMascota();
    }

    @Override
    public Estado obtenerEstadoDeMascotaPorId(long id) {
        return repositorioPublicacion.obtenerEstadoDeMascotaPorId(id);
    }

    @Override
    public List<Publicacion> listarTodasLasPublicacionesPerdidas() throws Exception {

        if (repositorioPublicacion.buscarTodasLasPublicacionesPerdidas().size() == 0)
            throw new Exception();
        return repositorioPublicacion.buscarTodasLasPublicacionesPerdidas();
    }


    @Override
    public List<Publicacion> listarTodasLasPublicacionesEncontradas() throws Exception {

        if (repositorioPublicacion.buscarTodasLasPublicacionesEncontradas().size() == 0)
            throw new Exception();
        return repositorioPublicacion.buscarTodasLasPublicacionesEncontradas();
    }

    @Override
    public List<Publicacion> listarTodasMisPublicaciones(Usuario usuario) throws Exception {
        if (repositorioPublicacion.buscarTodasMisPublicaciones(usuario).size() == 0)
            throw new Exception();
        return repositorioPublicacion.buscarTodasMisPublicaciones(usuario);
    }

    @Override
    public Publicacion buscarPublicacion(Long id) {
        return repositorioPublicacion.buscarPublicacionPorId(id);

    }


}
