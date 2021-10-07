package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;

import java.util.Date;

public interface ServicioRegistrarMascota {


    Mascota registrarMascotaPerdida(DatosRegistroMascota mascota) throws Exception;
}
