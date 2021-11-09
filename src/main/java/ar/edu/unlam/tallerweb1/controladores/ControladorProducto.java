package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorProducto {

    private ServicioProducto servicioProducto;

    @Autowired
    public ControladorProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-productos")
    public ModelAndView irAVistaDeProductos(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Producto> productos = new ArrayList<>();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            productos = servicioProducto.listarTodosLosProductos(usuario);
        } catch (Exception e) {
            model.put("productoError", "No hay productos");
            return new ModelAndView("Productos", model);
        }
        model.put("productos", productos);
        return new ModelAndView("Productos", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/canjear-producto")
    public ModelAndView canjearProducto(@RequestParam("id") Long id,HttpServletRequest request){
        ModelMap model = new ModelMap();
        try{
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            servicioProducto.canjearProducto(id,usuario);
        }catch (Exception e){
            model.put("error","Lo siento, no te alcanza para canjear este producto :(");
            return new ModelAndView("Productos", model);
        }
        model.put("msg","Puntos Canjeados");

        return new ModelAndView("Productos", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registrarProducto")
    public ModelAndView registrarProducto(@ModelAttribute("producto") DatosRegistroProducto producto, HttpServletRequest request) throws Exception{
        ModelMap model = new ModelMap();
        try {
            if (producto.getCantidad() != null && producto.getDescripcion() != null){
                try {
                    if (producto.getCantidad() > 0){
                        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
                        servicioProducto.registrarProducto(producto, usuario);
                    }else {
                        throw new RuntimeException("Registro Fallido");
                    }
                }catch (Exception e){
                    model.put("error", "El stock no puede ser negativo");
                    return new ModelAndView("form-registro-producto", model);
                }
            }else{
                throw new RuntimeException("Registro Fallido");
            }
        } catch (Exception e) {
            model.put("error", "Faltan completar campos");
            return new ModelAndView("form-registro-producto", model);
        }
        model.put("msg", "Producto Registrado Exitosamente");
        return new ModelAndView("Productos", model);
    }
}