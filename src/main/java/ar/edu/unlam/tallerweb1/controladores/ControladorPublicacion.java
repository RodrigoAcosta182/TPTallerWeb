package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
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
        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
        usuario.getId();
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
        publicaciones = servicioPublicacion.listarTodasLasPublicaciones();
        } catch (Exception e) {
        model.put("publicacionesError", "No hay publicaciones");
            return new ModelAndView("publicaciones-perdidos", model);
        }
        model.put("publicaciones", publicaciones);
        return new ModelAndView("publicaciones-perdidos", model);
    }

}
