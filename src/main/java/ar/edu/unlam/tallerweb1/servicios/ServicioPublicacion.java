package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface ServicioPublicacion {

    Publicacion registrarPublicacion(DatosRegistroMascota mascota, Usuario usuario) throws Exception;

    List<Publicacion> listarTodasLasPublicacionesEncontradas() throws Exception;

    List<Publicacion> listarTodasLasPublicacionesPerdidas() throws Exception;

    List<Publicacion> listarTodasMisPublicaciones(Usuario usuario) throws Exception;

    Publicacion buscarPublicacion(Long id);

    void finalizarPublicacion(DatosRegistroMascota mascota,Publicacion publicacion, HttpServletRequest request) throws Exception;

    void buscarUsuarioParaSumarYFinalizar( String email) throws Exception;

    List<Usuario> buscarUsuarioPorEmail(String email) throws Exception;

    List<Localidad> getLocalidades();

    Localidad getLocalidadPorDescripcion(String localidadDescripcion);

    List<Tipo> getTiposDeMascota();

    Tipo obtenerTipoDeMascotaPorId(long id);

    List<Estado> getEstadosDeMascota();

    Estado obtenerEstadoDeMascotaPorId(long id);

    void modificarPublicacion(DatosRegistroMascota mascota, Publicacion publicacion) throws Exception;

    void eliminarPublicacion(Long id);
}
