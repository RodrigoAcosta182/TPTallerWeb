package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroProducto;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioProducto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ServicioProductoTest {

    private static final Producto PRODUCTO = new Producto("Cucha para Perro", 30, 6, "img/hellboy.jpg", true);
    private static final DatosRegistroProducto DATOS_PRODUCTO = new DatosRegistroProducto("Cucha para Perro", 30, 6, mock(MultipartFile.class));
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123", 500);

    private RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
    private ServicioProducto servicioProducto = new ServicioProductoImpl(repositorioProducto);

    @Test(expected = Exception.class)
    public void noSeEncuentranProductosPublicados() throws Exception {
        givenQueElProductoNoExiste();
        List<Producto> productos = whenObtengoProductos();
        thenExistenProductos(productos);
    }

    @Test
    public void queSeRegistreUnProductoExitosamente() throws Exception {
        givenQueElProductoNoExiste();
        Producto productos = whenRegistroProducto();
        thenRegistroExitoso(productos);
    }

    @Test
    public void queSeCanjeeUnProductoExitosamente() throws Exception {
        givenQueElProductoExiste(10L);
        whenCanjeoElProducto(10L);
        thenCanjeoElProductoCorrectamente();
    }

    @Test
    public void queSeActualiceLaCantidadDePuntosDeUsuarioExitosamente() throws Exception {
        givenQueElProductoExiste(10L);
        whenCanjeoElProducto(10L);
        thenLosPuntosDeUsuarioSeActualizanCorrectamente();
    }

    private void givenQueElProductoExiste(Long id) {
        when(repositorioProducto.buscarProductoPorId(id)).thenReturn(PRODUCTO);
    }

    private void givenQueElProductoNoExiste() {
        when(repositorioProducto.buscarTodosMisProductos(USUARIO)).thenReturn(null);
    }

    private Producto whenRegistroProducto() throws Exception {
        return servicioProducto.registrarProducto(DATOS_PRODUCTO, USUARIO);
    }

    private List<Producto> whenObtengoProductos() throws Exception {
        return servicioProducto.listarTodosLosProductos(USUARIO);
    }

    private void whenCanjeoElProducto(Long id) throws Exception {
        servicioProducto.canjearProducto(id, USUARIO);
    }

    private void thenExistenProductos(List<Producto> productos) {
        assertThat(productos).isNull();
    }

    private void thenRegistroExitoso(Producto productos) {
        assertThat(productos).isNotNull();
    }

    private void thenCanjeoElProductoCorrectamente() {
        verify(repositorioProducto,times(1)).actualizarCantidadProducto(PRODUCTO);
    }

    private void thenLosPuntosDeUsuarioSeActualizanCorrectamente() {
        verify(repositorioProducto,times(1)).actualizarPuntosUsuario(USUARIO);
    }
}
