package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorBuscarMascota {


    private ServicioBuscarMascota servicioBuscarMascota;

    @Autowired
    public ControladorBuscarMascota(ServicioBuscarMascota servicioBuscarMascota){

        this.servicioBuscarMascota = servicioBuscarMascota;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/ir-buscar-mascota")
    public ModelAndView irABuscarMascota() {
        ModelMap model = new ModelMap();
        DatosRegistroMascota datosMascota = new DatosRegistroMascota();
        model.put("datosMascota",datosMascota );
        return new ModelAndView("buscar-mascota",model);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/buscar-mascota")
    public ModelAndView buscarMascota(@ModelAttribute("datosMascota") DatosRegistroMascota mascota) {
        ModelMap model = new ModelMap();
        model.put("mensajeBusqueda","Se encontraron mascotas");
        return new ModelAndView("home",model);
    }
}
