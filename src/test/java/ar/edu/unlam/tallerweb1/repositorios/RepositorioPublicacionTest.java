//package ar.edu.unlam.tallerweb1.repositorios;
//
//import ar.edu.unlam.tallerweb1.SpringTest;
//import ar.edu.unlam.tallerweb1.modelo.Publicacion;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class RepositorioPublicacionTest extends SpringTest {
//
//    private final Usuario USUARIO = new Usuario("mascote@mascote.com", "1234");
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
//    private List<Publicacion> whenBuscoLasPublicacionesDelUsuario(Usuario usuario) {
//        return repositorioPublicaciones.buscarPor(usuario);
//    }
//
//    private void thenEncuentro(int cantidadEsperada, List<Publicacion> publicaciones) {
//        assertThat(publicaciones).hasSize(cantidadEsperada);
//    }
//
//    private void givenElUsuarioConPublicaciones(Usuario usuario, List<Publicacion> publicacionesDelUsuario) {
//        session().save(usuario);
//        for (Publicacion publi : publicacionesDelUsuario){
//            publi.setUsuarioId(usuario);
//            session().save(publi);
//        }
//    }
//}
