package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioMail {
    void enviarCorreo(String receptor, String comentario) throws Exception;
}
