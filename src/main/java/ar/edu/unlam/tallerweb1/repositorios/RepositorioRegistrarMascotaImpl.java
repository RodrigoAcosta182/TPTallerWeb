package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioMascotaPerdida")
public class RepositorioRegistrarMascotaImpl implements RepositorioRegistrarMascota {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRegistrarMascotaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Mascota> buscarMascotaPorTipo(String tipo) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Mascota.class)
                .add(Restrictions.eq("tipo", tipo))
                .list();
    }

    @Override
    public void guardarMascota(Mascota mascota) {
        sessionFactory.getCurrentSession().save(mascota);
    }

    @Override
    public List<Mascota> buscarPorNombre(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Mascota.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
    }
}
