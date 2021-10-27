package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service("servicioMail")
@Transactional
public class ServicioMailImpl implements ServicioMail{

    @Override
    public void enviarCorreo(String receptor, String comentario) throws Exception {

        if(receptor == null || comentario == null)
            throw new Exception();
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String miCuenta = "missingpetsunlam@gmail.com";
        String password = "Unlam2021";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(miCuenta, password);
            }
        });

        Message mensaje = prepararMensaje(session, miCuenta, receptor, comentario);
        Transport.send(mensaje, mensaje.getRecipients(Message.RecipientType.TO));
    }

    private static Message prepararMensaje(Session session, String miCuenta,String receptor,  String comentario) {
        try {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(miCuenta));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mensaje.setSubject("Missing Pets");
            mensaje.setText("Recibiste un mensaje de la APP Missing Pets: " + comentario);
            return mensaje;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}