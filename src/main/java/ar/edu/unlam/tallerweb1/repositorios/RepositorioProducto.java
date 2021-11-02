package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import java.util.List;
import java.util.Collection;

public interface RepositorioProducto {
    void guardarProducto(Producto nuevoProducto);

    List<Producto> buscarTodosMisProductos(Usuario usuario);
}
