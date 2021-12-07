package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;

public class ControladorProductoTest {

    private static final Producto PRODUCTO_2 = new Producto( "Vaso", 500, 5, "img/tumama.png");
    private static final DatosRegistroProducto PRODUCTO = new DatosRegistroProducto("Cucha para Perro", 30, 6, null);
    private static final DatosRegistroProducto PRODUCTO_NEGATIVO = new DatosRegistroProducto("Cucha para Perro", 30, -5, null);
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123", 50);
    private ServicioProducto servicioProducto = mock(ServicioProducto.class);
    private ControladorProducto controladorProducto = new ControladorProducto(servicioProducto);

    private HttpServletRequest REQUEST = mock(HttpServletRequest.class);
    private HttpSession session = mock(HttpSession.class);
    private RedirectAttributes REDIRECT = mock(RedirectAttributes.class);

    @Before
    public void setup(){
        when(REQUEST.getSession()).thenReturn(session);
        when(session.getAttribute("Usuario")).thenReturn(USUARIO);
    }

    @Test
    public void irAlSitioDelProducto(){
        ModelAndView mav = whenVoyAlSitioDeProductos();
        thenVoyAlSitioDeProductos(mav);
    }

    @Test
    public void irAlSitioParaSubirUnNuevoProducto(){
        ModelAndView mav = whenVoyAlSitioDeRegistroDeProductos();
        thenVoyAlSitioDeRegistroDeProductos(mav);
    }

    @Test
    public void testQueSeSubaUnProductoALaPagina() throws Exception {
        ModelAndView mav = whenSuboUnProducto(PRODUCTO, REQUEST);
        thenElRegistroDeProductoEsExitoso(mav);
    }

    @Test
    public void noSeEncuentraNingunProducto() throws Exception {
        givenQueNoEncuentroProducto();
        ModelAndView mav = whenObtengoProductos();
        thenNoEncuentroProductos(mav, "No hay productos");
    }

    @Test
    public void noSePuedeRegistrarProductosConCantidadMenorOIgualACero() throws Exception {
        givenQueElProductoExisteConCantidadMenorOIgualACero();
        ModelAndView mav = whenSuboUnProducto(PRODUCTO_NEGATIVO, REQUEST);
        thenNoSeSubeElProducto(mav, "El stock no puede ser negativo");
    }

    @Test
    public void noSePuedeCanjearProductosSinLosPuntosNecesarios() throws Exception {
        givenQueElProductoExisteConPuntosMayorAlUsuario();
        ModelAndView mav = whenCanjeoUnProducto(PRODUCTO_2, REQUEST);
        thenNoSeSubeElProducto(mav, "Lo siento, no te alcanza para canjear este producto :(");
    }

    private void givenQueElProductoExisteConPuntosMayorAlUsuario() throws Exception {
        doThrow(Exception.class).when(servicioProducto).canjearProducto(PRODUCTO_2.getId(), USUARIO);
    }

    private void givenQueElProductoExisteConCantidadMenorOIgualACero() throws Exception {
        doThrow(Exception.class).when(servicioProducto).registrarProducto(PRODUCTO_NEGATIVO, USUARIO);
    }

    private void givenQueNoEncuentroProducto() throws Exception {
        doThrow(Exception.class).when(servicioProducto).listarTodosLosProductos();
    }

    private ModelAndView whenCanjeoUnProducto(Producto producto, HttpServletRequest request) throws Exception {
        return controladorProducto.canjearProducto(producto.getId(), REQUEST);
    }

    private ModelAndView whenObtengoProductos() {
        return controladorProducto.irAVistaDeProductos(mock(HttpServletRequest.class));
    }

    private ModelAndView whenSuboUnProducto(DatosRegistroProducto producto, HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("Usuario", USUARIO);
        return controladorProducto.registrarProducto(producto, REQUEST, REDIRECT);
    }

    private ModelAndView whenVoyAlSitioDeProductos() {
        return controladorProducto.irAVistaDeProductos(mock(HttpServletRequest.class));
    }

    private ModelAndView whenVoyAlSitioDeRegistroDeProductos() {
        return controladorProducto.irAVistaDeRegistroDeProductos();
    }

    private void thenNoEncuentroProductos(ModelAndView mav, String msg) {
        assertThat(mav.getModel().get("productoError")).isEqualTo(msg);
    }

    private void thenElRegistroDeProductoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/ir-a-productos");
        assertThat(mav.getModel().get("msg")).isEqualTo("Producto Registrado Exitosamente");
    }

    private void thenVoyAlSitioDeProductos(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("Productos");
    }

    private void thenVoyAlSitioDeRegistroDeProductos(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("form-registro-producto");
    }

    private void thenNoSeSubeElProducto(ModelAndView mav, String msg) {
        assertThat(mav.getModel().get("error")).isEqualTo(msg);
    }
}
