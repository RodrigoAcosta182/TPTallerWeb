package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Tipo;

import java.util.List;

public interface ServicioBusqueda {
    List<Publicacion> buscarPublicaciones(DatosRegistroMascota mascota) throws Exception;

    List<Localidad> getLocalidades();

    List<Tipo> getTiposDeMascota();

    List<Estado> getEstadosDeMascota();
}
