package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
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


    @Override
    public List<Publicacion> buscarTodasMisPublicaciones(Usuario usuario) {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("usuario", usuario))
                .add(Restrictions.eq("finalizado", false))
                .list();
        return publicaciones;
    }

    @Override
    public List<Publicacion> buscarTodasLasPublicacionesPerdidas() {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("estado", "1"))
                .add(Restrictions.eq("finalizado", false))
                .list();
        return publicaciones;
    }

    @Override
    public List<Publicacion> buscarTodasLasPublicacionesEncontradas() {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("estado", "2"))
                .add(Restrictions.eq("finalizado", false))
                .list();
        return publicaciones;
    }

    @Override
    public Publicacion buscarPublicacionPorId(Long id) {
        return (Publicacion) sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }
}

