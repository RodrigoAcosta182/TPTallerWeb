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
        criteria.createAlias("localidad", "l");
        criteria.createAlias("mascota", "m");
        criteria.createAlias("m.tipo", "t");
        criteria.createAlias("m.estado", "e");


        if (publicacion.getMascota() != null && publicacion.getMascota().getTipo() != null ) {
            criteria.add(Restrictions.eq("t.descripcion",
                    publicacion.getMascota().getTipo().getDescripcion()));
        }
        if (publicacion.getMascota() != null && publicacion.getMascota().getEstado() != null) {
            criteria.add(Restrictions.eq("e.descripcion",
                    publicacion.getMascota().getEstado().getDescripcion()));
        }

        if (publicacion.getLocalidad() != null) {
            criteria.add(Restrictions.eq("l.descripcion", publicacion.getLocalidad().getDescripcion()));
        }

        if (publicacion.getMascota() != null && publicacion.getMascota().getColor() != "") {
            criteria.add(Restrictions.eq("m.color", publicacion.getMascota().getColor()));
        }

        if (publicacion.getMascota() != null && publicacion.getMascota().getRaza() != "") {
            criteria.add(Restrictions.like("m.raza", "%" + publicacion.getMascota().getRaza() + "%"));
        }
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tipo> obtenerTodosLosTiposDeMascota() {
        return sessionFactory.getCurrentSession().createCriteria(Tipo.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estado> obtenerTodosLosEstadosDeMascota() {
        return sessionFactory.getCurrentSession().createCriteria(Estado.class).list();
    }

}




