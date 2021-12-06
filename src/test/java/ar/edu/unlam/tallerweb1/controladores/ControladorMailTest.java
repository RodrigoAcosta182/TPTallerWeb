package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMail;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ControladorMailTest {


    private ServicioMail servicioMail = mock(ServicioMail.class);
    private ControladorMail controladorMail = new ControladorMail(servicioMail);
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123");
    private static final DatosCorreo DATOSCORREO = new DatosCorreo("jracosta1991@gmail.com", "mensaje de prueba");
    private static final DatosCorreo DATOSCORREONULL = new DatosCorreo(null, null);

    private HttpServletRequest REQUEST = mock(HttpServletRequest.class);
    private HttpSession session = mock(HttpSession.class);
    private RedirectAttributes REDIRECT = mock(RedirectAttributes.class);

    @Before
    public void setup(){
        when(REQUEST.getSession()).thenReturn(session);
        when(session.getAttribute("Usuario")).thenReturn(USUARIO);
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
        thenElEnvioFalla(mav, "La publicacion debe tener un mail asociado");
    }

    private void givenQueElEnvioDeMailFalla(DatosCorreo datosCorreo) throws Exception {
        doThrow(Exception.class).when(servicioMail).enviarCorreo(datosCorreo.getReceptor(), datosCorreo.getComentario(),USUARIO,datosCorreo.getIdPublicacion());
    }


    private ModelAndView whenEnvioMail(DatosCorreo datosCorreo) throws Exception {
        return controladorMail.enviarCorreo(datosCorreo, REQUEST, REDIRECT);
    }

    private void thenElEnvioFalla(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mailError")).isEqualTo(mensaje);

    }

    private void thenEnvioMailCorrectamente(ModelAndView mav) {
        assertThat(mav.getModel().get("mailOk")).isEqualTo("Mensaje enviado correctamente");
    }
}
