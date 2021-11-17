package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Tipo;
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

    @RequestMapping(method = RequestMethod.POST, path = "/registrarMascota")
    public ModelAndView registrarPublicacion(@ModelAttribute("datosMascota") DatosRegistroMascota mascota, HttpServletRequest request) throws Exception {
        ModelMap model = new ModelMap();
        try {
            validarRegistrarPublicacion(mascota, request);
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            servicioPublicacion.registrarPublicacion(mascota, usuario);
        } catch (Exception e) {
            List<Localidad> localidades =  servicioPublicacion.getLocalidades();
            List<Tipo> tiposDeMascota = servicioPublicacion.getTiposDeMascota();
            model.put("localidades",localidades);
            model.put("tiposDeMascota",tiposDeMascota);
            model.put("error", e.getMessage());
            return new ModelAndView("form-registro-mascota", model);
        }
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/buscarUsuario")
    public ModelAndView buscarUsuario(@ModelAttribute("datosMascota") DatosRegistroMascota mascota, HttpServletRequest request, String email) {
        ModelMap model = new ModelMap();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            servicioPublicacion.buscarUsuarioParaFinalizar(usuario, email);
        } catch (Exception e) {
            model.put("busqueda", "No existe usuario con ese email");
            return new ModelAndView("mis-publicaciones", model);
        }
        model.put("busqueda", "Usuario Encontrado");
        return new ModelAndView("mis-publicaciones", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/finalizar-publicacion")
    public ModelAndView finalizarPublicacion(@ModelAttribute("datosMascota") DatosRegistroMascota mascota,@RequestParam("id") Long id) {
        ModelMap model = new ModelMap();
        try{
            servicioPublicacion.finalizarPublicacion(id);
        }catch (Exception e){
            model.put("error","No se pudo finalizar");
        }
        model.put("msg","Publicacion Finalizada");

        return new ModelAndView("home", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-publicacion-mascota-perdida")
    public ModelAndView irAPublicacionMascotaPerdida(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
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

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-registrar-mascota")
    public ModelAndView irARegistrarPublicacion() {
        ModelMap model = new ModelMap();
        DatosRegistroMascota datosMascota = new DatosRegistroMascota();
        List<Localidad> localidades =  servicioPublicacion.getLocalidades();
        List<Tipo> tiposDeMascota = servicioPublicacion.getTiposDeMascota();
        model.put("localidades",localidades);
        model.put("tiposDeMascota",tiposDeMascota);
        model.put("datosMascota", datosMascota);
        return new ModelAndView("form-registro-mascota", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-mis-publicaciones")
    public ModelAndView irAMisPublicaciones(@ModelAttribute("datosMascota") DatosRegistroMascota mascota,HttpServletRequest request) {
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

    @RequestMapping(method = RequestMethod.GET, path = "/publicacion")
    public ModelAndView irAVerPublicacion(@RequestParam("id") Long id) {
        ModelMap model = new ModelMap();
        DatosCorreo datosCorreo = new DatosCorreo();
        Publicacion publicacion;
        try {
        publicacion = servicioPublicacion.buscarPublicacion(id);
        datosCorreo.setReceptor(publicacion.getUsuario().getEmail());
        model.put("publicacion", publicacion);
        }catch (Exception e){
            model.put("msjError","Error al encontrar publicacion");
        }
        model.put("datosCorreo", datosCorreo);
        return new ModelAndView("ver-publicacion", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/modificarregistroMascota")
    public ModelAndView modificarRegistroPublicacion(@ModelAttribute("datosMascota") DatosRegistroMascota mascota , @RequestParam("id") Long id, HttpServletRequest request)  throws Exception {
        ModelMap model = new ModelMap();
        Publicacion publicacion;
        try {
            validarRegistrarPublicacion(mascota, request);
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
//            publicacion = servicioPublicacion.modificarPublicacion(id);
//            model.put("publicacion", publicacion);
        } catch (Exception e) {
            List<Localidad> localidades =  servicioPublicacion.getLocalidades();
            List<Tipo> tiposDeMascota = servicioPublicacion.getTiposDeMascota();
            model.put("localidades",localidades);
            model.put("tiposDeMascota",tiposDeMascota);
            model.put("error", e.getMessage());
            return new ModelAndView("form-modificar-registro-mascota", model);
        }
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-publicacion-mascota-perdida")
    public ModelAndView irAlSitioModificarPublicacion(@RequestParam("id") Long id) {
        ModelMap model = new ModelMap();
        DatosCorreo datosCorreo = new DatosCorreo();
        Publicacion publicacion;
        try {
            publicacion = servicioPublicacion.buscarPublicacion(id);
            model.put("publicacion", publicacion);
        }catch (Exception e){
            model.put("msjError","Error al encontrar publicacion");
        }
        return new ModelAndView("form-modificar-registro-mascota", model);
    }

    public void validarRegistrarPublicacion(DatosRegistroMascota mascota, HttpServletRequest request) throws Exception {
        if (mascota.getTipo() == null){
            throw new Exception("El campo Tipo es obligatorio");
        }else if (mascota.getEstado() == null){
            throw new Exception("El campo Estado es obligatorio");
        }else if (mascota.getImagen().getSize() < 1){
            throw new Exception("El campo Imagen es obligatorio");
        }
    }

}
