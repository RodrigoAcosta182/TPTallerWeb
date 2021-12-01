package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.*;
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
    public List<Publicacion> buscarPublicaciones(DatosRegistroMascota mascota) throws Exception {

        Publicacion nuevaPublicacion = mascota.toPublicacion();
        if (mascota.getPublicacion() != null) {
            if (mascota.getPublicacion().getLocalidad().getDescripcion() != null) {
                nuevaPublicacion.setLocalidad(mascota.getPublicacion().getLocalidad());
            }
        }
        List<Publicacion> publicacionList = repositorioBusqueda.buscarPublicacionPor(nuevaPublicacion);
        if (publicacionList.size() == 0) {
            throw new Exception("No se encontro ninguna publicacion");
        }
        return publicacionList;
    }

    @Override
    public List<Localidad> getLocalidades() {
        return repositorioBusqueda.obtenerTodasLasLocalidades();
    }

    @Override
    public List<Tipo> getTiposDeMascota() {
        return repositorioBusqueda.obtenerTodosLosTiposDeMascota();
    }

    @Override
    public List<Estado> getEstadosDeMascota() {
        return repositorioBusqueda.obtenerTodosLosEstadosDeMascota();
    }
}
