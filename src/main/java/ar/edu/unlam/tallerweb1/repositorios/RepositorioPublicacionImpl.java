package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPublicacionImpl implements RepositorioPublicacion{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Publicacion> buscarPor(Usuario usuario) {
        return sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("usuarioId", usuario))
                .list();
    }
}
