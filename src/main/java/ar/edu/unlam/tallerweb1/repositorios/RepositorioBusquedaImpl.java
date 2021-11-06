package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioBusqueda")
public class RepositorioBusquedaImpl implements RepositorioBusqueda {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Localidad> obtenerTodasLasLocalidades() {
        return  sessionFactory.getCurrentSession().createCriteria(Localidad.class).list();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> obtenerPublicacionesPorLocalidad(String localidad) {
        return sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .createAlias("localidad","l")
                .add(Restrictions.eq("l.descripcion", localidad)).list();

    }
}





//    @Override
//    public List<Producto> buscarTodosMisProductos(Usuario usuario) {
//        List<Producto> productos = sessionFactory.getCurrentSession().createCriteria(Producto.class)
//                .add(Restrictions.eq("hayStock", true))
//                .list();
//        return productos;
//    }