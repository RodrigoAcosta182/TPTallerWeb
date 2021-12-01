package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ChatUsuario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositoriochatusuario")
public class RepositorioChatUsuarioImpl implements RepositorioChatUsuario{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void guardarMensaje(ChatUsuario chatUsuario) {
        sessionFactory.getCurrentSession().save(chatUsuario);
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public Publicacion buscarPublicacionPorId(Long id) {
        return (Publicacion) sessionFactory.getCurrentSession().createCriteria(Publicacion.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }
}
