package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorBuscarPublicacion {


    private ServicioBuscarPublicacion servicioBuscarPublicacion;

    @Autowired
    public ControladorBuscarPublicacion(ServicioBuscarPublicacion servicioBuscarPublicacion) {

        this.servicioBuscarPublicacion = servicioBuscarPublicacion;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ir-buscar-publicacion")
    public ModelAndView irABuscarMascota() {
        ModelMap model = new ModelMap();
        DatosRegistroMascota datosMascota = new DatosRegistroMascota();
        model.put("datosMascota", datosMascota);
        return new ModelAndView("buscar-publicacion", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/buscar-publicacion")
    public ModelAndView buscarMascota(@ModelAttribute("datosMascota") DatosRegistroMascota mascota) {
        ModelMap model = new ModelMap();
        try {
            servicioBuscarPublicacion.buscarPublicacion(mascota);
        } catch (Exception e) {
            model.put("mensajeBusqueda", "No hay publicaciones");
        }
        model.put("mensajeBusqueda", "Se encontraron publicaciones");
        return new ModelAndView("home", model);
    }
}
