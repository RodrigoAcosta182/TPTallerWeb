package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioVerPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

@Controller
public class ControladorVerPublicacion {

    ServicioVerPublicacion servicioVerPublicacion;
    @Autowired
    public ControladorVerPublicacion(ServicioVerPublicacion servicioVerPublicacion){
        this.servicioVerPublicacion = servicioVerPublicacion;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-ver-publicacion")
    public ModelAndView irAVerPublicacion() {
        return new ModelAndView("ver-publicacion");
    }


    @RequestMapping(method = RequestMethod.POST,path = "/enviarCorreo")
    public ModelAndView enviarCorreo(@ModelAttribute("datosCorreo") DatosCorreo datosCorreo ) throws Exception {
       servicioVerPublicacion.enviarCorreo(datosCorreo.getReceptor());
        return new ModelAndView("ver-publicacion");
    }
}
