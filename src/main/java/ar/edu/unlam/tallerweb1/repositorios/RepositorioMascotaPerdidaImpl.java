package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioMascotaPerdida")
public class RepositorioMascotaPerdidaImpl implements RepositorioMascotaPerdida {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioMascotaPerdidaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Mascota> buscarMascotaPorTipo(String tipo) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Mascota.class)
                .add(Restrictions.eq("tipo", tipo))
                .list();
    }
}
