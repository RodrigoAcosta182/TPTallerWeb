package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import org.springframework.stereotype.Repository;

@Repository("RepositorioBuscarPublicacion")
public class RepositorioBuscarPublicacionImpl implements RepositorioBuscarPublicacion{
    @Override
    public Publicacion buscarPublicacionPorTipo(String tipo) {
        return null;
    }
}
