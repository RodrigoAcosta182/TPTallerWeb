package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroProducto;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioProductoTest {

    private static final DatosRegistroProducto PRODUCTO = new DatosRegistroProducto("Cucha para Perro", 30, 6, mock(MultipartFile.class));
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123");

    private RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
    private ServicioProducto servicioProducto = new ServicioProductoImpl(repositorioProducto);

    @Test(expected = Exception.class)
    public void noSeEncuentranProductosPublicados() throws Exception {
        givenQueLaPublicacionNoExiste();
        List<Producto> productos = whenObtengoProductos();
        thenExistenProductos(productos);
    }

    @Test
    public void queSeRegistreUnProductoExitosamente() throws Exception {
        givenQueLaPublicacionNoExiste();
        Producto productos = whenRegistroProducto();
        thenRegistroExitoso(productos);
    }

    private void givenQueLaPublicacionNoExiste() {
        when(repositorioProducto.buscarTodosMisProductos(USUARIO)).thenReturn(null);
    }

    private Producto whenRegistroProducto() throws Exception {
        return servicioProducto.registrarProducto(PRODUCTO, USUARIO);
    }

    private List<Producto> whenObtengoProductos() throws Exception {
        return servicioProducto.listarTodosLosProductos(USUARIO);
    }

    private void thenExistenProductos(List<Producto> productos) {
        assertThat(productos).isNull();
    }

    private void thenRegistroExitoso(Producto productos) {
        assertThat(productos).isNotNull();
    }
}
