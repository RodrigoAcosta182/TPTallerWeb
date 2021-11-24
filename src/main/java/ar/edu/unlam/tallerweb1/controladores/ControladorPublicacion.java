package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
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
            List<Estado> estadosMascota = servicioPublicacion.getEstadosDeMascota();
            model.put("localidades",localidades);
            model.put("tiposDeMascota",tiposDeMascota);
            model.put("error", e.getMessage());
            model.put("estadosMascota",estadosMascota);
            return new ModelAndView("form-registro-mascota", model);
        }
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/finalizar-publicacion")
    public ModelAndView finalizarPublicacion(@ModelAttribute("datosMascota") DatosRegistroMascota mascota,@ModelAttribute("publicacion") Publicacion publicacion,HttpServletRequest request) {
        ModelMap model = new ModelMap();
        try{
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            validarUsuarioParaFinalizarPublicacion(usuario, mascota.getEmail());
            servicioPublicacion.finalizarPublicacion(mascota, publicacion,request);
        }catch (Exception e){
            model.put("error",e.getMessage());
            return new ModelAndView("mis-publicaciones", model);
        }
        model.put("msg","Publicacion Finalizada");

        return new ModelAndView("home", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/eliminar-publicacion")
    public ModelAndView eliminarPublicacion(@RequestParam("id") Long id) {
        ModelMap model = new ModelMap();
        try{
            servicioPublicacion.eliminarPublicacion(id);
        }catch (Exception e){
            model.put("error","No se pudo eliminar");
        }
        model.put("msg","Publicacion Eliminada");

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
        List<Estado> estadosMascota = servicioPublicacion.getEstadosDeMascota();
        model.put("localidades",localidades);
        model.put("tiposDeMascota",tiposDeMascota);
        model.put("estadosMascota",estadosMascota);
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
//
    @RequestMapping(method = RequestMethod.POST, path = "/modificarregistroMascota")
    public ModelAndView modificarRegistroPublicacion(@ModelAttribute("datosMascota") DatosRegistroMascota mascota, @ModelAttribute("publicacion") Publicacion publicacion, HttpServletRequest request)  throws Exception {
        ModelMap model = new ModelMap();
        try {
            validarRegistrarPublicacion(mascota, request);
//            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            servicioPublicacion.modificarPublicacion(mascota, publicacion);
        } catch (Exception e) {
            List<Localidad> localidades =  servicioPublicacion.getLocalidades();
            List<Tipo> tiposDeMascota = servicioPublicacion.getTiposDeMascota();
            List<Estado> tiposDeEstado = servicioPublicacion.getEstadosDeMascota();
            model.put("localidades",localidades);
            model.put("tiposDeMascota",tiposDeMascota);
            model.put("tiposDeEstado",tiposDeEstado);
            model.put("error", e.getMessage());
            return new ModelAndView("form-modificar-registro-mascota", model);
        }
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home", model);
    }
//
    @RequestMapping(method = RequestMethod.GET, path = "/ir-al-sitio-modificar-mascota")
    public ModelAndView irAlSitioModificarPublicacion(@ModelAttribute("datosMascota") DatosRegistroMascota mascota, @RequestParam("id") Long id) {
        ModelMap model = new ModelMap();
        Publicacion publicacion;
        List<Localidad> localidades =  servicioPublicacion.getLocalidades();
        List<Tipo> tiposDeMascota = servicioPublicacion.getTiposDeMascota();
        List<Estado> estadosMascota = servicioPublicacion.getEstadosDeMascota();
        model.put("localidades",localidades);
        model.put("tiposDeMascota",tiposDeMascota);
        model.put("estadosMascota",estadosMascota);
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
        }else if (mascota.getEstado().getId() == null){
            throw new Exception("El campo Estado es obligatorio");
        }else if (mascota.getImagen().isEmpty()){
            throw new Exception("El campo Imagen es obligatorio");
        }
    } // el estado esta viniendo null desde el front

    public void validarUsuarioParaFinalizarPublicacion(Usuario usuario, String email) throws Exception {
        if (email != null){
            if (email != ""){
                if (!usuario.getEmail().equals(email)) {
                    if (servicioPublicacion.buscarUsuarioPorEmail(email).isEmpty())
                        throw new Exception("El mail del usuario ingresado no existe");
                }else{
                    throw new Exception("El mail ingresado no puede ser igual que el mail logueado");
                }
            }
        }
    }

}
