package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;

import java.util.List;

public interface ServicioPublicacion {
    List<Publicacion> listarTodasLasPublicaciones() throws Exception;
}
