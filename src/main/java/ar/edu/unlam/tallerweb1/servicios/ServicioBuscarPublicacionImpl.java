package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBuscarPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioBuscarMascota")
@Transactional
public class ServicioBuscarPublicacionImpl implements ServicioBuscarPublicacion {

    private RepositorioBuscarPublicacion repositorioBuscarPublicacion;
    @Autowired
    public ServicioBuscarPublicacionImpl(RepositorioBuscarPublicacion repositorioBuscarPublicacion) {
        this.repositorioBuscarPublicacion = repositorioBuscarPublicacion;
    }

    @Override
    public Publicacion buscarPublicacion(DatosRegistroMascota mascota) {
    return null;
    }
}
