package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarMascota;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.springframework.web.servlet.ModelAndView;

public class ControladorRegistrarMascotaTest {

    private ServicioRegistrarMascota servicioRegistrarMascota = mock(ServicioRegistrarMascota.class);
    private ControladorRegistrarMascota controladorRegistrarMascota = new ControladorRegistrarMascota(servicioRegistrarMascota);

    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota();

    @Test
    public void registroMascotaExitoso() throws Exception {
        givenQueLaMascotaNoExiste(MASCOTA);
        ModelAndView mav = whenRegistroLaMascota(MASCOTA);
        thenElRegistroDeMascotaEsExitoso(mav);
    }

    @Test
    public void irARegistrarMascotaPerdida() {
        ModelAndView mav = whenIrARegistroMascotaPerdida();
        thenIrARegistrarMascotaPerdida(mav);
    }

    @Test
    public void alRegistrarUnaMascotaPerdidaDaError() throws Exception {
        givenQueLaMascotaExiste();
        ModelAndView mav = whenRegistroLaMascota(MASCOTA);
        thenElRegistroDeMascotaFallaConError(mav, "Fallo el registro de la mascota");
    }

    private void givenQueLaMascotaExiste() throws Exception {
        doThrow(Exception.class).when(servicioRegistrarMascota).registrarMascotaPerdida(any(), any(), any(), any(), any(), any(), any(), any());
    }

    private void givenQueLaMascotaNoExiste(DatosRegistroMascota mascota) {
    }

    private ModelAndView whenIrARegistroMascotaPerdida() {
        return controladorRegistrarMascota.irARegistrarMascotaPerdida();
    }

    private ModelAndView whenRegistroLaMascota(DatosRegistroMascota mascota) throws Exception {
        return controladorRegistrarMascota.registrarMascota(mascota);
    }

    private void thenIrARegistrarMascotaPerdida(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("form-registro-mascota");
    }

    private void thenElRegistroDeMascotaEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Registrada Exitosamente");

    }

    private void thenElRegistroDeMascotaFallaConError(ModelAndView mav, String mensaje) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
    }
}
