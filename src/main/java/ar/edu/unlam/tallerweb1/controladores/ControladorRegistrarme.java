package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class ControladorRegistrarme {

    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorRegistrarme(ServicioLogin servicioLogin){
        this.servicioLogin = servicioLogin;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/registrarme")
    public ModelAndView registrarUsuario(@ModelAttribute("datos") DatosRegistro datos) {

        ModelMap model = new ModelMap();

        if (esValidoMail(datos.getEmail())) {
            if (esValidoContrasenia(datos.getClave(), datos.getRepiteClave())) {
                try {
                    servicioLogin.registrar(datos.getEmail(), datos.getClave());
                } catch (Exception e) {
                    model.put("error", "Registro Fallido por usuario existente");
                    return new ModelAndView("registro-usuario", model);
                }
                model.put("email", datos.getEmail());
                model.put("msg", "Registro Exitoso");

                DatosLogin datosLogin = new DatosLogin();
                datosLogin.setEmail(datos.getEmail());
                model.put("datos", datos);
                return new ModelAndView("redirect:/login", model);
            } else {
                model.put("error", "Registro Fallido por contraseñas no identicas");
                return new ModelAndView("registro-usuario", model);
            }
        } else {
            model.put("error", "Registro Fallido por mail incorrecto");
            return new ModelAndView("registro-usuario", model);
        }
    }

    //@RequestParam es para ?nombre=valor&ñapellido=valor2
    @RequestMapping(method = RequestMethod.GET,path = "/ir-a-registrarme")
    public ModelAndView irARegistrarme(){
        ModelMap model = new ModelMap();
        DatosRegistro datos = new DatosRegistro();
        model.put("datos", datos);
        return new ModelAndView("registro-usuario",model);
    }


    private boolean esValidoMail(String email) {
        return email.endsWith(".com") && email.contains("@");
    }
    private boolean esValidoContrasenia(String clave, String repiteClave) {
        return clave.equals(repiteClave)  ;
    }



}
