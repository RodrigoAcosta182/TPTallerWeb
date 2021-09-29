package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMascotaPerdida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service("servicioRegistrarMascotaPerdida")
@Transactional
public class ServicioRegistrarMascotaPerdidaImpl implements ServicioRegistrarMascotaPerdida {

    private RepositorioMascotaPerdida repositorioMascotaPerdida;

    @Autowired
    public ServicioRegistrarMascotaPerdidaImpl(RepositorioMascotaPerdida repositorioMascotaPerdida){
        this.repositorioMascotaPerdida = repositorioMascotaPerdida;
    }


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


        return newPet;
    }
}
