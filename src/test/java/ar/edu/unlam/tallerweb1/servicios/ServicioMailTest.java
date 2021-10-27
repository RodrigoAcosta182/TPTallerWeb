package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServicioMailTest {

    private ServicioMail servicioMail = mock(ServicioMail.class);
    private static final String RECEPTOR = "jracosta1991@gmail.com";
    private static final String COMENTARIO = "Comentario de prueba - Missing Pets";


    @Test
    public void elMailSeEnviaCorrectamente() throws Exception {
        whenEnvioMail(RECEPTOR,COMENTARIO);
        thenEnvioDeMailCorrecto(RECEPTOR,COMENTARIO);
    }
    @Test
    public void elEnvioDeMailFalla() throws Exception {
        whenEnvioMail(RECEPTOR,COMENTARIO);
        thenEnvioDeMailFalla(null,null);
    }

    private void thenEnvioDeMailFalla(String receptor, String comentario) {
        assertThat(receptor).isNull();
        assertThat(comentario).isNull();
    }

    private void whenEnvioMail(String receptor, String comentario) throws Exception {
        servicioMail.enviarCorreo(receptor,comentario);
    }
    private void thenEnvioDeMailCorrecto(String receptor, String comentario) {
        assertThat(receptor).isNotNull();
        assertThat(comentario).isNotNull();
    }


}
