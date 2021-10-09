package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioBuscarMascota")
@Transactional
public class ServicioBuscarPublicacionImpl implements ServicioBuscarPublicacion {


    @Override
    public void buscarPublicacion(DatosRegistroMascota mascota) {

    }
}
