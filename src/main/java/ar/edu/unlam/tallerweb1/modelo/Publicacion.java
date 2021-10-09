package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaPublicacion;
    private Byte finalizado;

    @ManyToOne
    private Mascota mascotaid;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuarioId;

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

    public Mascota getMascotaid() {
        return mascotaid;
    }

    public void setMascotaid(Mascota mascotaid) {
        this.mascotaid = mascotaid;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
}
