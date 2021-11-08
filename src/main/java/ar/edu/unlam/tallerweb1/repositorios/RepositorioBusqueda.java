package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

import java.util.List;

public interface RepositorioBusqueda {
    List<Localidad> obtenerTodasLasLocalidades();


    List<Publicacion> obtenerPublicacionesPorLocalidad(String localidad);

    List<Publicacion> buscarPublicaciones(DatosRegistroMascota mascota);

    List<Publicacion> obtenerPublicacionesConAlgunParametroNull(DatosRegistroMascota mascota);
}
