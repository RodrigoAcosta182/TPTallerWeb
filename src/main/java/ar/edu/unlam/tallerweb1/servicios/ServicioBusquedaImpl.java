package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("servicioBusqueda")
public class ServicioBusquedaImpl implements ServicioBusqueda{


    @Override
    public List<Publicacion> buscarPublicaciones(DatosRegistroMascota mascota) {
        return null;
    }
}
