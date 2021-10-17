//package ar.edu.unlam.tallerweb1.controladores;
//
//import ar.edu.unlam.tallerweb1.modelo.Publicacion;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
//import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
//import org.junit.Test;
//import org.mockito.configuration.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.mock;
//
//public class ControladorPublicacionesPerdidosTest {
//
//    private ServicioPublicacion servicioPublicacion = mock(ServicioPublicacion.class);
//    private ServicioLogin servicioLogin = mock(ServicioLogin.class);
//    private ControladorPublicacion controladorPublicacion = new ControladorPublicacion(servicioPublicacion);
//    private ControladorLogin controladorLogin = new ControladorLogin(servicioLogin);
//
//    @Test
//    public void irAPublicaciones() {
//        givenBuscarUsuario();
//        ModelAndView mav = whenIrAPublicaciones();
//        thenIrAPublicaciones(mav);
//    }
//
//    private void givenBuscarUsuario( HttpServletRequest request) {
//        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
//        String email = usuario.getEmail();
//        String password = usuario.getPassword();
//        servicioLogin.consultarUsuario(email,password);
//    }
//
//    private void thenIrAPublicaciones(ModelAndView mav) {
//        assertThat(mav.getViewName()).isEqualTo("publicaciones-perdidos");
//    }
//
//    private ModelAndView whenIrAPublicaciones() {
//        return controladorPublicacion.irAPublicacionMascotaPerdida(mock(HttpServletRequest.class));
//    }
//
//    @Test
//    public void noSeEncuentraNingunaPublicacion() throws Exception {
//        givenQueNoEncuentroPublicacion();
//        ModelAndView mav = whenObtengoPublicaciones();
//        thenNoEncuentroPublicaciones(mav, "No hay publicaciones");
//    }
//
//    private void thenNoEncuentroPublicaciones(ModelAndView mav, String mensaje) {
//        assertThat(mav.getModel().get("publicacionesError")).isEqualTo(mensaje);
//    }
//
//    private ModelAndView whenObtengoPublicaciones() {
//        return controladorPublicacion.irAPublicacionMascotaPerdida(mock(HttpServletRequest.class));
//    }
//
//    private void givenQueNoEncuentroPublicacion() throws Exception {
//        doThrow(Exception.class).when(servicioPublicacion).listarTodasLasPublicaciones();
//    }
//
//
//}
