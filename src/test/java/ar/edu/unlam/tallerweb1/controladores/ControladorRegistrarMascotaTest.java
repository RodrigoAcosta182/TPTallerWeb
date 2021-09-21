package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.junit.Test;
import static  org.assertj.core.api.Assertions.*;
import org.springframework.web.servlet.ModelAndView;

public class ControladorRegistrarMascotaTest {

    ControladorRegistrarMascota controladorRegistrarMascota = new ControladorRegistrarMascota();
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota();

    @Test
    public void registroMascotaExitoso(){
        givenQueLaMascotaNoExiste(MASCOTA);
        ModelAndView mav = whenRegistroLaMascota(MASCOTA);
        thenElRegistroDeMascotaEsExitoso(mav);
    }

    @Test
    public void registroMascotaFallido(){
        givenQueLaMascotaNoExiste(MASCOTA);
        ModelAndView mav = whenRegistroLaMascota(MASCOTA);
        thenElRegistroDeMascotaEsFallido(mav);
    }

    @Test
    public void irARegistrarMascotaPerdida(){
        ModelAndView mav = whenIrARegistroMascotaPerdida();
        thenIrARegistrarMascotaPerdida(mav);
    }

    private void thenIrARegistrarMascotaPerdida(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("form-mascota-perdida");
    }

    private ModelAndView whenIrARegistroMascotaPerdida() {
        return controladorRegistrarMascota.irARegistrarMascotaPerdida();
    }


    private void givenQueLaMascotaNoExiste(DatosRegistroMascota mascota) {
    }

    private ModelAndView whenRegistroLaMascota(DatosRegistroMascota mascota) {
        return controladorRegistrarMascota.registrarMascota(mascota);
    }

    private void thenElRegistroDeMascotaEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Registrada Exitosamente");
    }
    private void thenElRegistroDeMascotaEsFallido(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
//        assertThat(mav.getModel().get("msg")).isEqualTo("No se pudo registrar");
    }


}
