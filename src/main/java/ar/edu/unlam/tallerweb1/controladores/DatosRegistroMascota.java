package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

public class DatosRegistroMascota {
    private String tipo;
    private String nombre;
    private Integer edad;
    private String raza;
    private String detalle;
    private String color;
    private String tamanio;
    private Date fechaPerdido;
    private Date fechaEncontrado;


    public DatosRegistroMascota(){}

    public DatosRegistroMascota(String tipo, String nombre, Integer edad, String raza, String detalle, String color,
                                String tamanio, Date fechaPerdido, Date fechaEncontrado) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.detalle = detalle;
        this.color = color;
        this.tamanio = tamanio;
        this.fechaPerdido = fechaPerdido;
        this.fechaEncontrado = fechaEncontrado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Date getFechaPerdido() {
        return fechaPerdido;
    }

    public void setFechaPerdido(Date fechaPerdido) {
        this.fechaPerdido = fechaPerdido;
    }

    public Date getFechaEncontrado() {
        return fechaEncontrado;
    }

    public void setFechaEncontrado(Date fechaEncontrado) {
        this.fechaEncontrado = fechaEncontrado;
    }
}
