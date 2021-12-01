package ar.edu.unlam.tallerweb1.controladores;

public class DatosCorreo {
    String receptor;
    String comentario;
    Long idPublicacion;


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

    public Long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public void validar() throws Exception{
        if (this.getReceptor() == null){
            throw new Exception("La publicacion debe tener un mail asociado");
        }
        if (this.getComentario() == ""){
            throw new Exception("El campo Comentario es obligatorio");
        }

    }
}
