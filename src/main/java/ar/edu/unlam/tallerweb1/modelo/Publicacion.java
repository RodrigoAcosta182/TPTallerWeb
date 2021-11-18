package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;

import javax.persistence.*;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaPublicacion;
    private Boolean finalizado = false;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    private Mascota mascota;


    @OneToOne(cascade = CascadeType.ALL)
    private Localidad localidad;


    public Publicacion() {

    }

    public Publicacion( Date fechaPublicacion, Boolean finalizado, Usuario usuario, Mascota mascota, Localidad localidad) {
        this.fechaPublicacion = fechaPublicacion;
        this.finalizado = finalizado;
        this.usuario = usuario;
        this.mascota = mascota;
        this.localidad = localidad;
    }

    public Publicacion(Mascota mascota, Localidad localidad) {
        this.mascota = mascota;
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void setMascota(Mascota nuevaMascota) {
        this.mascota = nuevaMascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
