package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;

import java.util.Date;

public interface ServicioRegistrarMascotaPerdida {


    Mascota registrarMascotaPerdida(String nombre, String tipo, Integer edad, String raza, String detalle, String color, String tamanio, Date fechaPerdido);
}
