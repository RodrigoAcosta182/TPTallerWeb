package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioProducto")
public class RepositorioProductoImpl implements RepositorioProducto{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void guardarProducto(Producto nuevoProducto) {
        sessionFactory.getCurrentSession().save(nuevoProducto);
    }

    @Override
    public List<Producto> buscarTodosMisProductos(Usuario usuario) {
        return null;
    }
}
