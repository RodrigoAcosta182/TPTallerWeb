package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ChatUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioChatUsuario {


    void guardarMensaje(ChatUsuario chatUsuario);
    Usuario buscarUsuarioPorEmail(String email);
}
