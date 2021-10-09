package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface RepositorioBuscarPublicacion {
    Publicacion buscarPublicacionPorTipo(String tipo);
}
