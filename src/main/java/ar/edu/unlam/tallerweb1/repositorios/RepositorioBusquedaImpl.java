package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Tipo;
import org.hibernate.Criteria;
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
        return sessionFactory.getCurrentSession().createCriteria(Localidad.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> buscarPublicacionPor(Publicacion publicacion) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Publicacion.class);
        criteria.createAlias("mascota", "m");
        criteria.createAlias("localidad", "l");
        if (publicacion.getMascota().getTipo() != null) {
            criteria.add(Restrictions.eq("m.tipo", publicacion.getMascota().getTipo()));
        }
        if (publicacion.getMascota().getColor() != null) {
            criteria.add(Restrictions.like("m.color", "%" + publicacion.getMascota().getColor() + "%"));
        }
        if (publicacion.getLocalidad().getDescripcion() != null) {
            criteria.add(Restrictions.eq("l.descripcion", publicacion.getLocalidad().getDescripcion()));
        }
        if (publicacion.getMascota().getRaza() != null) {
            criteria.add(Restrictions.like("m.raza", "%" + publicacion.getMascota().getRaza() + "%"));
        }
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tipo> obtenerTodosLosTiposDeMascota() {
        return sessionFactory.getCurrentSession().createCriteria(Tipo.class).list() ;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estado> obtenerTodosLosEstadosDeMascota() {
        return sessionFactory.getCurrentSession().createCriteria(Estado.class).list();
    }

}




