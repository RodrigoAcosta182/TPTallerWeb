package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBusquedaTest extends SpringTest {


    @Autowired
    private RepositorioBusqueda repositorioBusqueda;

    @Test
    @Transactional
    @Rollback
    public void obtengoTodasLasLocalidades(){
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad("Mataderos"));

        givenExistenLocalidades(localidades);
        List<Localidad> localidadesObtenidas = whenObtengoTodasLasLocalidades();
        thenObtengoTodasLaslocalidades(localidades.size(),localidadesObtenidas);
    }

    private void thenObtengoTodasLaslocalidades(int cantidadEsperada, List<Localidad> localidadesObtenidas) {
        assertThat(localidadesObtenidas).hasSize(cantidadEsperada);
    }

    private List<Localidad> whenObtengoTodasLasLocalidades() {
        return repositorioBusqueda.obtenerTodasLasLocalidades();
    }

    private void givenExistenLocalidades(List<Localidad> localidades) {
        for (Localidad localidad : localidades){
            session().save(localidad);
        }
    }
}
