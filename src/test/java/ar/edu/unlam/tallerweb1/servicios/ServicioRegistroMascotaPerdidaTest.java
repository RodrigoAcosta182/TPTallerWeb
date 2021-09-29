package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMascotaPerdida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServicioRegistroMascotaPerdidaTest {

    private RepositorioMascotaPerdida repositorioMascotaPerdida = mock(RepositorioMascotaPerdida.class);

    private ServicioRegistrarMascotaPerdida servicioRegistrarMascotaPerdida = new ServicioRegistrarMascotaPerdidaImpl(repositorioMascotaPerdida);

    @Test
    public void queElFormularioSeGuardeExitosamente() throws Exception {
        Mascota mascota = whenLlenoElFormularioDeMascotaPerdida();
        thenElformularioSeGuardoCorrectamente(mascota);

    }

    private void thenElformularioSeGuardoCorrectamente(Mascota mascota) {
        assertThat(mascota).isNull();
    }

    private Mascota whenLlenoElFormularioDeMascotaPerdida() throws Exception{
        return servicioRegistrarMascotaPerdida.registrarMascotaPerdida("Cormier","Raza", 7, "American Bully", "gordo y petizo"
        ,"Marron","mediano",new Date());
    }
}
