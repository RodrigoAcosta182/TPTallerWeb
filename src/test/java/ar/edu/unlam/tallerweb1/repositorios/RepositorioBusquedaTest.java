package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBusquedaTest extends SpringTest {

    private static final Publicacion PUBLICACION = new Publicacion(new Localidad("Moron"));

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

    @Test
    @Transactional
    @Rollback
    public void buscoPublicacionesPorLocalidadExitosamente(){
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(PUBLICACION);

        givenQueExistenPublicaciones(listaPublicaciones);
        List<Publicacion> publicacionesEncontradas = whenBuscoPublicacionesPorLocalidad(PUBLICACION);
        thenEncuentroPublicaciones(publicacionesEncontradas.size(),listaPublicaciones);
    }

    private void thenEncuentroPublicaciones(int cantidadEsperada, List<Publicacion> listaPublicaciones) {
        assertThat(listaPublicaciones).hasSize(cantidadEsperada);
    }

    private List<Publicacion> whenBuscoPublicacionesPorLocalidad(Publicacion publicacion) {
        return repositorioBusqueda.obtenerPublicacionesPorLocalidad(publicacion.getLocalidad().getDescripcion());
    }

    private void givenQueExistenPublicaciones(List<Publicacion> listaPublicaciones) {
        for(Publicacion publicacion: listaPublicaciones){
            session().save(publicacion);
        }
    }


    private void givenExistenLocalidades(List<Localidad> localidades) {
        for (Localidad localidad : localidades){
            session().save(localidad);
        }
    }
    private List<Localidad> whenObtengoTodasLasLocalidades() {
        return repositorioBusqueda.obtenerTodasLasLocalidades();
    }
    private void thenObtengoTodasLaslocalidades(int cantidadEsperada, List<Localidad> localidadesObtenidas) {
        assertThat(localidadesObtenidas).hasSize(cantidadEsperada);
    }


}
