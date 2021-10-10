package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarPublicacion;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
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
        ModelAndView mav = whenBuscoUnaPublicacion(MASCOTA);
        thenBuscoUnaPublicacionExitosamente(mav, "Se encontraron publicaciones");
    }

    @Test
    public void buscarPublicacionNoDaResultado(){
        givenQueLaPublicacionNoDaResultado(MASCOTA);
        ModelAndView mav = whenBuscoUnaPublicacion(MASCOTA);
        thenLaPublicacionNoDaResultado(mav, "No hay publicaciones");
    }

    private void thenLaPublicacionNoDaResultado(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mensajeBusquedaError")).isEqualTo(mensaje);
    }

    private void givenQueLaPublicacionNoDaResultado(DatosRegistroMascota mascota) {
        doThrow(Exception.class).when(servicioBuscarPublicacion).buscarPublicacion(mascota);
    }


    private ModelAndView whenIrABuscarPublicacion() {
        return controladorBuscarPublicacion.irABuscarMascota();
    }

    private ModelAndView whenBuscoUnaPublicacion(DatosRegistroMascota mascota) {
        return controladorBuscarPublicacion.buscarMascota(mascota);
    }

    private void thenIrABuscarPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("buscar-publicacion");
    }


    private void thenBuscoUnaPublicacionExitosamente(ModelAndView mav, String mensaje) {
        assertThat(mav.getModel().get("mensajeBusqueda")).isEqualTo(mensaje);
    }

}
