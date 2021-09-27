package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMascotaEncontrada {

    @RequestMapping(method = RequestMethod.GET, path = "/ir-a-mascota-encontrada")
    public ModelAndView irARegistrarMascotaEncontrada(){
        ModelMap model = new ModelMap();
        DatosMascotaEncontrada datosMascotaEncontrada = new DatosMascotaEncontrada();
        model.put("datosMascotaEncontrada", datosMascotaEncontrada);
        return new ModelAndView("form-mascota-encontrada", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/registrarMascotaEncontrada")
    public ModelAndView registrarMascotaEncontrada(){
        ModelMap model = new ModelMap();
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home",model);
    }
}
