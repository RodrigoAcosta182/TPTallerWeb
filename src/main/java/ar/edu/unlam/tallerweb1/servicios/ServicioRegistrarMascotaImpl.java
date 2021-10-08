package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistrarMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Mascota registrarMascotaPerdida(DatosRegistroMascota mascota) throws Exception {
        Mascota nuevaMascota = new Mascota();
        nuevaMascota.setNombre(mascota.getNombre());
        nuevaMascota.setTipo(mascota.getTipo());
        nuevaMascota.setEdad(mascota.getEdad());
        nuevaMascota.setRaza(mascota.getRaza());
        nuevaMascota.setDetalle(mascota.getDetalle());
        nuevaMascota.setColor(mascota.getColor());
        nuevaMascota.setTamanio(mascota.getTamanio());
        nuevaMascota.setFecha(mascota.getFecha());
//        nuevaMascota.getUsuario();

        repositorioRegistrarMascota.guardarMascota(nuevaMascota);
        return nuevaMascota;
    }
}
