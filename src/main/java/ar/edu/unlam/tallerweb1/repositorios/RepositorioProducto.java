package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.UsuarioProducto;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import java.util.List;

public interface RepositorioProducto {
    void guardarProducto(Producto nuevoProducto);

    List<Producto> buscarTodosMisProductos(Usuario usuario);

    List<Producto> buscarTodosLosProductos();

    Producto buscarProductoPorId(Long id);

    void canjearProducto(UsuarioProducto usuarioProducto);

    void actualizarPuntosUsuario(Usuario usuario);

    void actualizarCantidadProducto(Producto producto);

    void actualizaSiNoHayStock(Producto producto);
}
