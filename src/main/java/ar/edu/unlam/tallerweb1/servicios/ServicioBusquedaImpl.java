package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return null;
    }

    @Override
    public List<Localidad> getLocalidades() {
        return repositorioBusqueda.obtenerTodasLasLocalidades();
    }
}
