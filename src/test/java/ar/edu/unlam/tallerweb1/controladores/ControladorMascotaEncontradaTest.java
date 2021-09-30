package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static  org.assertj.core.api.Assertions.*;

public class ControladorMascotaEncontradaTest {

    ControladorMascotaEncontrada controladorMascotaEncontrada = new ControladorMascotaEncontrada();
    private static final DatosMascotaEncontrada MASCOTA_ENCONTRADA = new DatosMascotaEncontrada();

    @Test
    public void irARegistrarMascotaEncontrada(){
        ModelAndView mav = whenIrARegistroMascotaEncontrada();
        thenIrARegistrarMascotaEncontrada(mav);
    }

    @Test
    public void registrarMascotaEncontradaTest(){
        givenRegistrarMascota(MASCOTA_ENCONTRADA);
        ModelAndView mav = whenRegistroMascota(MASCOTA_ENCONTRADA);
        thenRegistroMascotaExitoso(mav);
    }


    private ModelAndView whenRegistroMascota(DatosMascotaEncontrada mascotaEncontrada) {
        return controladorMascotaEncontrada.registrarMascotaEncontrada();
    }

    private void givenRegistrarMascota(DatosMascotaEncontrada mascotaEncontrada) {

    }



    private ModelAndView whenIrARegistroMascotaEncontrada() {
        return controladorMascotaEncontrada.irARegistrarMascotaEncontrada();
    }

    private void thenIrARegistrarMascotaEncontrada(ModelAndView mav){
        assertThat(mav.getViewName()).isEqualTo("form-mascota-encontrada");
    }


    private void thenRegistroMascotaExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Registrada Exitosamente");


    }
}