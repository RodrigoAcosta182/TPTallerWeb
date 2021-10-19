package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Override
    public Publicacion registrarPublicacion(DatosRegistroMascota mascota, Usuario usuario)throws Exception {

        if (mascota.getTipo() == null || mascota.getEstado() == null)
            throw new Exception();
        Publicacion nuevaPublicacion = new Publicacion();
        Mascota nuevaMascota = new Mascota();

        nuevaMascota.setEstado(mascota.getEstado());
        nuevaMascota.setTipo(mascota.getTipo());
        nuevaMascota.setNombre(mascota.getNombre());
        nuevaMascota.setEdad(mascota.getEdad());
        nuevaMascota.setRaza(mascota.getRaza());
        nuevaMascota.setColor(mascota.getColor());
        nuevaMascota.setDetalle(mascota.getDetalle());
        nuevaMascota.setTamanio(mascota.getTamanio());
        nuevaMascota.setFecha(mascota.getFecha());

        nuevaPublicacion.setFechaPublicacion(new Date());
        nuevaPublicacion.setUsuario(usuario);
        nuevaPublicacion.setMascota(nuevaMascota);

        repositorioPublicacion.guardarPublicacion(nuevaPublicacion);

        return nuevaPublicacion;
    }
}
