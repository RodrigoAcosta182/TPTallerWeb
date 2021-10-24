package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;

public class ServicioPublicacionTest {
    private RepositorioPublicacion repositorioPublicacion = mock(RepositorioPublicacion.class);
    private ServicioPublicacion servicioPublicacion = new ServicioPublicacionImpl(repositorioPublicacion);



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

    private void thenEncuentroUnaPublicacion(Publicacion publicacion) {
        assertThat(publicacion).isNotNull();
        verify(repositorioPublicacion,times(1)).buscarPublicacionPorId(10L);
//        verify(repositorioPublicacion,times(1)).buscarPublicacionPorId(publicacion.getId());
    }

    private Publicacion whenObtengoPublicacionPor(Long id) {
        return servicioPublicacion.buscarPublicacion(id);
    }

    private void givenQueLaPublicacionExiste(Long id) {
        when(repositorioPublicacion.buscarPublicacionPorId(id)).thenReturn(new Publicacion());
    }

    private void thenExistenPublicaciones(List<Publicacion> publicaciones) {
        assertThat(publicaciones).isNull();
    }

    private List<Publicacion> whenObtengoPublicaciones() throws Exception {
        return  servicioPublicacion.listarTodasLasPublicacionesPerdidas();
    }

    private void givenQueLaPublicacionNoExiste() {
        when(repositorioPublicacion.buscarTodasLasPublicacionesPerdidas()).thenReturn(null);
    }



}












// TEST A REVISAR Y PONER EN ESTE ARCHIVO
//public class ServicioRegistroMascotaTest {
//
//    private static final Long ID = Long.valueOf(4516);
//    private static final String RAZA = "Pekines";
//    private RepositorioRegistrarMascota repositorioRegistrarMascota = mock(RepositorioRegistrarMascota.class);
//
//    private static final Usuario usuario = new Usuario();
//
//    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Rodrigo","Perro","1","nada","Pekines","Le falta una pata","Blanco","Chico", new Date(), new Publicacion());
//
//    private ServicioRegistrarMascota servicioRegistrarMascota = new ServicioRegistrarMascotaImpl(repositorioRegistrarMascota);
//
//    @Test
//    public void queSeRegistreUnaMascotaExitosamente() throws Exception {
//        givenMascotaNoExiste(ID);
//        Mascota mascota = whenRegistroMascotaCon(ID);
//        thenRegistroExitoso(mascota);
//    }
//
//    private void givenMascotaNoExiste(Long id) {
//        when(repositorioRegistrarMascota.buscarPorId(id)).thenReturn(null);
//    }
//
//    private Mascota whenRegistroMascotaCon(Long id) throws Exception {
//
//        return servicioRegistrarMascota.registrarMascotaPerdida(MASCOTA) ;
//    }
//
//    private void thenRegistroExitoso(Mascota mascota) {
//        assertThat(mascota).isNotNull();
//        assertThat(mascota.getRaza()).isEqualTo(RAZA);
//        //verify(repositorioMascotaPerdida, times(1)).guardarMascota(any()); falla: dice wanted but not invoked
//    }
//
//}


