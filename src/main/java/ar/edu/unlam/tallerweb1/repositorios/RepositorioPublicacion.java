package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioPublicacion {
    void guardarPublicacion(Publicacion nuevaPublicacion);
    void finalizarPublicacion(Publicacion publicacion);

    List<Publicacion> buscarTodasMisPublicaciones(Usuario usuario);
    List<Publicacion> buscarTodasLasPublicacionesPerdidas();
    List<Publicacion> buscarTodasLasPublicacionesEncontradas();
    Publicacion buscarPublicacionPorId(Long id);


    List<Usuario> buscarUsuarioPorEmail(String email);
}
