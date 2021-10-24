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




}
//
//    private final Usuario USUARIO = new Usuario("mascota@mascota.com", "1234");
//    @Autowired
//    private RepositorioPublicacion repositorioPublicaciones;
//
//    @Test @Transactional @Rollback
//    public void obtengoLasPublicacionesDeUnUsuario() {
//        List<Publicacion> publicacionesDelUsuario = new LinkedList<>();
//        publicacionesDelUsuario.add(new Publicacion());
//        publicacionesDelUsuario.add(new Publicacion());
//
//        givenElUsuarioConPublicaciones(USUARIO, publicacionesDelUsuario);
//
//        List<Publicacion> publicaciones = whenBuscoLasPublicacionesDelUsuario(USUARIO);
//
//        thenEncuentro(publicacionesDelUsuario.size(), publicaciones);
//    }
//
//    @Test @Transactional @Rollback
//    public void obtengoTodasLasPublicaciones(){
//        List<Publicacion> listaPublicaciones = new LinkedList<>();
//        listaPublicaciones.add(new Publicacion());
//        listaPublicaciones.add(new Publicacion());
//        listaPublicaciones.add(new Publicacion());
//        listaPublicaciones.add(new Publicacion());
//
//        givenObtengoTodasLasPublicaciones(listaPublicaciones);
//        List<Publicacion> publicaciones = whenObtengoTodasLasPublicaciones();
//        thenEncuentro(listaPublicaciones.size(),publicaciones);
//    }
//
//    private List<Publicacion> whenObtengoTodasLasPublicaciones() {
//        return repositorioPublicaciones.buscarTodasLasPublicaciones();
//    }
//
//
//    private List<Publicacion> whenBuscoLasPublicacionesDelUsuario(Usuario usuario) {
//        return repositorioPublicaciones.buscarPor(usuario);
//    }
//
//
//    private void givenElUsuarioConPublicaciones(Usuario usuario, List<Publicacion> publicacionesDelUsuario) {
//        session().save(usuario);
//        for (Publicacion publicacion : publicacionesDelUsuario){
//            publicacion.setUsuarioId(usuario);
//            session().save(publicacion);
//        }
//    }
//    private void givenObtengoTodasLasPublicaciones(List<Publicacion> publicaciones) {
//        for (Publicacion publicacion : publicaciones){
//            session().save(publicacion);
//        }
//    }
//    private void thenEncuentro(int cantidadEsperada, List<Publicacion> publicaciones) {
//        assertThat(publicaciones).hasSize(cantidadEsperada);
//    }
//}

//package ar.edu.unlam.tallerweb1.repositorios;
//
//import ar.edu.unlam.tallerweb1.SpringTest;
//import ar.edu.unlam.tallerweb1.modelo.Mascota;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class RepositorioMascotaTest extends SpringTest {
//
//    private static final String GATO = "GATO";
//    private static final String PERRO = "PERRO";
//
//    @Autowired
//    private RepositorioRegistrarMascota repositorioRegistrarMascota;
//
//    @Test
//    @Rollback @Transactional
//    public void buscarPorTipo(){
//        givenExistenTipo(PERRO, 2);
//        givenExistenTipo(GATO, 4);
//
//        List<Mascota> mascotas = whenBuscoMascotaPorTipo(PERRO);
//        List<Mascota> mascotas1 = whenBuscoMascotaPorTipo(GATO);
//
//        thenEncuentro(mascotas,2);
//        thenEncuentro(mascotas1,4);
//    }
//
//    private void givenExistenTipo(String tipo, int cantidadDeTipo) {
//        for (int i= 0; i < cantidadDeTipo; i++){
//            Mascota mascota = new Mascota();
//            mascota.setTipo(tipo);
//            session().save(mascota);
//        }
//    }
//
//    private List<Mascota> whenBuscoMascotaPorTipo(String tipo) {
//        return repositorioRegistrarMascota.buscarMascotaPorTipo(tipo);
//    }
//
//    private void thenEncuentro(List<Mascota> mascotas, int mascotasEncontradas) {
//        assertThat(mascotas).hasSize(mascotasEncontradas);
//    }
//
//
//}
