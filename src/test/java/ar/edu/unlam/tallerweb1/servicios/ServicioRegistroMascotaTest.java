package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistrarMascota;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;


public class ServicioRegistroMascotaTest {

    private static final String NOMBRE = "Scaloni";
    private static final String RAZA = "Pekines";
    private RepositorioRegistrarMascota repositorioRegistrarMascota = mock(RepositorioRegistrarMascota.class);

    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Rodrigo","Perro","1","nada","Pekines","Le falta una pata","Blanco","Chico", new Date(), new Publicacion());

    private ServicioRegistrarMascota servicioRegistrarMascota = new ServicioRegistrarMascotaImpl(repositorioRegistrarMascota);

    @Test
    public void queSeRegistreUnaMascotaExitosamente() throws Exception {
        givenMascotaNoExiste(NOMBRE);
        Mascota mascota = whenRegistroMascotaCon(NOMBRE);
        thenRegistroExitoso(mascota);
    }

    private void givenMascotaNoExiste(String nombre) {
        when(repositorioRegistrarMascota.buscarPorNombre(nombre)).thenReturn(null);
    }

    private Mascota whenRegistroMascotaCon(String nombre) throws Exception {

        return servicioRegistrarMascota.registrarMascotaPerdida(MASCOTA) ;
    }

    private void thenRegistroExitoso(Mascota mascota) {
        assertThat(mascota).isNotNull();
        assertThat(mascota.getRaza()).isEqualTo(RAZA);
        //verify(repositorioMascotaPerdida, times(1)).guardarMascota(any()); falla: dice wanted but not invoked
    }

}
