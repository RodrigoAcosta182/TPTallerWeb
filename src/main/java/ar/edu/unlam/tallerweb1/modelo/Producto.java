package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Integer puntos;
    private Integer cantidad;
    private String imgproducto;

    public Producto(String descripcion, Integer puntos, Integer cantidad, String imgproducto) {
        this.descripcion = descripcion;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.imgproducto = imgproducto;
    }

    public Producto(Long id, String descripcion, Integer puntos, Integer cantidad, String imgproducto) {
        this.id = id;
        this.descripcion = descripcion;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.imgproducto = imgproducto;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return cantidad;
    }

    public String getImgproducto() {
        return imgproducto;
    }

    public void setImgproducto(String imgproducto) {
        this.imgproducto = imgproducto;
    }
}
