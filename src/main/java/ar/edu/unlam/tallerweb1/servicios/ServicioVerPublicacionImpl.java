package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("servicioVerPublicacion")
@Transactional
public class ServicioVerPublicacionImpl implements ServicioVerPublicacion {

    @Override
    public void enviarCorreo(String receptor) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String miCuenta = "garlopacompany@gmail.com";
        String password = "Unlam2020";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(miCuenta, password);
            }
        });

        Message mensaje = prepararMensaje(session, miCuenta,receptor);
        Transport.send(mensaje);
    }

    private static Message prepararMensaje(Session session, String receptor, String miCuenta) {
        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(miCuenta));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mensaje.setSubject("Missing Pets");
            mensaje.setText("Este es un comentario que te hicieron en Missing Pets. \n Saludos!");
            return mensaje;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
