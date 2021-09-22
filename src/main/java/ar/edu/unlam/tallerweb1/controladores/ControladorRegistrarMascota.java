package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControladorRegistrarMascota {

    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-registrar-mascota-perdida")
    public ModelAndView irARegistrarMascotaPerdida() {
        ModelMap model = new ModelMap();
        DatosRegistroMascota datosMascota = new DatosRegistroMascota();
        model.put("datosMascota",datosMascota);
        return new ModelAndView("form-mascota-perdida");
    }
    @RequestMapping(method = RequestMethod.GET,path = "/registrarMascota")
    public ModelAndView registrarMascota(DatosRegistroMascota mascota) {
        ModelMap model = new ModelMap();
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home",model);
    }
    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-registrar-mascota-perdida")
    public ModelAndView irALaHomeDeLaPagina() {
        ModelMap model = new ModelMap();
        model.put("msg","Se volvio a la home exitosamente");
        return new ModelAndView("home",model);
    }


}
