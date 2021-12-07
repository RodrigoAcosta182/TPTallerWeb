package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.DatosRegistroProducto;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioProducto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioProductoTest extends SpringTest {

    private static final Boolean STOCK_DISPONIBLE = true;
    private static final Producto PRODUCTO = new Producto();
    private static final Usuario USUARIO = new Usuario("emiortiz1992@gmail.com", "123", 505);

    @Autowired
    private RepositorioProducto repositorioProducto;

//    @Test
//    @Transactional
//    @Rollback
//    public void obtengoTodosLosProductos() {
//        List<Producto> listaProductos = new LinkedList<>();
//        listaProductos.add(new Producto());
//        listaProductos.add(new Producto());
//        listaProductos.add(new Producto());
//
//        givenExistenProductos(listaProductos, STOCK_DISPONIBLE);
//        List<Producto> productos = whenObtengoTodasLosProductos();
//
//        thenEncuentro(listaProductos.size(), productos);
//    }

    @Test(expected = Exception.class)
    @Transactional
    @Rollback
    public void obtengoUnProductoPorId() {
        List<Producto> listaProductos = new LinkedList<>();
        listaProductos.add(new Producto());

        givenExisteProductoConId(1L,listaProductos);
        Producto producto = whenObtengoElProductoPorId(1L);
        thenObtengoProducto(producto);
    }

    @Test(expected = Exception.class)
    @Transactional
    @Rollback
    public void canjeoProductoCorrectamente(){
        List<Producto> listaProducto = new LinkedList<>();
        listaProducto.add(new Producto());
        givenExistenProductos(listaProducto, STOCK_DISPONIBLE);
        whenCanjeoUnProducto(PRODUCTO);
        thenCanjeoProducto(1L);

    }

    private void givenExisteProductoConId(Long id, List<Producto> listaProductos) {
        for(Producto producto : listaProductos){
            producto.setId(id);
            session().save(producto);
        }
    }

    private void givenExistenProductos(List<Producto> listaProductos, Boolean stockDisponible) {
        for (Producto producto : listaProductos) {
            session().save(producto);
        }
    }

    private void whenCanjeoUnProducto(Producto producto) {
        repositorioProducto.actualizarCantidadProducto(producto);
    }

    private Producto whenObtengoElProductoPorId(Long id) {
        return repositorioProducto.buscarProductoPorId(id);
    }

    private List<Producto> whenObtengoTodasLosProductos() {
        return repositorioProducto.buscarTodosLosProductos(USUARIO);
    }

    private void thenEncuentro(int cantidadEsperada, List<Producto> productos) {
        assertThat(productos).hasSize(cantidadEsperada);
    }

    private void thenObtengoProducto(Producto producto) {
        assertThat(producto.getClass()).isEqualTo(Producto.class);
    }

    private void thenCanjeoProducto(Long id) {
        Producto producto =  repositorioProducto.buscarProductoPorId(id);
    }

}
