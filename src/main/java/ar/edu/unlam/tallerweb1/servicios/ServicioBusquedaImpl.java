package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("servicioBusqueda")
public class ServicioBusquedaImpl implements ServicioBusqueda {


    private final RepositorioBusqueda repositorioBusqueda;

    @Autowired
    public ServicioBusquedaImpl(RepositorioBusqueda repositorioBusqueda) {
        this.repositorioBusqueda = repositorioBusqueda;
    }

    @Override
    public List<Publicacion> buscarPublicaciones(DatosRegistroMascota mascota) {
        List<Publicacion> publicacionList = new ArrayList<>();

        if (mascota.getEstado() != null
                && mascota.getTipo() != null
                && mascota.getColor() != null
                && mascota.getRaza() != null
                && mascota.getPublicacion().getLocalidad().getDescripcion() != null
        ) {
            publicacionList = repositorioBusqueda.buscarPublicaciones(mascota);
        } else {
            //hacer una busqueda con OR para que sea por varios parametros y no por todos
            // tambien hay que modificar los test
//        publicacionList = repositorioBusqueda.obtenerPublicacionesPorLocalidad(mascota.getPublicacion().getLocalidad().getDescripcion());
            publicacionList = repositorioBusqueda.obtenerPublicacionesConAlgunParametroNull(mascota);
        }
        return publicacionList;
    }

    @Override
    public List<Localidad> getLocalidades() {
        return repositorioBusqueda.obtenerTodasLasLocalidades();
    }
}
