package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroProducto;
import ar.edu.unlam.tallerweb1.modelo.UsuarioProducto;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@Service("servicioProducto")
@Transactional
public class ServicioProductoImpl implements ServicioProducto{

    private final RepositorioProducto repositorioProducto;

    @Autowired
    public ServicioProductoImpl(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    @Autowired
    ServletContext servletContext;

    @Override
    public Producto registrarProducto(DatosRegistroProducto producto, Usuario usuario) throws Exception {

        Producto nuevoProducto = producto.toProducto();

        String nombreConRuta = "imgProducto/" + producto.getImgproducto().getOriginalFilename();
        nuevoProducto.setImgproducto(nombreConRuta);

        String filename = "C:\\Taller WEB\\TPTallerWeb\\src\\main\\webapp\\imgProducto\\" + producto.getImgproducto().getOriginalFilename();
        producto.getImgproducto().transferTo(new File(filename));

        repositorioProducto.guardarProducto(nuevoProducto);

        return nuevoProducto;
    }

    @Override
    public Producto buscarProducto(Long id) {
        return repositorioProducto.buscarProductoPorId(id);

    }

    @Override
    public void canjearProducto(Long id, Usuario usuario) throws Exception {
        Producto producto = repositorioProducto.buscarProductoPorId(id);

        if (producto.getCantidad() > 0) {
            if (usuario.getPuntos() >= producto.getPuntos()) {
                UsuarioProducto usuarioProducto = new UsuarioProducto();
                usuarioProducto.setUsuario(usuario);
                usuarioProducto.setProducto(producto);
                usuarioProducto.setCantidad(1);
                repositorioProducto.canjearProducto(usuarioProducto);

                usuario.setPuntos(usuario.getPuntos() - producto.getPuntos());
                producto.setCantidad(producto.getCantidad() - 1) ;
                repositorioProducto.actualizarPuntosUsuario(usuario);
                repositorioProducto.actualizarCantidadProducto(producto);
            }else {
                throw new Exception();
            }
        }
    }

    @Override
    public List<Producto> listarTodosLosProductos(Usuario usuario) throws Exception {
        if (repositorioProducto.buscarTodosLosProductos(usuario).size() == 0)
            throw new Exception();
        return repositorioProducto.buscarTodosLosProductos(usuario);
    }
}
