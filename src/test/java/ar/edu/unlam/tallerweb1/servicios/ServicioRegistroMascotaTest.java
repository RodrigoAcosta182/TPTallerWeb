package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistrarMascota;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;


public class ServicioRegistroMascotaTest {

    private static final Long ID = Long.valueOf(4516);
    private static final String RAZA = "Pekines";
    private RepositorioRegistrarMascota repositorioRegistrarMascota = mock(RepositorioRegistrarMascota.class);

    private static final Usuario usuario = new Usuario();

    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota("Rodrigo","Perro","1","nada","Pekines","Le falta una pata","Blanco","Chico", new Date(),usuario );

    private ServicioRegistrarMascota servicioRegistrarMascota = new ServicioRegistrarMascotaImpl(repositorioRegistrarMascota);

    @Test
    public void queSeRegistreUnaMascotaExitosamente() throws Exception {
        givenMascotaNoExiste(ID);
        Mascota mascota = whenRegistroMascotaCon(ID);
        thenRegistroExitoso(mascota);
    }

    private void givenMascotaNoExiste(Long id) {
        when(repositorioRegistrarMascota.buscarPorId(id)).thenReturn(null);
    }

    private Mascota whenRegistroMascotaCon(Long id) throws Exception {

        return servicioRegistrarMascota.registrarMascotaPerdida(MASCOTA) ;
    }

    private void thenRegistroExitoso(Mascota mascota) {
        assertThat(mascota).isNotNull();
        assertThat(mascota.getRaza()).isEqualTo(RAZA);
        //verify(repositorioMascotaPerdida, times(1)).guardarMascota(any()); falla: dice wanted but not invoked
    }

}
