package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.Date;

public class DatosRegistroMascota {
    private String nombre;
    private String tipo;
    private String estado;
    private String edad;
    private String raza;
    private String detalle;
    private String color;
    private String tamanio;
    private MultipartFile imagen;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date fecha;
    private Publicacion publicacionId;


    public DatosRegistroMascota() {
    }

    public DatosRegistroMascota(String nombre, String tipo, String estado, String edad, String raza, String detalle,
                                String color, String tamanio, Date fecha, Publicacion publicacionId, MultipartFile imagen) {
        this.nombre = nombre;

        this.tipo = tipo;
        this.estado = estado;
        this.edad = edad;
        this.raza = raza;
        this.detalle = detalle;
        this.color = color;
        this.tamanio = tamanio;
        this.fecha = fecha;
        this.imagen = imagen;

        this.publicacionId = publicacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Date getFecha() {
        return fecha;

    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Publicacion getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Publicacion publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public Mascota toMascota() {
        Mascota nuevaMascota = new Mascota();
        nuevaMascota.setEstado(this.getEstado());
        nuevaMascota.setTipo(this.getTipo());
        nuevaMascota.setNombre(this.getNombre());
        nuevaMascota.setEdad(this.getEdad());
        nuevaMascota.setRaza(this.getRaza());
        nuevaMascota.setColor(this.getColor());
        nuevaMascota.setDetalle(this.getDetalle());
        nuevaMascota.setTamanio(this.getTamanio());
        nuevaMascota.setFecha(this.getFecha());
        return nuevaMascota;
    }
}
