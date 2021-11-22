package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Tipo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class DatosRegistroMascota {
    private Long id;
    private String nombre;


    private String edad;
    private String raza;
    private String detalle;
    private String color;
    private String tamanio;
    private MultipartFile imagen;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date fecha;
    private String email;

    private Publicacion publicacion;
    private Tipo tipo;
    private Estado estado;


    public DatosRegistroMascota() {
    }

    public DatosRegistroMascota(Estado estado,Tipo tipo, Publicacion publicacion, String raza,String color) {
        this.estado = estado;
        this.tipo = tipo;
        this.publicacion = publicacion;
        this.raza = raza;
        this.color = color;
    }

    public DatosRegistroMascota(String nombre, Tipo tipo, Estado estado, String edad, String raza, String detalle,
                                String color, String tamanio, Date fecha, Publicacion publicacion, MultipartFile imagen, String email) {
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
        this.publicacion = publicacion;
        this.email = email;
    }

    public DatosRegistroMascota(Long id, String nombre, Tipo tipo, Estado estado, String edad, String raza, String detalle,
                                String color, String tamanio, Date fecha, Publicacion publicacion, MultipartFile imagen, String email) {
        this.id = id;
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
        this.publicacion = publicacion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
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

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
