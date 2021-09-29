package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Mascota;

import java.util.List;

public interface RepositorioMascotaPerdida {
    List<Mascota> buscarMascotaPorTipo(String tipo);
    void guardarMascota(Mascota mascota);
    List<Mascota> buscarPorId(Long id);
}
