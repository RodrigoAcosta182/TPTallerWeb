package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface ServicioBuscarPublicacion {

    Publicacion buscarPublicacion(DatosRegistroMascota mascota);
}
