package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Tipo;

import java.util.List;

public interface RepositorioBusqueda {

    List<Localidad> obtenerTodasLasLocalidades();
    List<Publicacion> buscarPublicacionPor(Publicacion publicacion);

    List<Tipo> obtenerTodosLosTiposDeMascota();

    List<Estado> obtenerTodosLosEstadosDeMascota();
}
