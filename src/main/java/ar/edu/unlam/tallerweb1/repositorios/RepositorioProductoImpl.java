package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.UsuarioProducto;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        List<Producto> productos = sessionFactory.getCurrentSession().createCriteria(Producto.class)
//                .add(Restrictions.eq("hayStock", true))
                .list();
        return productos;
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return (Producto) sessionFactory.getCurrentSession().createCriteria(Producto.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<Producto> buscarTodosLosProductos() {
        List<Producto> productos = sessionFactory.getCurrentSession().createCriteria(Producto.class)
//                .add(Restrictions.eq("hayStock", true))
                .list();
        return productos;
    }

    @Override
    public void canjearProducto(UsuarioProducto usuarioproducto) {
        sessionFactory.getCurrentSession().save(usuarioproducto);
    }

    @Override
    public void actualizarPuntosUsuario(Usuario usuario) {
        sessionFactory.getCurrentSession().update(usuario);
    }

    @Override
    public void actualizarCantidadProducto(Producto producto) {
        sessionFactory.getCurrentSession().update(producto);
    }

    @Override
    public void actualizaSiNoHayStock(Producto producto) {
        sessionFactory.getCurrentSession().update(producto);
    }
}
