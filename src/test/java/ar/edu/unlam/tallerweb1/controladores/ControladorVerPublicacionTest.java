package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioVerPublicacion;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;


public class ControladorVerPublicacionTest {
    private ServicioVerPublicacion servicioVerPublicacion = mock(ServicioVerPublicacion.class);
    private ControladorVerPublicacion controladorVerPublicacion = new ControladorVerPublicacion(servicioVerPublicacion);
    private static final DatosCorreo DATOSCORREO = new DatosCorreo("jracosta1991@gmail.com", "mensaje de prueba");
    private static final DatosCorreo DATOSCORREONULL = new DatosCorreo(null, null);

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

    @Test
    public void enviarMailCorrectamenteTest() throws Exception {
        ModelAndView mav = whenEnvioMail(DATOSCORREO);
        thenEnvioMailCorrectamente(mav);
    }

    private void thenEnvioMailCorrectamente(ModelAndView mav) {
        assertThat(mav.getModel().get("mailOk")).isEqualTo("Mensaje enviado correctamente");
    }

    private ModelAndView whenEnvioMail(DatosCorreo datosCorreo) throws Exception {
        return controladorVerPublicacion.enviarCorreo(datosCorreo);
    }

    @Test
    public void enviarMailFallaPorAlgunParametroNull()throws Exception{
        givenQueElEnvioDeMailFalla(DATOSCORREONULL);
        ModelAndView mav = whenEnvioMail(DATOSCORREONULL);
        thenElEnvioFalla(mav, "error al enviar el mensaje");
    }

    private void thenElEnvioFalla(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mailError")).isEqualTo(mensaje);

    }

    private void givenQueElEnvioDeMailFalla(DatosCorreo datosCorreo) throws Exception {
        doThrow(Exception.class).when(servicioVerPublicacion).enviarCorreo(datosCorreo.getReceptor(),datosCorreo.getComentario());
    }


}
