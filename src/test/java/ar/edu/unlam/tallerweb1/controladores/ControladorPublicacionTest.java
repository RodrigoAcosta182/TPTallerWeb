package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

import org.junit.Before;
import org.junit.Test;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorPublicacionTest {

    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Rodrigo", "Perro", "1", "3 Anios", "American Bully", "Le falta una pata", "Blanco", "Chico", new Date(), new Publicacion(), null, "nashe");
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123");

    private HttpServletRequest REQUEST = mock(HttpServletRequest.class);
    private HttpSession session = mock(HttpSession.class);
    private ServicioPublicacion servicioPublicacion = mock(ServicioPublicacion.class);
    private ControladorPublicacion controladorPublicacion = new ControladorPublicacion(servicioPublicacion);

    @Before
    public void setup(){
        when(REQUEST.getSession()).thenReturn(session);
    }

    @Test
    public void irAlSitioDePublicaciones() {
        ModelAndView mav = whenIrAPublicaciones();
        thenIrAPublicaciones(mav);
    }

    @Test
    public void registroPublicacionExitoso() throws Exception {
        ModelAndView mav = whenRegistroLaPublicacion(MASCOTA, REQUEST);
        thenElRegistroDePublicacionEsExitoso(mav);
    }

    @Test
    public void noSeEncuentraNingunaPublicacion() throws Exception {
        givenQueNoEncuentroPublicacion();
        ModelAndView mav = whenObtengoPublicaciones();
        thenNoEncuentroPublicaciones(mav, "No hay publicaciones");
    }

    @Test
    public void irAlSitioRegistrarPublicacion() {
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

    @Test
    public void queLaPublicacionSeFinaliceCorrectamente() throws Exception {
        givenQueLaPublicacionExiste();
        ModelAndView mav = whenFinalizarPublicacion(1L);
        thenFinalizoPublicacionCorrectamente(mav, "Publicacion Finalizada");
    }


    private void thenFinalizoPublicacionCorrectamente(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("msg")).isEqualTo(mensaje);
    }

    private void givenQueLaPublicacionExiste() throws Exception {
        when(controladorPublicacion.registrarPublicacion(MASCOTA, REQUEST));
    }

    private ModelAndView whenFinalizarPublicacion(Long id) {
        return controladorPublicacion.finalizarPublicacion(id);
    }


    private void givenQueNoEncuentroPublicacionPorId(Long id) {
        doThrow(Exception.class).when(servicioPublicacion).buscarPublicacion(id);
    }

    private void givenQueNoEncuentroPublicacion() throws Exception {
        doThrow(Exception.class).when(servicioPublicacion).listarTodasLasPublicacionesPerdidas();
    }


    private ModelAndView whenRegistroLaPublicacion(DatosRegistroMascota mascota, HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("Usuario", USUARIO);
        return controladorPublicacion.registrarPublicacion(mascota, REQUEST);
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


    private void thenElRegistroDePublicacionEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Registrada Exitosamente");
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
