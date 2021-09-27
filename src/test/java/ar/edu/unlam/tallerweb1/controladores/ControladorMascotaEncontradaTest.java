package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static  org.assertj.core.api.Assertions.*;

public class ControladorMascotaEncontradaTest {

    ControladorMascotaEncontrada controladorMascotaEncontrada = new ControladorMascotaEncontrada();
//    private static final DatosMascotaEncontrada MASCOTA = new DatosMascotaEncontrada();

    @Test
    public void irARegistrarMascotaEncontrada(){
        ModelAndView mav = whenIrARegistroMascotaEncontrada();
        thenIrARegistrarMascotaEncontrada(mav);
    }

    private ModelAndView whenIrARegistroMascotaEncontrada() {
        return controladorMascotaEncontrada.irARegistrarMascotaEncontrada();
    }

    private void thenIrARegistrarMascotaEncontrada(ModelAndView mav){
        assertThat(mav.getViewName()).isEqualTo("form-mascota-encontrada");
    }
}
