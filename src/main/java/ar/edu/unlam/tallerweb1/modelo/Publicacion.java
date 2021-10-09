package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaPublicacion;
    private Byte finalizado;
    @ManyToOne
    private Mascota mascotaid;
    @ManyToOne
    private Usuario usuarioId;

}
