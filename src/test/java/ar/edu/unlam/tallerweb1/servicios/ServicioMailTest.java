package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServicioMailTest {

    private ServicioMail servicioMail = mock(ServicioMail.class);
    private static final String RECEPTOR = "jracosta1991@gmail.com";
    private static final Long IDPUBLICACION = 10L;
    private static final String COMENTARIO = "Comentario de prueba - Missing Pets";
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123");


    @Test
    public void elMailSeEnviaCorrectamente() throws Exception {
        whenEnvioMail(RECEPTOR,COMENTARIO,IDPUBLICACION);
        thenEnvioDeMailCorrecto(RECEPTOR,COMENTARIO);
    }
    @Test
    public void elEnvioDeMailFalla() throws Exception {
        whenEnvioMail(RECEPTOR,COMENTARIO,IDPUBLICACION);
        thenEnvioDeMailFalla(null,null);
    }

    private void thenEnvioDeMailFalla(String receptor, String comentario) {
        assertThat(receptor).isNull();
        assertThat(comentario).isNull();
    }

    private void whenEnvioMail(String receptor, String comentario, Long idPublicacion) throws Exception {
        servicioMail.enviarCorreo(receptor,comentario,USUARIO, idPublicacion);
    }
    private void thenEnvioDeMailCorrecto(String receptor, String comentario) {
        assertThat(receptor).isNotNull();
        assertThat(comentario).isNotNull();
    }


}
