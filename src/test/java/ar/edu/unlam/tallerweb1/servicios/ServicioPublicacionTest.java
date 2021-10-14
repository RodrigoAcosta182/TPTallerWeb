//package ar.edu.unlam.tallerweb1.servicios;
//
//import ar.edu.unlam.tallerweb1.modelo.Mascota;
//import ar.edu.unlam.tallerweb1.modelo.Publicacion;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
//import org.junit.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class ServicioPublicacionTest {
//    private RepositorioPublicacion repositorioPublicacion = mock(RepositorioPublicacion.class);
//    private ServicioPublicacion servicioPublicacion = new ServicioPublicacionImpl(repositorioPublicacion);
//
//    @Test
//    public void queSeEncontroAlmenosUnaPublicacion() throws Exception {
////        givenQueLaPublicacionExiste();
//        Integer publicacion = whenObtengoPublicaciones();
//        thenExistenPublicaciones(publicacion);
//    }
//
//    private void thenExistenPublicaciones(Integer publicacion) {
//        assertThat(publicacion).isNotNull();
//    }
//
//    private Integer whenObtengoPublicaciones() throws Exception {
//        return  servicioPublicacion.listarTodasLasPublicaciones().size();
//    }
//
////    private void givenQueLaPublicacionExiste() {
////        when(repositorioPublicacion.buscarTodosLasPublicaciones()).thenReturn((List<Publicacion>) new Publicacion());
////    }
//}
