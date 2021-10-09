package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarMascota;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ControladorBuscarMascotaTest {

    private ServicioBuscarMascota servicioBuscarMascota = mock(ServicioBuscarMascota.class);
    private ControladorBuscarMascota controladorBuscarMascota = new ControladorBuscarMascota (servicioBuscarMascota);
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota();

    @Test
    public void irABuscarMascota() {
        ModelAndView mav = whenIrABuscarMascota();
        thenIrABuscarMascota(mav);
    }

    @Test
    public void buscarMascotaExitosamente() {
        ModelAndView mav = whenBuscoUnaMascotaExitosamente(MASCOTA);
        thenBuscoUnaMascotaExitosamente(mav, "Se encontraron mascotas");
    }

    private ModelAndView whenIrABuscarMascota() {
        return controladorBuscarMascota.irABuscarMascota();
    }

    private ModelAndView whenBuscoUnaMascotaExitosamente(DatosRegistroMascota mascota) {
        return controladorBuscarMascota.buscarMascota(mascota);
    }

    private void thenIrABuscarMascota(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("buscar-mascota");
    }


    private void thenBuscoUnaMascotaExitosamente(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mensajeBusqueda")).isEqualTo(mensaje);
    }

}
