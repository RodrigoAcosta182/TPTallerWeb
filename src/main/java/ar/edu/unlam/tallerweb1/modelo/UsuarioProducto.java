package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class UsuarioProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Producto producto;
    @OneToOne
    private Usuario usuario;

    public UsuarioProducto(Producto producto, Usuario usuario) {
        this.producto = producto;
        this.usuario = usuario;
    }

    public UsuarioProducto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
