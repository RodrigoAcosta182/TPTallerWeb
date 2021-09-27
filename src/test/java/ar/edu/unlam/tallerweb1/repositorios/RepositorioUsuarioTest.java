package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioUsuarioTest extends SpringTest {

    private static final String ADMIN = "ADMIN";
    private static final String INVITADO = "INVITADO";

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    @Rollback @Transactional
    public void buscarPorRolDeberiaDevolverSoloUsuariosConEseRol(){
        givenExistenUsuarioConRol(ADMIN, 2);
        givenExistenUsuarioConRol(INVITADO, 2);

        List<Usuario> usuarios = whenBuscoUsuariosConRol(ADMIN);

        thenEncuentro(usuarios, 2);
    }

    @Test
    @Rollback @Transactional
    public void buscarPorRolNoDeberiaDevolverResultadosSiNoExistenUsuariosConEseRol(){
        givenExistenUsuarioConRol(INVITADO, 3);

        List<Usuario> usuarios = whenBuscoUsuariosConRol(ADMIN);

        thenEncuentro(usuarios, 0);
    }

    @Test
    @Rollback @Transactional
    public void buscarUsuarioConMailDeAdmin(){
        givenExistenUsuarioConRol(ADMIN, 2);
        givenExistenUsuarioConRol(INVITADO, 3);

        List<Usuario> usuarios = whenBuscoUsuarioConMailDe(ADMIN);

        thenEncuentro(usuarios, 2);
    }

    private List<Usuario> whenBuscoUsuarioConMailDe(String mail){
        return repositorioUsuario.buscarUsuarioConMailLikePorRol(mail);
    }

    private void thenEncuentro(List<Usuario> usuarios, int usuariosEncontrados) {
        assertThat(usuarios).hasSize(usuariosEncontrados);
    }

    private List<Usuario> whenBuscoUsuariosConRol(String rol) {
        return repositorioUsuario.buscarUsuarioPorRol(rol);
    }

    private void givenExistenUsuarioConRol(String rol, int cantidadDeUsuarios) {
        for (int i = 0; i < cantidadDeUsuarios; i++){
            Usuario usuario = new Usuario();
            usuario.setEmail("usuario-"+i+"-"+rol+"@usuario.com");
            usuario.setPassword("123"+i);
            usuario.setRol(rol);

            Cuenta cuenta = new Cuenta();
            cuenta.setCreada(new Date());
            usuario.setCuenta(cuenta);

            session().save(usuario);
            int ei = 0;
        }
    }
}
