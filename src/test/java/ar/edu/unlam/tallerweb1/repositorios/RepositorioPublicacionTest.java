package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;



import static org.assertj.core.api.Assertions.assertThat;


public class RepositorioPublicacionTest extends SpringTest {

    private static final Usuario USUARIO = new Usuario();
    private static final String PERDIDO = "1";
    private static final String ENCONTRADO = "2";

    @Autowired
    private RepositorioPublicacion repositorioPublicacion;


    @Test(expected = Exception.class)
    @Transactional
    @Rollback
    public void obtengoUnaPublicacionPorId() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());

        givenExistePublicacionConId(1L,listaPublicaciones);
        Publicacion publicacion = whenObtengoLaPublicacionPorId(1L);
        thenObtengoPublicacion(publicacion);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoMisPublicaciones() {
        List<Publicacion> misPublicaciones = new LinkedList<>();
        misPublicaciones.add(new Publicacion());
        misPublicaciones.add(new Publicacion());

        givenElUsuarioConPublicaciones(USUARIO, misPublicaciones);

        List<Publicacion> publicaciones = whenBuscoLasPublicacionesDelUsuario(USUARIO);

        thenEncuentro(misPublicaciones.size(), publicaciones);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodasLasPublicacionesDeMascotasPerdidas() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());

        givenExistenPublicacionesDeMascotas(listaPublicaciones, PERDIDO);
        List<Publicacion> publicacionesDeMascotasPerdidas = whenObtengoTodasLasPublicacionesDeMascotasPerdidas();
        thenEncuentro(listaPublicaciones.size(), publicacionesDeMascotasPerdidas);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodasLasPublicacionesDeMascotasEncontradas() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());

        givenExistenPublicacionesDeMascotas(listaPublicaciones, ENCONTRADO);
        List<Publicacion> publicacionesDeMascotasEncontradas = whenObtengoTodasLasPublicacionesDeMascotasEncontradas();
        thenEncuentro(listaPublicaciones.size(), publicacionesDeMascotasEncontradas);
    }

    @Test(expected = Exception.class)
    @Transactional
    @Rollback
    public void finalizoPublicacionCorrectamente(){
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());
        givenExistenMisPublicaciones(listaPublicaciones);
        whenFinalizoUnaPublicacion(1L);
        thenFinalizoPublicacion(1L,true);

    }

    private void thenFinalizoPublicacion(Long id, Boolean finalizado) {
        Publicacion publicacion =  repositorioPublicacion.buscarPublicacionPorId(id);
        assertThat(publicacion.getFinalizado()).isEqualTo(finalizado);
    }

    private void givenExistenMisPublicaciones(List<Publicacion> listaPublicaciones ) {
        for(Publicacion publicacion :listaPublicaciones ){
            session().save(publicacion);
        }
    }

    private void whenFinalizoUnaPublicacion(Long id) {
        repositorioPublicacion.finalizarPublicacion(id);
    }

    private void givenExistenPublicacionesDeMascotas(List<Publicacion> publicaciones, String estado) {
        for (Publicacion publicacion : publicaciones) {
            publicacion.setEstado(estado);
            session().save(publicacion);
        }
    }

    private void givenExistePublicacionConId(Long id, List<Publicacion> listaPublicaciones) {
        for(Publicacion publicacion : listaPublicaciones){
            publicacion.setId(id);
            session().save(publicacion);
        }
    }

    private void givenElUsuarioConPublicaciones(Usuario usuario, List<Publicacion> publicacionesDelUsuario) {
        session().save(usuario);
        for (Publicacion publicacion : publicacionesDelUsuario) {
            publicacion.setUsuario(usuario);
            session().save(publicacion);
        }
    }

    private Publicacion whenObtengoLaPublicacionPorId(Long id) {
        return repositorioPublicacion.buscarPublicacionPorId(id);
    }

    private List<Publicacion> whenBuscoLasPublicacionesDelUsuario(Usuario usuario) {
        return repositorioPublicacion.buscarTodasMisPublicaciones(usuario);
    }

    private List<Publicacion> whenObtengoTodasLasPublicacionesDeMascotasPerdidas() {
        return repositorioPublicacion.buscarTodasLasPublicacionesPerdidas();

    }

    private List<Publicacion> whenObtengoTodasLasPublicacionesDeMascotasEncontradas() {
        return repositorioPublicacion.buscarTodasLasPublicacionesEncontradas();
    }

    private void thenObtengoPublicacion(Publicacion publicacion) {
        assertThat(publicacion.getClass()).isEqualTo(Publicacion.class);
    }

    private void thenEncuentro(int cantidadEsperada, List<Publicacion> publicaciones) {
        assertThat(publicaciones).hasSize(cantidadEsperada);
    }

}

