package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

import org.junit.Before;
import org.junit.Test;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorPublicacionTest {

    private static final Usuario USUARIO_MAIL = new Usuario("emortiz@alumno.com", "459");
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123");
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota(10L,"Rodrigo", new Tipo(), new Estado(1L,"Perdido"), "3 Anios", "American Bully", "Le falta una pata", "Blanco", "Chico", new Date(), new Publicacion(), mock(MultipartFile.class), USUARIO_MAIL.getEmail());
    private static final DatosRegistroMascota MASCOTA_MAIL_IGUAL = new DatosRegistroMascota(10L,"Rodrigo", new Tipo(), new Estado(1L,"Perdido"), "3 Anios", "American Bully", "Le falta una pata", "Blanco", "Chico", new Date(), new Publicacion(), mock(MultipartFile.class), USUARIO.getEmail());
    private static final Publicacion PUBLICACION = new Publicacion(10L, new Date(), false, USUARIO, new Mascota(), new Localidad());

    private HttpServletRequest REQUEST = mock(HttpServletRequest.class);
    private HttpSession session = mock(HttpSession.class);
    private ServicioPublicacion servicioPublicacion = mock(ServicioPublicacion.class);
    private ControladorPublicacion controladorPublicacion = new ControladorPublicacion(servicioPublicacion);

    @Before
    public void setup(){
        when(REQUEST.getSession()).thenReturn(session);
        when(session.getAttribute("Usuario")).thenReturn(USUARIO);
    }

    @Test
    public void irAlSitioDePublicaciones() {
        ModelAndView mav = whenIrAlSitioPublicacionesPerdidas();
        thenIrAlSitioPublicacionesPerdidas(mav);
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
        ModelAndView mav = whenIrAlSitioRegistrarPublicacion();
        thenIrAlSitioRegistrarPublicacion(mav);
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
        givenQueLaPublicacionExiste(10L);
        ModelAndView mav = whenFinalizarPublicacion(PUBLICACION);
        thenFinalizoPublicacionCorrectamente(mav, "Publicacion Finalizada");
    }

    @Test
    public void queLaPublicacionNoSeFinalicePorMailInexistente() throws Exception {
        givenQueLaPublicacionExisteYSeFinaliceConMailInexistente(PUBLICACION.getId());
        ModelAndView mav = whenFinalizarPublicacion(PUBLICACION);
        thenNoFinalizoPublicacionPorMailInexistente(mav, "El mail del usuario ingresado no existe");
    }

    @Test
    public void queLaPublicacionNoSeFinalicePorMailIgualAlLogueado() throws Exception {
        givenQueLaPublicacionExisteYSeFinaliceConMailInexistente(PUBLICACION.getId());
        ModelAndView mav = whenFinalizoPublicacionConMailIgual(PUBLICACION);
        thenNoFinalizoPublicacionPorMailInexistente(mav, "El mail ingresado no puede ser igual que el mail logueado");
    }


    @Test
    public void obtengoLocalidadesEnLaPaginaDeRegistroDeMascota(){
        givenQueExistenLocalidades();
        ModelAndView mav = whenIrAlSitioRegistrarPublicacion();
        thenEncuentroLocalidades(mav);
    }

    @Test
    public void obtengoTiposDeMascotaEnLaPaginaDeRegistroDeMascota(){
        givenQueExistenTiposDeMascota();
        ModelAndView mav = whenIrAlSitioRegistrarPublicacion();
        thenEncuentroTiposDeMascota(mav);
    }

    @Test
    public void obtengoEstadosEnLaPaginaDeRegistroDeMascota(){
        givenExistenEstadosDeMascota();
        ModelAndView mav = whenIrAlSitioRegistrarPublicacion();
        thenEncuentroEstadosDeMascota(mav);
    }

    private void thenEncuentroEstadosDeMascota(ModelAndView mav) {
        assertThat(mav.getModel().get("estadosMascota")).isNotNull();
    }

    private void givenExistenEstadosDeMascota() {
        List<Estado> estados = new ArrayList<>();
        estados.add(new Estado());
        when(servicioPublicacion.getEstadosDeMascota()).thenReturn(estados);
    }

    private void thenEncuentroTiposDeMascota(ModelAndView mav) {
        assertThat(mav.getModel().get("tiposDeMascota")).isNotNull();
    }

    private void givenQueExistenTiposDeMascota() {
        List<Tipo> tiposDeMascota = new ArrayList<>();
        tiposDeMascota.add(new Tipo("perro"));
        when(servicioPublicacion.getTiposDeMascota()).thenReturn(tiposDeMascota);
    }

    private void givenQueExistenLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad());
        when(servicioPublicacion.getLocalidades()).thenReturn(localidades);
    }



    private void thenEncuentroLocalidades(ModelAndView mav) {
        assertThat(mav.getModel().get("localidades")).isNotNull();
    }


    private void thenFinalizoPublicacionCorrectamente(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("msg")).isEqualTo(mensaje);
    }

    private void thenNoFinalizoPublicacionPorMailInexistente(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
    }

    private void givenQueLaPublicacionExiste(Long id) throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(USUARIO_MAIL);
        when(servicioPublicacion.buscarUsuarioPorEmail(MASCOTA.getEmail())).thenReturn(usuarios);
        when(servicioPublicacion.buscarPublicacion(id)).thenReturn(PUBLICACION);
    }

    private void givenQueLaPublicacionExisteYSeFinaliceConMailInexistente(Long id) throws Exception {
        doThrow(Exception.class).when(servicioPublicacion).finalizarPublicacion(MASCOTA, PUBLICACION, REQUEST);
    }

    private ModelAndView whenFinalizarPublicacion(Publicacion publicacion) {
        return controladorPublicacion.finalizarPublicacion(MASCOTA,publicacion,REQUEST);
    }

    private ModelAndView whenFinalizoPublicacionConMailIgual(Publicacion publicacion) {
        return controladorPublicacion.finalizarPublicacion(MASCOTA_MAIL_IGUAL,publicacion,REQUEST);
    }


    private void givenQueNoEncuentroPublicacionPorId(Long id) {
        doThrow(Exception.class).when(servicioPublicacion).buscarPublicacion(id);
    }

    private void givenQueNoEncuentroPublicacion() throws Exception {
        doThrow(Exception.class).when(servicioPublicacion).listarTodasLasPublicacionesPerdidas();
    }


    private ModelAndView whenRegistroLaPublicacion(DatosRegistroMascota mascota, HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("Usuario", USUARIO);
        //mascota.setImagen(mock(MultipartFile.class));
        return controladorPublicacion.registrarPublicacion(mascota, REQUEST);
    }

    private ModelAndView whenIrAlSitioPublicacionesPerdidas() {
        return controladorPublicacion.irAPublicacionMascotaPerdida(mock(HttpServletRequest.class));
    }

    private ModelAndView whenIrAVerPublicacion(Long id) {
        return controladorPublicacion.irAVerPublicacion(id);
    }

    private ModelAndView whenIrAlSitioRegistrarPublicacion() {
        return controladorPublicacion.irARegistrarPublicacion();
    }

    private ModelAndView whenObtengoPublicaciones() {
        return controladorPublicacion.irAPublicacionMascotaPerdida(mock(HttpServletRequest.class));
    }


    private void thenElRegistroDePublicacionEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Registrada Exitosamente");
    }

    private void thenIrAlSitioPublicacionesPerdidas(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("publicaciones-perdidos");
    }

    private void thenIrAVerPublicacionFalla(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("msjError")).isEqualTo(mensaje);
    }

    private void thenIrAVerPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("ver-publicacion");
        assertThat(mav.getModel().get("datosCorreo").getClass()).isEqualTo(DatosCorreo.class);
    }

    private void thenIrAlSitioRegistrarPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("form-registro-mascota");
    }

    private void thenNoEncuentroPublicaciones(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("publicacionesError")).isEqualTo(mensaje);
    }
}
