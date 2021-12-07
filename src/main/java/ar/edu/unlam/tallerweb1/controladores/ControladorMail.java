package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorMail {
    ServicioMail servicioMail;
    @Autowired
    public ControladorMail(ServicioMail servicioMail) {
        this.servicioMail = servicioMail;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/enviarCorreo")
    public ModelAndView enviarCorreo(@ModelAttribute("datosCorreo") DatosCorreo datosCorreo, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelMap model = new ModelMap();
        //ver que imprima mensaje error and success
        try {
            datosCorreo.validar();
            Usuario usuario = (Usuario) request.SgetSession().getAttribute("Usuario");
            servicioMail.enviarCorreo(datosCorreo.getReceptor(), datosCorreo.getComentario(),usuario, datosCorreo.getIdPublicacion());
        } catch (Exception e) {
            model.put("mailError", e.getMessage());
            return new ModelAndView("ver-publicacion", model);
        }
        String mensaje = "Mensaje enviado correctamente";
        model.put("mailOk",mensaje);
        redirectAttributes.addFlashAttribute("mailOk", mensaje);
        return new ModelAndView("redirect:/publicacion?id=" + datosCorreo.getIdPublicacion(), model);
    }

}
