package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

public class DatosMascotaEncontrada {

    private String tipo; //select
    private String nombre;
    private String raza;
    private String detalle;
    private String color;
    private String tamanio; //select
    private Date fechaEncontrado;
    private String localidad;
    private String provincia;
    private String imagen;

    public DatosMascotaEncontrada(){}

    public DatosMascotaEncontrada(String tipo, String nombre, String raza, String detalle, String color, String tamanio,
                                  Date fechaEncontrado, String localidad, String provincia, String imagen) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.raza = raza;
        this.detalle = detalle;
        this.color = color;
        this.tamanio = tamanio;
        this.fechaEncontrado = fechaEncontrado;
        this.localidad = localidad;
        this.provincia = provincia;
        this.imagen = imagen;
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

    public Date getFechaEncontrado() {
        return fechaEncontrado;
    }

    public void setFechaEncontrado(Date fechaEncontrado) {
        this.fechaEncontrado = fechaEncontrado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
