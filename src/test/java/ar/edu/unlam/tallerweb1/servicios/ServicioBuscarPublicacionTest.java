package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBuscarPublicacion;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import org.assertj.core.api.Assertions.*;

public class ServicioBuscarPublicacionTest {

    private RepositorioBuscarPublicacion repositorioBuscarPublicacion = mock(RepositorioBuscarPublicacion.class);
    private ServicioBuscarPublicacion servicioBuscarPublicacion = new ServicioBuscarPublicacionImpl(repositorioBuscarPublicacion);

    private static final DatosRegistroMascota MASCOTA = new DatosRegistroMascota();
    @Test
    public void queSeBuscaUnaPublicacionCorrectamente(){
        givenLaPublicacionExiste(MASCOTA);
        Publicacion publicacion = whenBuscoUnaPublicacionCorrectamente(MASCOTA);
        thenBuscoUnaPublicacionCorrectamente(publicacion);
    }

    private void thenBuscoUnaPublicacionCorrectamente(Publicacion publicacion) {
    }

    private Publicacion whenBuscoUnaPublicacionCorrectamente(DatosRegistroMascota mascota) {

        return repositorioBuscarPublicacion.buscarPublicacionPorTipo(mascota.getTipo());
    }

    private void givenLaPublicacionExiste(DatosRegistroMascota mascota) {
    }

}
