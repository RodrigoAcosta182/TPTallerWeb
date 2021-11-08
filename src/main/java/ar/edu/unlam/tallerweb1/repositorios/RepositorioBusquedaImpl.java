package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroMascota;
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
    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> buscarPublicaciones(DatosRegistroMascota mascota) {
        return sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .createAlias("localidad","l")
                .createAlias("mascota", "m")
                .add(Restrictions.eq("m.estado",mascota.getEstado()))
                .add(Restrictions.eq("m.tipo",mascota.getTipo()))
                .add(Restrictions.eq("m.color",mascota.getColor()))
                .add(Restrictions.eq("m.raza",mascota.getRaza()))
                .add(Restrictions.eq("l.descripcion",mascota.getPublicacion().getLocalidad().getDescripcion()))
                .list();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> obtenerPublicacionesConAlgunParametroNull(DatosRegistroMascota mascota) {
        return sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .createAlias("localidad","l")
                .createAlias("mascota", "m")
                .add(Restrictions.disjunction()
                .add(Restrictions.eq("m.estado",mascota.getEstado()))
                .add(Restrictions.eq("m.tipo",mascota.getTipo()))
                .add(Restrictions.eq("m.color",mascota.getColor()))
                .add(Restrictions.eq("m.raza",mascota.getRaza()))
                .add(Restrictions.eq("l.descripcion",mascota.getPublicacion().getLocalidad().getDescripcion())))
                .list();
    }
}




