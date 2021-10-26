package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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

        if (mascota.getTipo() == null || mascota.getEstado() == null)
            throw new Exception();
        Publicacion nuevaPublicacion = new Publicacion();
        Mascota nuevaMascota = new Mascota();

        nuevaMascota.setEstado(mascota.getEstado());
        nuevaMascota.setTipo(mascota.getTipo());
        nuevaMascota.setNombre(mascota.getNombre());
        nuevaMascota.setEdad(mascota.getEdad());
        nuevaMascota.setRaza(mascota.getRaza());
        nuevaMascota.setColor(mascota.getColor());
        nuevaMascota.setDetalle(mascota.getDetalle());
        nuevaMascota.setTamanio(mascota.getTamanio());
        nuevaMascota.setFecha(mascota.getFecha());

        try {
            if (mascota.getImagen().getSize() > 0) {
                String nombreConRuta = "img/" + mascota.getImagen().getOriginalFilename();
                nuevaMascota.setImagen(nombreConRuta);

                String filename = "C:\\Taller WEB\\TPTallerWeb\\src\\main\\webapp\\img\\" + mascota.getImagen().getOriginalFilename();
                mascota.getImagen().transferTo(new File(filename));
            } else {
                String nombreConRuta = "img/" + "noImagen.jpeg";
                nuevaMascota.setImagen(nombreConRuta);
            }
        } catch (Exception e) {
            e.getMessage();
        }


        nuevaPublicacion.setFechaPublicacion(new Date());
        nuevaPublicacion.setUsuario(usuario);
        nuevaPublicacion.setMascota(nuevaMascota);
        nuevaPublicacion.setEstado(mascota.getEstado());

        repositorioPublicacion.guardarPublicacion(nuevaPublicacion);

        return nuevaPublicacion;
    }

    @Override
    public void finalizarPublicacion(Long id, Publicacion publicacion) {
        publicacion.setFinalizado(true);
        repositorioPublicacion.finalizarPublicacion(publicacion);
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
