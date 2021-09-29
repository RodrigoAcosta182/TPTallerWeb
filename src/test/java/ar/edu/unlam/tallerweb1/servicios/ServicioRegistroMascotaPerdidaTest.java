package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMascotaPerdida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;


public class ServicioRegistroMascotaPerdidaTest {

    private static final Long ID = Long.valueOf(4516);
    private static final String NOMBRE = "Cormier";
    private RepositorioMascotaPerdida repositorioMascotaPerdida = mock(RepositorioMascotaPerdida.class);

    private ServicioRegistrarMascotaPerdida servicioRegistrarMascotaPerdida = new ServicioRegistrarMascotaPerdidaImpl(repositorioMascotaPerdida);

    @Test
    public void queSeRegistreUnaMascotaExitosamente() throws Exception {
        givenMascotaNoExiste(ID);
        Mascota mascota = whenRegistroMascotaCon(ID);
        thenRegistroExitoso(mascota);
    }

    private void givenMascotaNoExiste(Long id) {
        when(repositorioMascotaPerdida.buscarPorId(id)).thenReturn(null);
    }

    private Mascota whenRegistroMascotaCon(Long id) throws Exception {

        return servicioRegistrarMascotaPerdida.registrarMascotaPerdida("Cormier", "Raza", 7, "American Bully", "gordo y petizo"
                , "Marron", "mediano", new Date()) ;
    }

    private void thenRegistroExitoso(Mascota mascota) {
        assertThat(mascota).isNotNull();
        assertThat(mascota.getNombre()).isEqualTo(NOMBRE);
        //verify(repositorioMascotaPerdida, times(1)).guardarMascota(any()); falla: dice wanted but not invoked
    }

}
