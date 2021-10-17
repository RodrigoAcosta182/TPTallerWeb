package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public interface ServicioRegistrarMascota {


    Mascota registrarMascotaPerdida(DatosRegistroMascota mascota, HttpServletRequest request) throws Exception;
}
