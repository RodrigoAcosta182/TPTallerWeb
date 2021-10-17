package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorRegistrarMascota {

    private ServicioRegistrarMascota servicioRegistrarMascota;

    @Autowired
    public ControladorRegistrarMascota(ServicioRegistrarMascota servicioRegistrarMascota){
        this.servicioRegistrarMascota = servicioRegistrarMascota;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-registrar-mascota")
    public ModelAndView irARegistrarMascotaPerdida() {
        ModelMap model = new ModelMap();
        DatosRegistroMascota datosMascota = new DatosRegistroMascota();
        model.put("datosMascota",datosMascota);
        return new ModelAndView("form-registro-mascota",model);
    }
    @RequestMapping(method = RequestMethod.POST,path = "/registrarMascota")
    public ModelAndView registrarMascota(@ModelAttribute("datosMascota") DatosRegistroMascota mascota, HttpServletRequest request) throws Exception{
        ModelMap model = new ModelMap();
        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
        try {
            servicioRegistrarMascota.registrarMascotaPerdida(mascota,request);
        }catch (Exception e){
            model.put("error","El campo tipo y estado es obligatorio");
            return new ModelAndView("form-registro-mascota",model);
        }
        model.put("msg", "Mascota Registrada Exitosamente");
        return new ModelAndView("home",model);
    }

}
