package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioVerPublicacion;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class ControladorVerPublicacionTest {
    private ServicioVerPublicacion servicioVerPublicacion = mock(ServicioVerPublicacion.class);
    private ControladorVerPublicacion controladorVerPublicacion = new ControladorVerPublicacion(servicioVerPublicacion);

    @Test
    public void irAVerPublicacion() throws Exception {
        ModelAndView mav = whenIrAVerPublicacion();
        thenIrAVerPublicacion(mav);
    }

    private void thenIrAVerPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("ver-publicacion");
    }

    private ModelAndView whenIrAVerPublicacion() throws MessagingException {
        return controladorVerPublicacion.irAVerPublicacion();
    }




//    @Test
//    public void enviarMailCorrectamenteTest(){
////        ModelAndView mav = enviarMailCorrectamente();
////        thenEnvioMailCorrectamente(mav);
//    }
//
//    private void thenEnvioMailCorrectamente(ModelAndView mav) {
//        assertThat(mav.getModel().get("mensaje")).isEqualTo("Mail enviado correctamente");
//    }
//
////    private ModelAndView enviarMailCorrectamente() {
//////        return controladorVerPublicacion.enviarCorreo( );
////    }


}
