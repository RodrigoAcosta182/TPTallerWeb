package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

public class ServicioPublicacionTest {

    private RepositorioPublicacion repositorioPublicacion = mock(RepositorioPublicacion.class);
    private ServicioPublicacion servicioPublicacion = new ServicioPublicacionImpl(repositorioPublicacion);

    private static final String RAZA = "American Bully";
    private static final Long ID = 22L;
    private static final Publicacion PUBLICACION = new Publicacion();
    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Rodrigo","1","1","3 Anios","American Bully","Le falta una pata","Blanco","Chico", new Date(), new Publicacion(),mock(MultipartFile.class),"nashe");

    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com","123");

    @Test(expected = Exception.class)
    public void queSeNoSeEncontroPublicaciones() throws Exception {
        givenQueLaPublicacionNoExiste();
        List<Publicacion> publicaciones = whenObtengoPublicaciones();
        thenExistenPublicaciones(publicaciones);
    }

    @Test
    public void queSeEncuentraUnaPublicacionPorId(){
        givenQueLaPublicacionExiste(10L);
        Publicacion publicacion = whenObtengoPublicacionPor(10L);
        thenEncuentroUnaPublicacion(publicacion);
    }
    @Test
    public void queSeRegistrePublicacionExitosamente() throws Exception {
        givenQueLaPublicacionNoExiste();
        Publicacion publicacion = whenRegistroPublicacionCon();
        thenRegistroExitoso(publicacion);
    }

    @Test
    public void queSeFinalizaLaPublicacionCorrectamente(){
        givenQueLaPublicacionExiste(10L);
        whenFinalizoLaPublicacion(10L);
        thenFinalizoLaPublicacionCorrectamente();
    }


    private void givenQueLaPublicacionExiste(Long id) {
        when(repositorioPublicacion.buscarPublicacionPorId(id)).thenReturn(PUBLICACION);
    }

    public void givenQueLaPublicacionNoExiste() {
        when(repositorioPublicacion.buscarTodasLasPublicacionesPerdidas()).thenReturn(null);
    }

    private void whenFinalizoLaPublicacion(Long id) {
        servicioPublicacion.finalizarPublicacion(id);
    }
    private Publicacion whenObtengoPublicacionPor(Long id) {
        return servicioPublicacion.buscarPublicacion(id);
    }

    private List<Publicacion> whenObtengoPublicaciones() throws Exception {
        return  servicioPublicacion.listarTodasLasPublicacionesPerdidas();
    }

    private Publicacion whenRegistroPublicacionCon() throws Exception {

        return servicioPublicacion.registrarPublicacion(MASCOTA, USUARIO) ;
    }
    private void thenEncuentroUnaPublicacion(Publicacion publicacion) {
        assertThat(publicacion).isNotNull();
        verify(repositorioPublicacion,times(1)).buscarPublicacionPorId(10L);
    }

    private void thenExistenPublicaciones(List<Publicacion> publicaciones) {
        assertThat(publicaciones).isNull();
    }

    private void thenRegistroExitoso(Publicacion publicacion) {
        assertThat(publicacion).isNotNull();
    }

    private void thenFinalizoLaPublicacionCorrectamente() {
        verify(repositorioPublicacion,times(1)).finalizarPublicacion(PUBLICACION);
    }

}






