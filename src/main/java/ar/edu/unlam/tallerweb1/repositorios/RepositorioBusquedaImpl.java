package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioBusqueda")
public class RepositorioBusquedaImpl implements RepositorioBusqueda {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Localidad> obtenerTodasLasLocalidades() {
        return  sessionFactory.getCurrentSession().createCriteria(Localidad.class).list();
    }
}









//    @Override
//    public List<Producto> buscarTodosMisProductos(Usuario usuario) {
//        List<Producto> productos = sessionFactory.getCurrentSession().createCriteria(Producto.class)
//                .add(Restrictions.eq("hayStock", true))
//                .list();
//        return productos;
//    }