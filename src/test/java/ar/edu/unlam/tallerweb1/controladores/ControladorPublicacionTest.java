package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

import org.junit.Test;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorPublicacionTest {

    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("JoseBalvin", "1", "2", "5", "Siberiano",
            "Medio carolo", "Negro y Blanco", "Grande", new Date(), new Publicacion(), null);
    private static final Publicacion PUBLICACION = new Publicacion();

    private HttpServletRequest REQUEST = mock(HttpServletRequest.class);
    private ServicioPublicacion servicioPublicacion = mock(ServicioPublicacion.class);
    private ControladorPublicacion controladorPublicacion = new ControladorPublicacion(servicioPublicacion);


    @Test
    public void irAPublicaciones() {
        ModelAndView mav = whenIrAPublicaciones();
        thenIrAPublicaciones(mav);
    }

    @Test
    public void registroPublicacionExitoso() throws Exception {
        givenQueLaPublicacionNoExiste(PUBLICACION);
        ModelAndView mav = whenRegistroLaPublicacion(MASCOTA, REQUEST);
        thenElRegistroDePublicacionEsExitoso(mav);
    }

    private void givenQueLaPublicacionNoExiste(Publicacion publicacion) {
    }

    private ModelAndView whenRegistroLaPublicacion(DatosRegistroMascota mascota, HttpServletRequest request) throws Exception {
        return controladorPublicacion.registrarPublicacion(mascota, request);
    }

    private void thenElRegistroDePublicacionEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Publicacion Registrada Exitosamente");
    }

    @Test
    public void noSeEncuentraNingunaPublicacion() throws Exception {
        givenQueNoEncuentroPublicacion();
        ModelAndView mav = whenObtengoPublicaciones();
        thenNoEncuentroPublicaciones(mav, "No hay publicaciones");
    }

    @Test
    public void irARegistrarPublicacion() {
        ModelAndView mav = whenIrARegistrarPublicacion();
        thenIrARegistrarPublicacion(mav);
    }

    @Test
    public void irAVerPublicacion() throws Exception {
        ModelAndView mav = whenIrAVerPublicacion(10L);
        thenIrAVerPublicacion(mav);
    }

    @Test
    public void irAVerPublicacionArrojaError() throws Exception {
        givenQueNoEncuentroPublicacionPorId(10L);
        ModelAndView mav = whenIrAVerPublicacion(10L);
        thenIrAVerPublicacionFalla(mav, "Error al encontrar publicacion");
    }


    private void givenQueNoEncuentroPublicacionPorId(Long id) {
        doThrow(Exception.class).when(servicioPublicacion).buscarPublicacion(id);
    }

    private void givenQueNoEncuentroPublicacion() throws Exception {
        doThrow(Exception.class).when(servicioPublicacion).listarTodasLasPublicacionesPerdidas();
    }



    private ModelAndView whenIrAPublicaciones() {
        return controladorPublicacion.irAPublicacionMascotaPerdida(mock(HttpServletRequest.class));
    }

    private ModelAndView whenIrAVerPublicacion(Long id) {
        return controladorPublicacion.irAVerPublicacion(id);
    }

    private ModelAndView whenIrARegistrarPublicacion() {
        return controladorPublicacion.irARegistrarPublicacion();
    }

    private ModelAndView whenObtengoPublicaciones() {
        return controladorPublicacion.irAPublicacionMascotaPerdida(mock(HttpServletRequest.class));
    }



    private void thenIrAPublicaciones(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("publicaciones-perdidos");
    }

    private void thenIrAVerPublicacionFalla(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("msjError")).isEqualTo(mensaje);
    }

    private void thenIrAVerPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("ver-publicacion");
        assertThat(mav.getModel().get("datosCorreo").getClass()).isEqualTo(DatosCorreo.class);
    }

    private void thenIrARegistrarPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("form-registro-mascota");
    }

    private void thenNoEncuentroPublicaciones(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("publicacionesError")).isEqualTo(mensaje);
    }
}







//
//
//    @Test
//    public void alRegistrarUnaMascotaConTipoNull() throws Exception {
//        givenQueLaMascotaExiste();
//        ModelAndView mav = whenRegistroLaMascota(MASCOTACONTIPOYESTADONULL);
//        thenElRegistroDeMascotaFallaTipoNull(mav, "El campo tipo y estado es obligatorio");
//    }
//
//
//    private void givenQueLaMascotaExiste() throws Exception {
//        doThrow(Exception.class).when(servicioRegistrarMascota).registrarMascotaPerdida(MASCOTACONTIPOYESTADONULL);
//    }
//
//


//
//    private ModelAndView whenIrARegistroMascotaPerdida() {
//        return controladorRegistrarMascota.irARegistrarMascotaPerdida();
//    }
//


//
//    private void thenIrARegistrarMascotaPerdida(ModelAndView mav) {
//        assertThat(mav.getViewName()).isEqualTo("form-registro-mascota");
//    }
//




//
//    private void thenElRegistroDeMascotaFallaTipoNull(ModelAndView mav, String mensaje) {
//        assertThat(mav.getViewName()).isEqualTo("form-registro-mascota");
//        assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
//    }
//}
