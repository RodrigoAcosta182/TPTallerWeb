package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPublicacion {


    private  ServicioPublicacion servicioPublicacion;
    @Autowired
    public ControladorPublicacion(ServicioPublicacion servicioPublicacion){
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-publicacion-mascota-perdida")
    public ModelAndView irAPublicacionMascotaPerdida() {
        ModelMap model = new ModelMap();
        model.put("publicaciones","publicaciones de mascotas");
        return new ModelAndView("publicaciones-perdidos",model);

    }

}
