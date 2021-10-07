package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

public class DatosRegistroMascota {
    private String tipo;
//    private String nombre;
    private String edad;
    private String raza;

    private String detalle;

    private String color;
    private String tamanio;
    private Date fecha;
//    private String localidad;
//    private String provincia;
//    private String imagen;
//    private String estado;

    public DatosRegistroMascota(){}

    public DatosRegistroMascota(String tipo, String edad, String raza, String detalle, String color, String tamanio, Date fecha) {
        this.tipo = tipo;
        this.edad = edad;
        this.raza = raza;
        this.detalle = detalle;
        this.color = color;
        this.tamanio = tamanio;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
