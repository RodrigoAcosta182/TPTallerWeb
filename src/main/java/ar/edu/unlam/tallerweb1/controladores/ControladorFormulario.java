package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorFormulario {

    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-formulario")
    public ModelAndView irAFormulario(){
        ModelMap model = new ModelMap();
        DatosRegistro datos = new DatosRegistro();
//        datos.setEmail("Ingrese su email...");
        model.put("datos", datos);
        return new ModelAndView("form-mascota-perdida",model);
    }
}
