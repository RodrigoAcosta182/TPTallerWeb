package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
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
    public List<Publicacion> buscarPublicaciones(DatosRegistroMascota mascota) throws Exception {
        List<Publicacion> publicacionList = new ArrayList<>();
            Publicacion buscarPublicacion = mascota.getPublicacion();
            buscarPublicacion.setMascota(mascota.toMascota());
            buscarPublicacion.setLocalidad(mascota.getPublicacion().getLocalidad());
            publicacionList = repositorioBusqueda.buscarPublicacionPor(buscarPublicacion);
            if (publicacionList.size() == 0) {
                throw new Exception("No se encontro ninguna publicacion");
            }
        return publicacionList;
    }

    @Override
    public List<Localidad> getLocalidades() {
        return repositorioBusqueda.obtenerTodasLasLocalidades();
    }
}
