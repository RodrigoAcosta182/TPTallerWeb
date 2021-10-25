package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorMailTest {

    private ServicioPublicacion servicioPublicacion = mock(ServicioPublicacion.class);
    private ControladorPublicacion controladorPublicacion = new ControladorPublicacion(servicioPublicacion);
    private static final DatosCorreo DATOSCORREO = new DatosCorreo("jracosta1991@gmail.com", "mensaje de prueba");
    private static final DatosCorreo DATOSCORREONULL = new DatosCorreo(null, null);

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

    private void givenQueElEnvioDeMailFalla(DatosCorreo datosCorreo) throws Exception {
        doThrow(Exception.class).when(servicioPublicacion).enviarCorreo(datosCorreo.getReceptor(), datosCorreo.getComentario());
    }


    private ModelAndView whenEnvioMail(DatosCorreo datosCorreo) throws Exception {
        return controladorPublicacion.enviarCorreo(datosCorreo);
    }

    private void thenElEnvioFalla(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mailError")).isEqualTo(mensaje);

    }

    private void thenEnvioMailCorrectamente(ModelAndView mav) {
        assertThat(mav.getModel().get("mailOk")).isEqualTo("Mensaje enviado correctamente");
    }
}
