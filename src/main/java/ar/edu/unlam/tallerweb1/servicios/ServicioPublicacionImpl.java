package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioPublicacion")
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion{

    private final RepositorioPublicacion repositorioPublicacion;

    @Autowired
    public ServicioPublicacionImpl(RepositorioPublicacion repositorioPublicacion){
        this.repositorioPublicacion = repositorioPublicacion;
    }
    @Override
    public List<Publicacion> listarTodasLasPublicaciones() throws Exception {

        if(repositorioPublicacion.buscarTodasLasPublicaciones().size() == 0)
            throw  new Exception();
        return repositorioPublicacion.buscarTodasLasPublicaciones();
    }
}
