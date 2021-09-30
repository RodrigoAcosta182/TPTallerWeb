package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private Integer edad;
    private String raza;
    private String detalle;
    private String color;
    private String tamanio;
    private Date fechaPerdido;
    private Date fechaEncontrado;
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}



