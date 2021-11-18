package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPublicacion")
public class RepositorioPublicacionImpl implements RepositorioPublicacion {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void guardarPublicacion(Publicacion nuevaPublicacion) {
        sessionFactory.getCurrentSession().save(nuevaPublicacion);
    }

    @Override
    public void finalizarPublicacion(Publicacion publicacion) {
        sessionFactory.getCurrentSession().update(publicacion);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> buscarTodasMisPublicaciones(Usuario usuario) {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("usuario", usuario))
                .list();
        return publicaciones;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> buscarTodasLasPublicacionesPerdidas() {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .createAlias("mascota", "m")
                .createAlias("m.estado","e")
                .add(Restrictions.eq("e.descripcion", "perdido"))
                .add(Restrictions.eq("finalizado", false))
                .list();
        return publicaciones;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Publicacion> buscarTodasLasPublicacionesEncontradas() {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .createAlias("mascota", "m")
                .createAlias("m.estado","e")
                .add(Restrictions.eq("e.descripcion", "encontrado"))
                .add(Restrictions.eq("finalizado", false))
                .list();
        return publicaciones;
    }

    @Override
    public Publicacion buscarPublicacionPorId(Long id) {
        return (Publicacion) sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> buscarUsuarioPorEmail(String email) {
        return sessionFactory.getCurrentSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("email", email)).list();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Localidad> obtenerTodasLasLocalidades() {
        return sessionFactory.getCurrentSession().createCriteria(Localidad.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Localidad obtenerLocalidadPorDescripcion(String localidadDescripcion) {
        return (Localidad) sessionFactory.getCurrentSession().createCriteria(Localidad.class)
                .add(Restrictions.eq("descripcion", localidadDescripcion)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tipo> obtenerTodosLosTiposDeMascota() {
        return sessionFactory.getCurrentSession().createCriteria(Tipo.class).list();
    }

    @Override
    public Tipo obtenerTipoDeMascotaPorId(long id) {
        return (Tipo) sessionFactory.getCurrentSession().createCriteria(Tipo.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estado> obtenerTodosLosEstadosDeMascota() {
        return sessionFactory.getCurrentSession().createCriteria(Estado.class).list();
    }

    @Override
    public Estado obtenerEstadoDeMascotaPorId(long id) {
        return (Estado) sessionFactory.getCurrentSession().createCriteria(Estado.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }
}

