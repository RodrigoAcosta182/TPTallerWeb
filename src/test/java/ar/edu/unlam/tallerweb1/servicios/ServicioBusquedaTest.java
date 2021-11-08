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
    private static final Publicacion PUBLICACION = new Publicacion(new Localidad("Moron"));
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Lucas", "1",
            null, "3 Anios", "American Bully", "Le falta una pata", "Blanco",
            "Chico", new Date(), PUBLICACION, mock(MultipartFile.class), "jracosta1991@gmail.com");

    private static final DatosRegistroMascota MASCOTACOMPLETA = new DatosRegistroMascota
            ("1","1",PUBLICACION,"Pekines","Blanco");


    @Test
    public void obtengoTodasLasLocalidades() {
        givenQueExistenLocalidades();
        List<Localidad> localidades = whenObtengoLocalidades();
        thenObtengoLocalidades(localidades);

    }

    @Test
    public void buscoPublicacionesPorLocalidadExitosamente() {
        givenQueLasPublicacionesConEsaLocalidadExisten();
        List<Publicacion> publicaciones = whenObtengoPublicacionesPorLocalidad();
        //thenEncuentroPublicaciones(publicaciones);
    }

    @Test
    public void noEncuentroPublicacionesPorLocalidad() {
        givenQueLasPublicacionesConEsaLocalidadNoExisten();
        List<Publicacion> publicaciones = whenObtengoPublicacionesPorLocalidad();
        //thenNoEncuentroPublicaciones(publicaciones);
    }

    @Test
    public void buscoPublicacionesPorTodosLosParametros(){
        givenQueExistenPublicacionesConEsosParametros();
    }

    private void givenQueExistenPublicacionesConEsosParametros() {
        List<Publicacion> publicaciones = new ArrayList<>();
        Publicacion publicacion = new Publicacion();
        Localidad localidad = new Localidad("Moron");
        publicacion.setLocalidad(localidad);
        publicaciones.add(publicacion);
    }


    private void givenQueLasPublicacionesConEsaLocalidadNoExisten() {
        List<Publicacion> publicaciones = new ArrayList<>();
        Publicacion publicacion = new Publicacion();
        Localidad localidad = new Localidad("Moron");
        publicacion.setLocalidad(localidad);
        publicaciones.add(publicacion);
        when(repositorioBusqueda.obtenerPublicacionesPorLocalidad(publicacion.getLocalidad().getDescripcion())).thenReturn(null);
    }

    private void givenQueLasPublicacionesConEsaLocalidadExisten() {
        List<Publicacion> publicaciones = new ArrayList<>();

        Publicacion publicacion = new Publicacion();
        Localidad localidad = new Localidad("Moron");

        publicacion.setLocalidad(localidad);
        publicaciones.add(publicacion);
        when(repositorioBusqueda.obtenerPublicacionesPorLocalidad(publicacion.getLocalidad().getDescripcion())).thenReturn(publicaciones);
    }

    private void givenQueExistenLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad("San Justo"));
        when(repositorioBusqueda.obtenerTodasLasLocalidades()).thenReturn(localidades);
    }

    private List<Publicacion> whenObtengoPublicacionesPorLocalidad() {
        return servicioBusqueda.buscarPublicaciones(MASCOTA);
    }


    private List<Localidad> whenObtengoLocalidades() {
        return servicioBusqueda.getLocalidades();
    }

    private void thenNoEncuentroPublicaciones(List<Publicacion> publicaciones) {
        assertThat(publicaciones).isNull();
    }


    private void thenEncuentroPublicaciones(List<Publicacion> publicaciones) {
        assertThat(publicaciones).isNotNull();
        verify(repositorioBusqueda, times(1)).obtenerPublicacionesPorLocalidad(PUBLICACION.getLocalidad().getDescripcion());
    }

    private void thenObtengoLocalidades(List<Localidad> localidades) {
        assertThat(localidades).isNotNull();
    }
}
