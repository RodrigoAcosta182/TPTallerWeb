package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class ChatUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje ;
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public ChatUsuario(){

    }

    public ChatUsuario(Long id, String mensaje, String fecha, Usuario usuario) {
        this.id = id;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
