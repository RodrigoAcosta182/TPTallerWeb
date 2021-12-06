package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(method = RequestMethod.POST, path = "/registrarProducto")
    public ModelAndView registrarProducto(@ModelAttribute("producto") DatosRegistroProducto producto, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception{
        ModelMap model = new ModelMap();

        try{
            producto.validarRegistroProducto(producto, request);
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            servicioProducto.registrarProducto(producto, usuario);
        }catch (Exception e){
            model.put("error", e.getMessage());
            return new ModelAndView("form-registro-producto", model);
        }
        String mensaje = "Producto Registrado Exitosamente";
        model.put("msg",mensaje);
        redirectAttributes.addFlashAttribute("msg", mensaje);
        return new ModelAndView("redirect:/ir-a-productos", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/canjear-producto")
    public ModelAndView canjearProducto(@RequestParam("id") Long id,HttpServletRequest request) throws Exception{
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

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-productos")
    public ModelAndView irAVistaDeProductos(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Producto> productos = new ArrayList<>();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            model.put("usuario", usuario);
            productos = servicioProducto.listarTodosLosProductos();
        } catch (Exception e) {
            model.put("productoError", "No hay productos");
            return new ModelAndView("Productos", model);
        }
        model.put("productos", productos);
        return new ModelAndView("Productos", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-registrar-producto")
    public ModelAndView irAVistaDeRegistroDeProductos() {
        ModelMap model = new ModelMap();
        DatosRegistroProducto datosProducto = new DatosRegistroProducto();
        model.put("producto", datosProducto);
        return new ModelAndView("form-registro-producto", model);
    }

}
