package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataReserva;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idSala")
    private Sala sala;

    public Reserva(Integer id, LocalDate dataReserva, LocalDateTime dataInicio, LocalDateTime dataFim,
                   Integer idUsuario, Usuario usuario, Sala sala) {
        this.id = id;
        this.dataReserva = dataReserva;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.sala = sala;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Sala getSala() {
        return sala;
    }
}
