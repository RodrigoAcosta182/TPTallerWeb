package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioMascotaTest extends SpringTest {

    private static final String GATO = "GATO";
    private static final String PERRO = "PERRO";

    @Autowired
    private RepositorioMascotaPerdida repositorioMascotaPerdida;

    @Test
    @Rollback @Transactional
    public void buscarPorTipo(){
        givenExistenTipo(PERRO, 2);
        givenExistenTipo(GATO, 4);

        List<Mascota> mascotas = whenBuscoMascotaPorTipo(PERRO);
        List<Mascota> mascotas1 = whenBuscoMascotaPorTipo(GATO);

        thenEncuentro(mascotas,2);
        thenEncuentro(mascotas1,4);
    }

    private void givenExistenTipo(String tipo, int cantidadDeTipo) {
        for (int i= 0; i < cantidadDeTipo; i++){
            Mascota mascota = new Mascota();
            mascota.setTipo(tipo);
            session().save(mascota);
        }
    }

    private List<Mascota> whenBuscoMascotaPorTipo(String tipo) {
        return repositorioMascotaPerdida.buscarMascotaPorTipo(tipo);
    }

    private void thenEncuentro(List<Mascota> mascotas, int mascotasEncontradas) {
        assertThat(mascotas).hasSize(mascotasEncontradas);
    }


}
