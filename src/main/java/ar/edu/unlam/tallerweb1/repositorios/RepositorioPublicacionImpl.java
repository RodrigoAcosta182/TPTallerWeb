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
    public List<Publicacion> buscarPor(Usuario usuario) {
        return sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("usuarioId", usuario))
                .list();
    }

    @Override
    public List<Publicacion> buscarTodasMisPublicaciones(Usuario usuario) {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("usuario", usuario))
                .list();
        return publicaciones;
    }

    @Override
    public List<Publicacion> buscarTodasLasPublicacionesPerdidas() {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("estado", "1"))
                .list();
        return publicaciones;
    }

    @Override
    public List<Publicacion> buscarTodasLasPublicacionesEncontradas() {
        List<Publicacion> publicaciones = sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("estado", "2"))
                .list();
        return publicaciones;
    }

    @Override
    public Publicacion buscarPublicacionPorId(Long id) {
        return (Publicacion) sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }


}

//    @Override
//    public List<Mascota> buscarMascotaPorTipo(String tipo) {
//        final Session session = sessionFactory.getCurrentSession();
//        return session.createCriteria(Mascota.class)
//                .add(Restrictions.eq("tipo", tipo))
//                .list();
//    }
//
//    @Override
//    public void guardarMascota(Mascota mascota) {
//        sessionFactory.getCurrentSession().save(mascota);
//    }
//
//    @Override
//    public List<Mascota> buscarPorId(Long id) {
//        final Session session = sessionFactory.getCurrentSession();
//        return session.createCriteria(Mascota.class)
//                .add(Restrictions.eq("id", id))
//                .list();
//    }
