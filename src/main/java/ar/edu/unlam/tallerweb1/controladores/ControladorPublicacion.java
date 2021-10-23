package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorPublicacion {


    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorPublicacion(ServicioPublicacion servicioPublicacion) {
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-publicacion-mascota-perdida")
    public ModelAndView irAPublicacionMascotaPerdida(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
        usuario.getId();
        publicaciones = servicioPublicacion.listarTodasLasPublicacionesPerdidas();
        } catch (Exception e) {
        model.put("publicacionesError", "No hay publicaciones");
            return new ModelAndView("publicaciones-perdidos", model);
        }
        model.put("publicaciones", publicaciones);
        return new ModelAndView("publicaciones-perdidos", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-publicacion-mascota-encontrada")
    public ModelAndView irAPublicacionMascotaEncontrada(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            usuario.getId();
            publicaciones = servicioPublicacion.listarTodasLasPublicacionesEncontradas();
        } catch (Exception e) {
            model.put("publicacionesError", "No hay publicaciones");
            return new ModelAndView("publicaciones-perdidos", model);
        }
        model.put("publicaciones", publicaciones);
        return new ModelAndView("publicaciones-perdidos", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-mis-publicaciones")
    public ModelAndView irAMisPublicaciones(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            publicaciones = servicioPublicacion.listarTodasMisPublicaciones(usuario);
        } catch (Exception e) {
            model.put("publicacionesError", "No hay publicaciones");
            return new ModelAndView("publicaciones-perdidos", model);
        }
        model.put("publicaciones", publicaciones);
        return new ModelAndView("mis-publicaciones", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/finalizar-publicacion/{id}")
    public ModelAndView finalizarPublicacion(@PathVariable ("id") Long id) {
        servicioPublicacion.finalizarPublicacion(id);
        return new ModelAndView("mis-publicaciones");
    }

    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-registrar-mascota")
    public ModelAndView irARegistrarPublicacion() {
        ModelMap model = new ModelMap();
        DatosRegistroMascota datosMascota = new DatosRegistroMascota();
        model.put("datosMascota",datosMascota);
        return new ModelAndView("form-registro-mascota",model);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/registrarMascota")
    public ModelAndView registrarPublicacion(@ModelAttribute("datosMascota") DatosRegistroMascota mascota, HttpServletRequest request) throws Exception{
        ModelMap model = new ModelMap();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            usuario.getId();
            servicioPublicacion.registrarPublicacion(mascota,usuario);
        }catch (Exception e){
            model.put("error","El campo tipo y estado es obligatorio");
            return new ModelAndView("form-registro-mascota",model);
        }
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home",model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/publicacion")
    public ModelAndView irAVerPublicacion(@RequestParam("id") Long id) {
        ModelMap model = new ModelMap();
        Publicacion publicacion = servicioPublicacion.buscarPublicacion(id);
        DatosCorreo datosCorreo = new DatosCorreo();
        datosCorreo.setReceptor(publicacion.getUsuario().getEmail());
        model.put("datosCorreo", datosCorreo);
        model.put("publicacion",publicacion);
        return new ModelAndView("ver-publicacion",model);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/enviarCorreo")
    public ModelAndView enviarCorreo(@ModelAttribute("datosCorreo") DatosCorreo datosCorreo) {
        ModelMap model = new ModelMap();
        try {
            servicioPublicacion.enviarCorreo(datosCorreo.getReceptor(), datosCorreo.getComentario());
        }catch (Exception e){
            model.put("mailError","error al enviar el mensaje");
            return new ModelAndView("ver-publicacion", model);
        }
        model.put("mailOk","Mensaje enviado correctamente");
        return new ModelAndView("ver-publicacion",model);
    }

}
