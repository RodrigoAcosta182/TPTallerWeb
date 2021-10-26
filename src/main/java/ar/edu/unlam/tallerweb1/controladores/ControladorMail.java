package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMail {
    ServicioMail servicioMail;
    @Autowired
    public ControladorMail(ServicioMail servicioMail) {
        this.servicioMail = servicioMail;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/enviarCorreo")
    public ModelAndView enviarCorreo(@ModelAttribute("datosCorreo") DatosCorreo datosCorreo) {
        ModelMap model = new ModelMap();
        try {
            servicioMail.enviarCorreo(datosCorreo.getReceptor(), datosCorreo.getComentario());
        } catch (Exception e) {
            model.put("mailError", "error al enviar el mensaje");
            return new ModelAndView("ver-publicacion", model);
        }
        model.put("mailOk", "Mensaje enviado correctamente");
        return new ModelAndView("ver-publicacion", model);
    }
}
