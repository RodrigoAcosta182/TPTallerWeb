package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        model.put("datosMascota", datos);
        model.put("localidades", localidades);
        return new ModelAndView("buscar-publicacion", model);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/buscar-publicaciones")
    public ModelAndView buscarPublicaciones(@ModelAttribute("datosMascota") DatosRegistroMascota mascota) throws Exception {
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            publicaciones = servicioBusqueda.buscarPublicaciones(mascota);
        } catch (Exception e) {
            model.put("mensajeError", "No se encontraron publicaciones");
            return new ModelAndView("buscar-publicacion", model);
        }
        model.put("mensajeOK", "Se encontraron publicaciones");
        model.put("publicacionesList", publicaciones);
        return new ModelAndView("publicaciones-filtradas-busqueda", model);
    }



}
