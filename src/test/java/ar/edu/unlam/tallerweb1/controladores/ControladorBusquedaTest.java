package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
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
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Ramon", new Tipo(), new Estado(), "3 Anios", "American Bully", "Le falta una pata", "Blanco", "Chico", new Date(), new Publicacion(), null, "nashe");

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

    @Test
    public void obtengoLocalidadesEnLaPaginaDeBusqueda(){
        givenQueExistenLocalidades();
        ModelAndView mav = whenIrAVerPaginaDeBusqueda();
        thenEncuentroLocalidades(mav);
    }

    @Test
    public void obtengoTiposDeMascotaEnLaPaginaDeBusquedaDeMascota(){
        givenQueExistenTiposDeMascota();
        ModelAndView mav = whenIrAVerPaginaDeBusqueda();
        thenEncuentroTiposDeMascota(mav);
    }

    @Test
    public void obtengoEstadosEnLaPaginaDeBusquedaDeMascota(){
        givenExistenEstadosDeMascota();
        ModelAndView mav = whenIrAVerPaginaDeBusqueda();
        thenEncuentroEstadosDeMascota(mav);
    }

    private void givenExistenEstadosDeMascota() {
        List<Estado> estados = new ArrayList<>();
        estados.add(new Estado());
        when(servicioBusqueda.getEstadosDeMascota()).thenReturn(estados);
    }

    private void thenEncuentroEstadosDeMascota(ModelAndView mav) {
        assertThat(mav.getModel().get("estadosMascota")).isNotNull();
    }


    private void givenQueExistenTiposDeMascota() {
        List<Tipo> tiposDeMascota = new ArrayList<>();
        tiposDeMascota.add(new Tipo("perro"));
        when(servicioBusqueda.getTiposDeMascota()).thenReturn(tiposDeMascota);
    }

    private void thenEncuentroTiposDeMascota(ModelAndView mav) {
        assertThat(mav.getModel().get("tiposDeMascota")).isNotNull();
    }



    private void thenEncuentroLocalidades(ModelAndView mav) {
        assertThat(mav.getModel().get("localidades")).isNotNull();
    }


    private void givenQueExistenLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad());
        when(servicioBusqueda.getLocalidades()).thenReturn(localidades);
    }


    private void givenQueLaPublicacionExiste() throws Exception {
        List<Publicacion> publicaciones = new ArrayList<>();
        when(servicioBusqueda.buscarPublicaciones(MASCOTA)).thenReturn(publicaciones);
    }

    private void givenQueLaPublicacionNoExiste() throws Exception {
        doThrow(Exception.class).when(servicioBusqueda).buscarPublicaciones(MASCOTA);
    }

    private ModelAndView whenBuscoPublicacion() throws Exception {
        return controladorBusqueda.buscarPublicaciones(MASCOTA);
    }

    private ModelAndView whenIrAVerPaginaDeBusqueda() {
        return controladorBusqueda.irAVerPaginaDeBusqueda();
    }

    private void thenNoEncuentroPublicaciones(ModelAndView mav) {
        assertThat(mav.getModel().get("publicacionesError")).isEqualTo("No se encontraron publicaciones");
        assertThat(mav.getViewName()).isEqualTo("publicaciones-filtradas-busqueda");
    }
    private void thenEncuentroPublicaciones(ModelAndView mav) {
        assertThat(mav.getModel().get("mensajeOK")).isEqualTo("Se encontraron publicaciones");
        assertThat(mav.getViewName()).isEqualTo("publicaciones-filtradas-busqueda");
    }

    private void thenVerPaginaBusqueda(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("buscar-publicacion");
    }


}
