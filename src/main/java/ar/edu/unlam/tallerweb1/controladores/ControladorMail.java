package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorMail {
    ServicioMail servicioMail;
    @Autowired
    public ControladorMail(ServicioMail servicioMail) {
        this.servicioMail = servicioMail;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/enviarCorreo")
    public ModelAndView enviarCorreo(@ModelAttribute("datosCorreo") DatosCorreo datosCorreo, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            servicioMail.enviarCorreo(datosCorreo.getReceptor(), datosCorreo.getComentario(),usuario);
        } catch (Exception e) {
            model.put("mailError", "error al enviar el mensaje");
            return new ModelAndView("ver-publicacion", model);
        }
        model.put("mailOk", "Mensaje enviado correctamente");
        return new ModelAndView("ver-publicacion", model);
    }

}
