package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioPublicacion {
    List<Publicacion> buscarPor(Usuario usuario);


    List<Publicacion> buscarTodasLasPublicaciones();

    void guardarPublicacion(Publicacion nuevaPublicacion);
}
