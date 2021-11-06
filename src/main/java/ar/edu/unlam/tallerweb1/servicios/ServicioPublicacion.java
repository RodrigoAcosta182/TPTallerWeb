package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPublicacion {

    Publicacion registrarPublicacion(DatosRegistroMascota mascota, Usuario usuario) throws Exception;

    List<Publicacion> listarTodasLasPublicacionesEncontradas() throws Exception;

    List<Publicacion> listarTodasLasPublicacionesPerdidas() throws Exception;

    List<Publicacion> listarTodasMisPublicaciones(Usuario usuario) throws Exception;

    Publicacion buscarPublicacion(Long id);

    void finalizarPublicacion(Long id);

    void buscarUsuarioParaFinalizar(Usuario usuario, String email);
}
