package ar.edu.unlam.tallerweb1.servicios;

import javax.mail.MessagingException;

public interface ServicioVerPublicacion {

    void enviarCorreo(String receptor) throws MessagingException;
}
