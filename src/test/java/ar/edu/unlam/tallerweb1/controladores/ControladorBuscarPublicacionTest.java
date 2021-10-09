package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarPublicacion;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ControladorBuscarPublicacionTest {

    private ServicioBuscarPublicacion servicioBuscarPublicacion = mock(ServicioBuscarPublicacion.class);
    private ControladorBuscarPublicacion controladorBuscarPublicacion = new ControladorBuscarPublicacion(servicioBuscarPublicacion);
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota();

    @Test
    public void irABuscarPublicacion() {
        ModelAndView mav = whenIrABuscarPublicacion();
        thenIrABuscarPublicacion(mav);
    }

    @Test
    public void buscarPublicacionExitosamente() {
        ModelAndView mav = whenBuscoUnaPublicacionExitosamente(MASCOTA);
        thenBuscoUnaPublicacionExitosamente(mav, "Se encontraron publicaciones");
    }

    private ModelAndView whenIrABuscarPublicacion() {
        return controladorBuscarPublicacion.irABuscarMascota();
    }

    private ModelAndView whenBuscoUnaPublicacionExitosamente(DatosRegistroMascota mascota) {
        return controladorBuscarPublicacion.buscarMascota(mascota);
    }

    private void thenIrABuscarPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("buscar-publicacion");
    }


    private void thenBuscoUnaPublicacionExitosamente(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mensajeBusqueda")).isEqualTo(mensaje);
    }

}
