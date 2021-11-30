package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;

public interface ServicioMail {

    void enviarCorreo(String receptor, String comentario, Usuario usuario) throws Exception;
}
