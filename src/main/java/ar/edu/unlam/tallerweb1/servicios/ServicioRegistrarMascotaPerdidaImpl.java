package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.Date;

public class ServicioRegistrarMascotaPerdidaImpl implements ServicioRegistrarMascotaPerdida {


    @Override
    public Mascota registrarMascotaPerdida(String nombre, String tipo, Integer edad, String raza, String detalle, String color, String tamanio, Date fechaPerdido) {
        Mascota newPet = new Mascota();
        newPet.setNombre(nombre);
        newPet.setTipo(tipo);
        newPet.setEdad(edad);
        newPet.setRaza(raza);
        newPet.setDetalle(detalle);
        newPet.setColor(color);
        newPet.setTamanio(tamanio);
        newPet.setFechaPerdido(fechaPerdido);


        return null;
    }
}
