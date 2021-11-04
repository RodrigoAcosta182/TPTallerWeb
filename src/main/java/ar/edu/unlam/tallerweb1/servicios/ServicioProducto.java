package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroProducto;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ServicioProducto {

    List<Producto> listarTodosLosProductos(Usuario usuario) throws Exception;

    Producto registrarProducto(DatosRegistroProducto producto, Usuario usuario) throws Exception;

    void canjearProducto(Long id, Usuario usuario) throws Exception;

    Producto buscarProducto(Long id);
}
