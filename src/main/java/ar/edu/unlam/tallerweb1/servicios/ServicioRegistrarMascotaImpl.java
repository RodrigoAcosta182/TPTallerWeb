package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistrarMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("servicioRegistrarMascotaPerdida")
@Transactional
public class ServicioRegistrarMascotaImpl implements ServicioRegistrarMascota {

    private RepositorioRegistrarMascota repositorioRegistrarMascota;

    @Autowired
    public ServicioRegistrarMascotaImpl(RepositorioRegistrarMascota repositorioRegistrarMascota) {
        this.repositorioRegistrarMascota = repositorioRegistrarMascota;

    }


    @Override
    public Mascota registrarMascotaPerdida(DatosRegistroMascota mascota,HttpServletRequest request) throws Exception {

        Mascota nuevaMascota = new Mascota();
        if (mascota.getTipo() == null || mascota.getEstado() == null)
            throw new Exception();
        nuevaMascota.setEstado(mascota.getEstado());
        nuevaMascota.setTipo(mascota.getTipo());
        nuevaMascota.setNombre(mascota.getNombre());
        nuevaMascota.setEdad(mascota.getEdad());
        nuevaMascota.setRaza(mascota.getRaza());
        nuevaMascota.setDetalle(mascota.getDetalle());
        nuevaMascota.setColor(mascota.getColor());
        nuevaMascota.setTamanio(mascota.getTamanio());
        nuevaMascota.setFecha(mascota.getFecha());

        Publicacion publicacion = new Publicacion();
        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
        publicacion.setFechaPublicacion(new Date());
        publicacion.setFinalizado(0);
        publicacion.setUsuarioId(usuario);
        publicacion.setMascota(nuevaMascota);

        repositorioRegistrarMascota.guardarMascota(nuevaMascota);
        return nuevaMascota;
    }
}
