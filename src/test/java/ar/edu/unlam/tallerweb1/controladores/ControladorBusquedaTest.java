package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorBusquedaTest {

    private ServicioBusqueda servicioBusqueda = mock(ServicioBusqueda.class);
    private ControladorBusqueda controladorBusqueda = new ControladorBusqueda(servicioBusqueda);
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Ramon", "Perro", "1", "3 Anios", "American Bully", "Le falta una pata", "Blanco", "Chico", new Date(), new Publicacion(), null, "nashe");

    @Test
    public void irAVerPaginaDeBusqueda() {
        ModelAndView mav = whenIrAVerPaginaDeBusqueda();
        thenVerPaginaBusqueda(mav);
    }

    @Test
    public void realizoUnaBusquedaYNoEncuentroPublicaciones() throws Exception {
        givenQueLaPublicacionNoExiste();
        ModelAndView mav = whenBuscoPublicacion();
        thenNoEncuentroPublicaciones(mav);
    }

    @Test
    public void realizoUnaBusquedaYEncuentroPublicaciones() throws Exception {
        givenQueLaPublicacionExiste();
        ModelAndView mav = whenBuscoPublicacion();
        thenEncuentroPublicaciones(mav);
    }


    private void givenQueLaPublicacionExiste() {
        List<Publicacion> publicaciones = new ArrayList<>();
        when(servicioBusqueda.buscarPublicaciones(MASCOTA)).thenReturn(publicaciones);
    }

    private void givenQueLaPublicacionNoExiste() {
        doThrow(Exception.class).when(servicioBusqueda).buscarPublicaciones(MASCOTA);
    }

    private ModelAndView whenBuscoPublicacion() throws Exception {
        return controladorBusqueda.buscarPublicaciones(MASCOTA);
    }

    private ModelAndView whenIrAVerPaginaDeBusqueda() {
        return controladorBusqueda.irAVerPaginaDeBusqueda();
    }

    private void thenNoEncuentroPublicaciones(ModelAndView mav) {
        assertThat(mav.getModel().get("mensajeError")).isEqualTo("No se encontraron publicaciones");
        assertThat(mav.getViewName()).isEqualTo("buscar-publicacion");
    }
    private void thenEncuentroPublicaciones(ModelAndView mav) {
        assertThat(mav.getModel().get("mensajeOK")).isEqualTo("Se encontraron publicaciones");
        assertThat(mav.getViewName()).isEqualTo("publicaciones-filtradas-busqueda");
    }

    private void thenVerPaginaBusqueda(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("buscar-publicacion");
    }


}
