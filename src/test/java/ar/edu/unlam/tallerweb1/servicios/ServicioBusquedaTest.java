package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioBusquedaTest {

    private RepositorioBusqueda repositorioBusqueda = mock(RepositorioBusqueda.class);
    private ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repositorioBusqueda);
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Lucas", "1",
            "1", "3 Anios", "American Bully", "Le falta una pata", "Blanco",
            "Chico", new Date(), new Publicacion(), mock(MultipartFile.class));

    @Test
    public void obtengoTodasLasLocalidades() {
        givenQueExistenLocalidades();
        List<Localidad> localidades = whenObtengoLocalidades();
        thenObtengoLocalidades(localidades);

    }

    @Test
    public void buscoPublicacionesPorLocalidadExitosamente() {
        givenQueLasPublicacionesExiten();
        //List<Publicacion> publicaciones = whenObtengoPublicacionesPorLocalidad();
        //thenEncuentroPublicaciones(publicaciones);
    }

    private void thenEncuentroPublicaciones(List<Publicacion> publicaciones) {
    }

    private List<Publicacion> whenObtengoPublicacionesPorLocalidad() {
        return servicioBusqueda.buscarPublicaciones(MASCOTA);
    }

    private void givenQueLasPublicacionesExiten() {
        List<Publicacion> publicaciones = new ArrayList<>();

        Publicacion publicacion = new Publicacion();
        Localidad localidad = new Localidad(1L, "Moron");

        publicacion.setLocalidad(localidad);
        publicaciones.add(publicacion);
        when(repositorioBusqueda.obtenerPublicacionesPorLocalidad(publicacion.getLocalidad().getDescripcion())).thenReturn(publicaciones);
    }

    private void givenQueExistenLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad(1L, "San Justo"));
        when(repositorioBusqueda.obtenerTodasLasLocalidades()).thenReturn(localidades);
    }

    private List<Localidad> whenObtengoLocalidades() {
        return servicioBusqueda.getLocalidades();
    }

    private void thenObtengoLocalidades(List<Localidad> localidades) {
        assertThat(localidades).isNotNull();
    }
}
