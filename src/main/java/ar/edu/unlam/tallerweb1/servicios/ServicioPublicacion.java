package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPublicacion {
    List<Publicacion> listarTodasLasPublicaciones() throws Exception;

    Publicacion registrarPublicacion(DatosRegistroMascota mascota, Usuario usuario) throws Exception;
}
