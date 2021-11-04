package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioBusquedaTest {

    private RepositorioBusqueda repositorioBusqueda = mock(RepositorioBusqueda.class);
    private ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repositorioBusqueda);

    @Test
    public void obtengoTodasLasLocalidades() {
        givenQueExistenLocalidades();
        List<Localidad> localidades = whenObtengoLocalidades();
        thenObtengoLocalidades(localidades);

    }

    private void givenQueExistenLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad(1L, "San justo"));
        when(repositorioBusqueda.obtenerTodasLasLocalidades()).thenReturn(localidades);
    }

    private List<Localidad> whenObtengoLocalidades() {
        return servicioBusqueda.getLocalidades();
    }

    private void thenObtengoLocalidades(List<Localidad> localidades) {
        assertThat(localidades).isNotNull();
    }
}
