package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.util.List;

public interface RepositorioPublicacion {
    void guardarPublicacion(Publicacion nuevaPublicacion);
    void finalizarPublicacion(Publicacion publicacion);

    List<Publicacion> buscarTodasMisPublicaciones(Usuario usuario);
    List<Publicacion> buscarTodasLasPublicacionesPerdidas();
    List<Publicacion> buscarTodasLasPublicacionesEncontradas();
    Publicacion buscarPublicacionPorId(Long id);


    List<Usuario> buscarUsuarioPorEmail(String email);

    List<Localidad> obtenerTodasLasLocalidades();

    Localidad obtenerLocalidadPorDescripcion(String localidadDescripcion);

    List<Tipo> obtenerTodosLosTiposDeMascota();

    Tipo obtenerTipoDeMascotaPorId(long id);

    List<Estado> obtenerTodosLosEstadosDeMascota();

    Estado obtenerEstadoDeMascotaPorId(long id);

    void modificarPublicacion(Publicacion publicacion);

    void eliminarPublicacion(Publicacion publicacion);
}
