package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.*;

import java.io.IOException;
import java.util.List;

public interface ServicioPublicacion {

    Publicacion registrarPublicacion(DatosRegistroMascota mascota, Usuario usuario) throws Exception;

    List<Publicacion> listarTodasLasPublicacionesEncontradas() throws Exception;

    List<Publicacion> listarTodasLasPublicacionesPerdidas() throws Exception;

    List<Publicacion> listarTodasMisPublicaciones(Usuario usuario) throws Exception;

    Publicacion buscarPublicacion(Long id);

    void finalizarPublicacion(Long id);

    void buscarUsuarioParaFinalizar(Usuario usuario, String email) throws Exception;

    List<Localidad> getLocalidades();

    Localidad getLocalidadPorDescripcion(String localidadDescripcion);

    List<Tipo> getTiposDeMascota();

    Tipo obtenerTipoDeMascotaPorId(long id);

    List<Estado> getEstadosDeMascota();

    Estado obtenerEstadoDeMascotaPorId(long id);

    void modificarPublicacion(DatosRegistroMascota mascota, Publicacion publicacion) throws IOException;

    void eliminarPublicacion(Long id);
}
