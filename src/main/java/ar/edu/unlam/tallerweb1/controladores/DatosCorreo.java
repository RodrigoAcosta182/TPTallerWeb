package ar.edu.unlam.tallerweb1.controladores;

public class DatosCorreo {
    String receptor;
    String comentario;


    public DatosCorreo() {
    }

    public DatosCorreo(String receptor, String comentario) {
        this.receptor = receptor;
        this.comentario = comentario;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
