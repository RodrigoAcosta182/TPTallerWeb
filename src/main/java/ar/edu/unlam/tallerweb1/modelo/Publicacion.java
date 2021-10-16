package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaPublicacion;
    private Byte finalizado = 0;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;

    @OneToOne(cascade = CascadeType.ALL)
    private Mascota mascota;

    public Mascota getMascota() {
        return mascota;
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

    public Byte getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Byte finalizado) {
        this.finalizado = finalizado;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setMascota(Mascota nuevaMascota) {
        this.mascota = nuevaMascota;
    }
}
