package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;

import java.util.List;

public interface RepositorioBusqueda {
    List<Localidad> obtenerTodasLasLocalidades();
}
