package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.junit.Test;
import static  org.assertj.core.api.Assertions.*;
import org.springframework.web.servlet.ModelAndView;

public class ControladorRegistrarMascotaTest {

    ControladorRegistrarMascota controladorRegistrarMascota = new ControladorRegistrarMascota();

    @Test
    public void registroUnaMascotaPerdidaSatisfactoriamente(){
        DatosRegistroMascota mascota = givenRegistroUnaMascota();
        thenElRegistroDeMascoaEsSatisfactorio(mascota);
    }

    @Test
    public void registroUnaMascotaPerdidaFallido(){
        DatosRegistroMascota mascota = givenRegistroUnaMascota();
        thenElRegistroDeMascotaFalla(mascota);
    }

    private void thenElRegistroDeMascotaFalla(DatosRegistroMascota mascota) {
        assertThat(controladorRegistrarMascota.registroDeMascotaFallido()).isTrue();
    }

    private void thenElRegistroDeMascoaEsSatisfactorio(DatosRegistroMascota mascota) {
        assertThat(controladorRegistrarMascota.registroDeMascotaExitoso()).isTrue();
    }


    private DatosRegistroMascota givenRegistroUnaMascota() {
        return new DatosRegistroMascota();
    }



}
