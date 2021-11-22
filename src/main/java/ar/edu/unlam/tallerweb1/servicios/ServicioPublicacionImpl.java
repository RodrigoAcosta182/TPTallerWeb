package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
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
        String nombreConRuta = "img/" + mascota.getImagen().getOriginalFilename();
        nuevaMascota.setImagen(nombreConRuta);
        String filename = "C:\\Taller WEB\\TPTallerWeb\\src\\main\\webapp\\img\\" + mascota.getImagen().getOriginalFilename();
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
    public void modificarPublicacion(DatosRegistroMascota mascota, Publicacion publicacion) throws IOException {
        Publicacion publi = repositorioPublicacion.buscarPublicacionPorId(publicacion.getId());
        Mascota miMascota = mascota.toMascota();
        Tipo tipoMascota = this.obtenerTipoDeMascotaPorId(mascota.getTipo().getId());
        Estado estadoMascota = this.obtenerEstadoDeMascotaPorId(mascota.getEstado().getId());
        Localidad localidad = this.getLocalidadPorDescripcion(mascota.getPublicacion().getLocalidad().getDescripcion());

        String nombreConRuta = "img/" + mascota.getImagen().getOriginalFilename();
        miMascota.setImagen(nombreConRuta);
        String filename = "C:\\Taller WEB\\TPTallerWeb\\src\\main\\webapp\\img\\" + mascota.getImagen().getOriginalFilename();
        mascota.getImagen().transferTo(new File(filename));

        miMascota.setTipo(tipoMascota);
        miMascota.setEstado(estadoMascota);
        publi.setMascota(miMascota);
        publi.setLocalidad(localidad);

        repositorioPublicacion.modificarPublicacion(publi);
    }

    @Override
    public void eliminarPublicacion(Long id) {
        Publicacion publicacion = repositorioPublicacion.buscarPublicacionPorId(id);
        repositorioPublicacion.eliminarPublicacion(publicacion);
    }

    @Override
    public void finalizarPublicacion(Long id) {
        Publicacion publicacion = repositorioPublicacion.buscarPublicacionPorId(id);
        publicacion.setFinalizado(true);
        repositorioPublicacion.finalizarPublicacion(publicacion);
    }

    @Override
    public void buscarUsuarioParaFinalizar(Usuario usuario, String email) throws Exception {
        if (usuario.getEmail() != email) {
            if (repositorioPublicacion.buscarUsuarioPorEmail(email).size() == 0) {
                throw new Exception();
            }
        }
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
