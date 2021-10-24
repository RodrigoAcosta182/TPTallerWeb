package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorPublicacionTest {

    private ServicioPublicacion servicioPublicacion = mock(ServicioPublicacion.class);
    private ControladorPublicacion controladorPublicacion = new ControladorPublicacion(servicioPublicacion);
    private static final DatosCorreo DATOSCORREO = new DatosCorreo("jracosta1991@gmail.com", "mensaje de prueba");
    private static final DatosCorreo DATOSCORREONULL = new DatosCorreo(null, null);

    @Test
    public void irAPublicaciones() {
        ModelAndView mav = whenIrAPublicaciones();
        thenIrAPublicaciones(mav);
    }

    private void thenIrAPublicaciones(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("publicaciones-perdidos");
    }

    private ModelAndView whenIrAPublicaciones() {
        return controladorPublicacion.irAPublicacionMascotaPerdida(mock(HttpServletRequest.class));
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
    public void enviarMailCorrectamenteTest() throws Exception {
        ModelAndView mav = whenEnvioMail(DATOSCORREO);
        thenEnvioMailCorrectamente(mav);
    }

    @Test
    public void enviarMailFallaPorAlgunParametroNull() throws Exception {
        givenQueElEnvioDeMailFalla(DATOSCORREONULL);
        ModelAndView mav = whenEnvioMail(DATOSCORREONULL);
        thenElEnvioFalla(mav, "error al enviar el mensaje");
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

    private void givenQueElEnvioDeMailFalla(DatosCorreo datosCorreo) throws Exception {
        doThrow(Exception.class).when(servicioPublicacion).enviarCorreo(datosCorreo.getReceptor(), datosCorreo.getComentario());
    }

    private void givenQueNoEncuentroPublicacion() throws Exception {
        doThrow(Exception.class).when(servicioPublicacion).listarTodasLasPublicacionesPerdidas();
    }

    private ModelAndView whenEnvioMail(DatosCorreo datosCorreo) throws Exception {
        return controladorPublicacion.enviarCorreo(datosCorreo);
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


    private void thenIrAVerPublicacionFalla(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("msjError")).isEqualTo(mensaje);
    }

    private void thenElEnvioFalla(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mailError")).isEqualTo(mensaje);

    }

    private void thenEnvioMailCorrectamente(ModelAndView mav) {
        assertThat(mav.getModel().get("mailOk")).isEqualTo("Mensaje enviado correctamente");
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
//    @Test
//    public void registroMascotaExitoso() throws Exception {
//        givenQueLaMascotaNoExiste(MASCOTA);
//        ModelAndView mav = whenRegistroLaMascota(MASCOTA);
//        thenElRegistroDeMascotaEsExitoso(mav);
//    }
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
//    private void givenQueLaMascotaNoExiste(DatosRegistroMascota mascota) {
//    }
//
//    private ModelAndView whenIrARegistroMascotaPerdida() {
//        return controladorRegistrarMascota.irARegistrarMascotaPerdida();
//    }
//
//    private ModelAndView whenRegistroLaMascota(DatosRegistroMascota mascota) throws Exception {
//        return controladorRegistrarMascota.registrarMascota(mascota);
//    }
//
//    private void thenIrARegistrarMascotaPerdida(ModelAndView mav) {
//        assertThat(mav.getViewName()).isEqualTo("form-registro-mascota");
//    }
//
//    private void thenElRegistroDeMascotaEsExitoso(ModelAndView mav) {
//        assertThat(mav.getViewName()).isEqualTo("home");
//        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Registrada Exitosamente");
//
//    }
//
//    private void thenElRegistroDeMascotaFallaTipoNull(ModelAndView mav, String mensaje) {
//        assertThat(mav.getViewName()).isEqualTo("form-registro-mascota");
//        assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
//    }
//}
