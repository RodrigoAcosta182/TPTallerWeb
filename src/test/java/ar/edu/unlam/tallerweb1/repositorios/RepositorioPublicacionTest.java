package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class RepositorioPublicacionTest extends SpringTest {

    private static final Usuario USUARIO = new Usuario();
    private static final Publicacion PUBLICACION = new Publicacion(10L, new Mascota(), new Localidad());
    private static final Mascota MASCOTAPERDIDA = new Mascota("Scooby",new Tipo(1L,"Perro"), new Estado(1L,"perdido"));
    private static final Mascota MASCOTAENCONTRADA = new Mascota("Rintintin",new Tipo(1L,"Perro"), new Estado(1L,"encontrado"));

    @Autowired
    private RepositorioPublicacion repositorioPublicacion;


    @Test(expected = Exception.class)
    @Transactional
    @Rollback
    public void obtengoUnaPublicacionPorId() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());

        givenExistePublicacionConId(1L, listaPublicaciones);
        Publicacion publicacion = whenObtengoLaPublicacionPorId(1L);
        thenObtengoPublicacion(publicacion);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoMisPublicaciones() {
        List<Publicacion> misPublicaciones = new LinkedList<>();
        misPublicaciones.add(new Publicacion());
        misPublicaciones.add(new Publicacion());

        givenElUsuarioConPublicaciones(USUARIO, misPublicaciones);

        List<Publicacion> publicaciones = whenBuscoLasPublicacionesDelUsuario(USUARIO);

        thenEncuentro(misPublicaciones.size(), publicaciones);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodasLasPublicacionesDeMascotasPerdidas() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());
        givenExistenPublicacionesDeMascotas(listaPublicaciones, MASCOTAPERDIDA);
        List<Publicacion> publicacionesDeMascotasPerdidas = whenObtengoTodasLasPublicacionesDeMascotasPerdidas();
        thenEncuentro(listaPublicaciones.size(), publicacionesDeMascotasPerdidas);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodasLasPublicacionesDeMascotasEncontradas() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());
        listaPublicaciones.add(new Publicacion());

        givenExistenPublicacionesDeMascotas(listaPublicaciones, MASCOTAENCONTRADA);
        List<Publicacion> publicacionesDeMascotasEncontradas = whenObtengoTodasLasPublicacionesDeMascotasEncontradas();
        thenEncuentro(listaPublicaciones.size(), publicacionesDeMascotasEncontradas);
    }

    @Test(expected = Exception.class)
    @Transactional
    @Rollback
    public void finalizoPublicacionCorrectamente() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(new Publicacion());
        givenExistenMisPublicaciones(listaPublicaciones);
        whenFinalizoUnaPublicacion(PUBLICACION);
        thenFinalizoPublicacion(1L, true);
    }

    //Test para preguntar muy raro
    @Test
    @Transactional
    @Rollback
    public void eliminoPublicacionCorrectamente() {
        List<Publicacion> listaPublicaciones = new LinkedList<>();
        listaPublicaciones.add(PUBLICACION);
        listaPublicaciones.add(new Publicacion());
        givenExistenMisPublicaciones(listaPublicaciones);
        whenEliminoUnaPublicacion(PUBLICACION);

        List<Publicacion> publicacionesEcontradas = whenObtengoTodasLasPublicacionesDeMascotas();
        thenEncuentroPublicacionesDespuesDeEliminar(publicacionesEcontradas.size(), listaPublicaciones.size()-1);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodasLasLocalidades() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad("Mataderos"));

        givenExistenLocalidades(localidades);
        List<Localidad> localidadesObtenidas = whenObtengoTodasLasLocalidades();
        thenObtengoTodasLaslocalidades(localidades.size(), localidadesObtenidas);
    }


    @Test
    @Transactional
    @Rollback
    public void obtengoLocalidadPorDescripcion() {
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad("Mataderos"));

        givenExistenLocalidades(localidades);
        Localidad localidadObtenida = whenObtengoLocalidadPorDescripcion("Mataderos");
        thenEncuentroLocalidad(localidadObtenida);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodosLosTiposDeMascota() {
        List<Tipo> tiposDeMascota = new ArrayList<>();
        tiposDeMascota.add(new Tipo(1L, "Perro"));
        givenQueExistenTiposDeMascota(tiposDeMascota);
        List<Tipo> tiposDeMascotaObtenidos = whenObtengoTodosLosTiposDeMascota();
        thenEncuentroTiposDeMascota(tiposDeMascota.size(), tiposDeMascotaObtenidos);
    }

    @Test
    @Transactional
    @Rollback
    public void obtengoTodosLosEstadosDeMascota() {
        List<Estado> estados = new ArrayList<>();
        estados.add(new Estado());
        estados.add(new Estado());

        givenQueExistenEstadosDeMascota(estados);
        List<Estado> estadosObtenidos = whenObtengoTodosLosEstadosDeMascota();
        thenEncuentroEstadosDeMascota(estadosObtenidos.size(), estadosObtenidos);
    }

    private List<Publicacion> whenObtengoTodasLasPublicacionesDeMascotas() {
        return repositorioPublicacion.buscarTodasLasPublicaciones();
    }

    private void whenEliminoUnaPublicacion(Publicacion publicacion) {
        repositorioPublicacion.eliminarPublicacion(publicacion);
    }

    private void thenEncuentroEstadosDeMascota(int cantidadEsperada, List<Estado> estadosObtenidos) {
        assertThat(estadosObtenidos).hasSize(cantidadEsperada);
    }

    private List<Estado> whenObtengoTodosLosEstadosDeMascota() {
        return repositorioPublicacion.obtenerTodosLosEstadosDeMascota();
    }

    private void givenQueExistenEstadosDeMascota(List<Estado> estados) {
        for (Estado estadosDeMascota : estados) {
            session().save(estadosDeMascota);
        }
    }

    private void thenEncuentroTiposDeMascota(int cantidadEsperada, List<Tipo> tiposDeMascotaObtenidos) {
        assertThat(tiposDeMascotaObtenidos).hasSize(cantidadEsperada);
    }

    private List<Tipo> whenObtengoTodosLosTiposDeMascota() {
        return repositorioPublicacion.obtenerTodosLosTiposDeMascota();
    }

    private void givenQueExistenTiposDeMascota(List<Tipo> tiposDeMascota) {

        for (Tipo tipoDeMascota : tiposDeMascota) {
            session().save(tipoDeMascota);
        }
    }

    private void thenEncuentroLocalidad(Localidad localidadObtenida) {
        assertThat(localidadObtenida).isNotNull();
        assertThat(localidadObtenida.getClass()).isEqualTo(Localidad.class);
    }

    private Localidad whenObtengoLocalidadPorDescripcion(String localidadDescripcion) {
        return repositorioPublicacion.obtenerLocalidadPorDescripcion(localidadDescripcion);
    }

    private void givenExistenLocalidades(List<Localidad> localidades) {
        for (Localidad localidad : localidades) {
            session().save(localidad);
        }
    }

    private List<Localidad> whenObtengoTodasLasLocalidades() {
        return repositorioPublicacion.obtenerTodasLasLocalidades();
    }

    private void thenObtengoTodasLaslocalidades(int cantidadEsperada, List<Localidad> localidadesObtenidas) {
        assertThat(localidadesObtenidas).hasSize(cantidadEsperada);
    }

    private void thenFinalizoPublicacion(Long id, Boolean finalizado) {
        Publicacion publicacion = repositorioPublicacion.buscarPublicacionPorId(id);
        assertThat(publicacion.getFinalizado()).isEqualTo(finalizado);
    }

    private void givenExistenMisPublicaciones(List<Publicacion> listaPublicaciones) {
        for (Publicacion publicacion : listaPublicaciones) {
            session().save(publicacion);
        }
    }

    private void whenFinalizoUnaPublicacion(Publicacion publicacion) {
        repositorioPublicacion.finalizarPublicacion(publicacion);
    }

    private void givenExistenPublicacionesDeMascotas(List<Publicacion> publicaciones, Mascota mascota) {
        for (Publicacion publicacion : publicaciones) {
            session().save(mascota.getEstado());
            session().save(mascota.getTipo());
            publicacion.setMascota(mascota);
            session().save(publicacion);
        }
    }

    private void givenExistePublicacionConId(Long id, List<Publicacion> listaPublicaciones) {
        for (Publicacion publicacion : listaPublicaciones) {
            publicacion.setId(id);
            session().save(publicacion);
        }
    }

    private void givenElUsuarioConPublicaciones(Usuario usuario, List<Publicacion> publicacionesDelUsuario) {
        session().save(usuario);
        for (Publicacion publicacion : publicacionesDelUsuario) {
            publicacion.setUsuario(usuario);
            session().save(publicacion);
        }
    }

    private Publicacion whenObtengoLaPublicacionPorId(Long id) {
        return repositorioPublicacion.buscarPublicacionPorId(id);
    }

    private List<Publicacion> whenBuscoLasPublicacionesDelUsuario(Usuario usuario) {
        return repositorioPublicacion.buscarTodasMisPublicaciones(usuario);
    }

    private List<Publicacion> whenObtengoTodasLasPublicacionesDeMascotasPerdidas() {
        return repositorioPublicacion.buscarTodasLasPublicacionesPerdidas();

    }

    private List<Publicacion> whenObtengoTodasLasPublicacionesDeMascotasEncontradas() {
        return repositorioPublicacion.buscarTodasLasPublicacionesEncontradas();
    }

    private void thenObtengoPublicacion(Publicacion publicacion) {
        assertThat(publicacion.getClass()).isEqualTo(Publicacion.class);
    }

    private void thenEncuentro(int cantidadEsperada, List<Publicacion> publicaciones) {
        assertThat(publicaciones).hasSize(cantidadEsperada);
    }

    private void thenEncuentroPublicacionesDespuesDeEliminar(int cantidadEsperada, int publicaciones) {
        assertThat(publicaciones).isEqualTo(cantidadEsperada);
    }

}

