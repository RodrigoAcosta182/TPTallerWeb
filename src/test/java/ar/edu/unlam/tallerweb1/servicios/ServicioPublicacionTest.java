package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioPublicacionTest {
    private RepositorioPublicacion repositorioPublicacion = mock(RepositorioPublicacion.class);
    private ServicioPublicacion servicioPublicacion = new ServicioPublicacionImpl(repositorioPublicacion);

    @Test(expected = Exception.class)
    public void queSeNoSeEncontroPublicaciones() throws Exception {
        givenQueLaPublicacionNoExiste();
        List<Publicacion> publicaciones = whenObtengoPublicaciones();
        thenExistenPublicaciones(publicaciones);
    }

    private void thenExistenPublicaciones(List<Publicacion> publicaciones) {
        assertThat(publicaciones).isNull();
    }

    private List<Publicacion> whenObtengoPublicaciones() throws Exception {
        return  servicioPublicacion.listarTodasLasPublicaciones();
    }

    private void givenQueLaPublicacionNoExiste() {
        when(repositorioPublicacion.buscarTodasLasPublicaciones()).thenReturn(null);
    }
}


