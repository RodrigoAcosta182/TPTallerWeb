package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public class DatosRegistroProducto {
    private String descripcion;
    private Integer puntos;
    private Integer cantidad;
    private MultipartFile imgproducto;

    public DatosRegistroProducto(){
    }

    public DatosRegistroProducto(String descripcion, Integer puntos, Integer cantidad, MultipartFile imgproducto) {
        this.descripcion = descripcion;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.imgproducto = imgproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public MultipartFile getImgproducto() {
        return imgproducto;
    }

    public void setImgproducto(MultipartFile imgproducto) {
        this.imgproducto = imgproducto;
    }

    public Producto toProducto(){
        Producto nuevoProducto = new Producto();
        nuevoProducto.setCantidad(this.cantidad);
        nuevoProducto.setDescripcion(this.descripcion);
        nuevoProducto.setPuntos(this.puntos);
        return nuevoProducto;
    }


    public void validarRegistroProducto(DatosRegistroProducto producto, HttpServletRequest request) throws Exception {
        if (this.getCantidad() != null) {
            if (this.getCantidad() < 0) {
                throw new Exception("El stock no puede ser negativo");
            }
        }else {
            throw new Exception("Tiene que ingresar una cantidad");
        }if ((this.getDescripcion() == null) || (this.getDescripcion().equals(""))){
            throw new Exception("Tiene que ingresar la descripcion del producto");
        }if ((this.getPuntos() == null) || !(this.getPuntos().equals(this.getPuntos().intValue())) || (this.getPuntos() < 0) ){
            throw new Exception("Los puntos tienen que ser numericos y no puede ser negativo");
        }if (this.getImgproducto().isEmpty()){
            throw new Exception("El campo Imagen es obligatorio");
        }
    }
}
