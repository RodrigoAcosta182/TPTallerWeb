package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarMascotaPerdida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControladorRegistrarMascota {

    private ServicioRegistrarMascotaPerdida servicioRegistrarMascotaPerdida;

    @Autowired
    public ControladorRegistrarMascota(ServicioRegistrarMascotaPerdida servicioRegistrarMascotaPerdida){
        this.servicioRegistrarMascotaPerdida = servicioRegistrarMascotaPerdida;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-registrar-mascota-perdida")
    public ModelAndView irARegistrarMascotaPerdida() {
        ModelMap model = new ModelMap();
        DatosRegistroMascota datosMascota = new DatosRegistroMascota();
        model.put("datosMascota",datosMascota);
        return new ModelAndView("form-mascota-perdida",model);
    }
    @RequestMapping(method = RequestMethod.GET,path = "/registrarMascota")
    public ModelAndView registrarMascota(DatosRegistroMascota mascota) {
        ModelMap model = new ModelMap();
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home",model);
    }



}
