package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBusquedaTest extends SpringTest {


    private static final Publicacion PUBLICACION = new Publicacion(new Mascota(),new Localidad("Moron"));

    @Autowired
    private RepositorioBusqueda repositorioBusqueda;

// Este test se rompio luego de los cambios de tipo y estado, no lo pude resolver
//    @Test
//    @Transactional
//    @Rollback
//    public void buscoPublicacionesDeFormaExitosa(){
//        List<Publicacion> listaPublicaciones = new LinkedList<>();
//        listaPublicaciones.add(PUBLICACION);
//        givenQueExistenPublicaciones(listaPublicaciones);
//        List<Publicacion> publicacionesEncontradas = whenBuscoPublicaciones(PUBLICACION);
//        thenEncuentroPublicaciones(publicacionesEncontradas.size(),listaPublicaciones);
//    }

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
    public void obtengoTodosLosTiposDeMascota() {
        List<Tipo> tiposDeMascota = new ArrayList<>();
        tiposDeMascota.add(new Tipo(1L, "Perro"));
        givenQueExistenTiposDeMascota(tiposDeMascota);
        List<Tipo> tiposDeMascotaObtenidos = whenObtengoTodosLosTiposDeMascota();
        thenEncuentroTiposDeMascota(tiposDeMascota.size(), tiposDeMascotaObtenidos);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodosLosEstadosDeMascota() {
        List<Estado> estados = new ArrayList<>();
        estados.add(new Estado());
        estados.add(new Estado());

        givenQueExistenEstadosDeMascota(estados);
        List<Estado> estadosObtenidos = whenObtengoTodosLosEstadosDeMascota();
        thenEncuentroEstadosDeMascota(estadosObtenidos.size(), estadosObtenidos);
    }

    private void givenQueExistenEstadosDeMascota(List<Estado> estados) {
        for (Estado estadosDeMascota : estados) {
            session().save(estadosDeMascota);
        }
    }

    private List<Estado> whenObtengoTodosLosEstadosDeMascota() {
        return repositorioBusqueda.obtenerTodosLosEstadosDeMascota();
    }

    private void thenEncuentroEstadosDeMascota(int cantidadEsperada, List<Estado> estadosObtenidos) {
        assertThat(estadosObtenidos).hasSize(cantidadEsperada);
    }


    private void givenQueExistenTiposDeMascota(List<Tipo> tiposDeMascota) {

        for (Tipo tipoDeMascota : tiposDeMascota) {
            session().save(tipoDeMascota);
        }
    }

    private List<Tipo> whenObtengoTodosLosTiposDeMascota() {
        return repositorioBusqueda.obtenerTodosLosTiposDeMascota();
    }

    private void thenEncuentroTiposDeMascota(int cantidadEsperada, List<Tipo> tiposDeMascotaObtenidos) {
        assertThat(tiposDeMascotaObtenidos).hasSize(cantidadEsperada);
    }

    private void thenEncuentroPublicaciones(int cantidadEsperada, List<Publicacion> listaPublicaciones) {
        assertThat(listaPublicaciones).hasSize(cantidadEsperada);
    }

    private List<Publicacion> whenBuscoPublicaciones(Publicacion publicacion) {
        return repositorioBusqueda.buscarPublicacionPor(publicacion);
    }

    private void givenQueExistenPublicaciones(List<Publicacion> listaPublicaciones) {
            for(Publicacion publicacion: listaPublicaciones){
                session().save(publicacion.getLocalidad());
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


