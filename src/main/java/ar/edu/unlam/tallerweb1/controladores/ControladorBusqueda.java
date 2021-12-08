package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorBusqueda {

    private final ServicioBusqueda servicioBusqueda;


    @Autowired
    public ControladorBusqueda(ServicioBusqueda servicioBusqueda) {
        this.servicioBusqueda = servicioBusqueda;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-busqueda")
    public ModelAndView irAVerPaginaDeBusqueda() {
        DatosRegistroMascota datos = new DatosRegistroMascota();
        ModelMap model = new ModelMap();
        List<Localidad> localidades = servicioBusqueda.getLocalidades();
        List<Tipo> tiposDeMascota = servicioBusqueda.getTiposDeMascota();
        List<Estado> estadosMascota = servicioBusqueda.getEstadosDeMascota();
        model.put("datosMascota", datos);
        model.put("localidades", localidades);
        model.put("tiposDeMascota", tiposDeMascota);
        model.put("estadosMascota", estadosMascota);
        return new ModelAndView("buscar-publicacion", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/buscar-publicaciones")
    public ModelAndView buscarPublicaciones(@ModelAttribute("datosMascota") DatosRegistroMascota mascota, RedirectAttributes redirectAttributes){
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            publicaciones = servicioBusqueda.buscarPublicaciones(mascota);
        } catch (Exception e) {
            String mensaje = "No se encontraron publicaciones";
            model.put("publicacionesError",mensaje);
//            redirectAttributes.addFlashAttribute("publicacionesError", mensaje);
            return new ModelAndView("publicaciones-filtradas-busqueda", model);
        }
        model.put("mensajeOK", "Se encontraron publicaciones");
        model.put("publicaciones", publicaciones);
        return new ModelAndView("publicaciones-filtradas-busqueda", model);
    }

}
