package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ServicioBusquedaTest {

    private RepositorioBusqueda repositorioBusqueda = mock(RepositorioBusqueda.class);
    private ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repositorioBusqueda);
    private static final Publicacion PUBLICACION = new Publicacion(new Mascota("1", "blanco"), new Localidad("Moron"));
    private static final DatosRegistroMascota MASCOTACOMPLETA = new DatosRegistroMascota
            ("1", "1", PUBLICACION, "Pekines", "Blanco");

    @Test
    public void obtengoTodasLasLocalidades() {
        givenQueExistenLocalidades();
        List<Localidad> localidades = whenObtengoLocalidades();
        thenObtengoLocalidades(localidades);
    }

    @Test
    public void buscoPublicacionesPorEstadoLocalidadYColor() throws Exception {
        givenQueExistenPublicacionesConEsosDatos();
        List<Publicacion> publicaciones = whenBuscoPublicacionesConEstadoLocalidadYColor();
        thenEncuentroPublicaciones(publicaciones);
    }

    @Test(expected = Exception.class)
    public void buscoPublicacionesYNoEncuentro() throws Exception {
        givenQueLasPublicacionesBuscadasNoExisten();
        List<Publicacion> publicaciones = whenBuscoPublicacionesConEstadoLocalidadYColor();
        thenNoEncuentroPublicaciones(publicaciones);
    }


    private void givenQueExistenPublicacionesConEsosDatos() {
        List<Publicacion> publicaciones = new ArrayList<>();
        publicaciones.add(PUBLICACION);
        when(repositorioBusqueda.buscarPublicacionPor(PUBLICACION)).thenReturn(publicaciones);
    }

    private void givenQueLasPublicacionesBuscadasNoExisten() {
        when(repositorioBusqueda.buscarPublicacionPor(MASCOTACOMPLETA.getPublicacion())).thenReturn(null);
    }

    private void givenQueExistenLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad("San Justo"));
        when(repositorioBusqueda.obtenerTodasLasLocalidades()).thenReturn(localidades);
    }

    private List<Publicacion> whenBuscoPublicacionesConEstadoLocalidadYColor() throws Exception {
        return servicioBusqueda.buscarPublicaciones(MASCOTACOMPLETA);
    }

    private List<Localidad> whenObtengoLocalidades() {
        return servicioBusqueda.getLocalidades();
    }

    private void thenNoEncuentroPublicaciones(List<Publicacion> publicaciones) {
        assertThat(publicaciones).isNull();
    }

    private void thenEncuentroPublicaciones(List<Publicacion> publicaciones) {
        assertThat(publicaciones).isNotNull();
        verify(repositorioBusqueda, times(1)).buscarPublicacionPor(PUBLICACION);
    }

    private void thenObtengoLocalidades(List<Localidad> localidades) {
        assertThat(localidades).isNotNull();
        verify(repositorioBusqueda,times(1)).obtenerTodasLasLocalidades();
    }
}









