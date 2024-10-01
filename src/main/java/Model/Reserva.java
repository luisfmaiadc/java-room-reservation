package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataReserva = LocalDate.now();
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSala", nullable = false)
    private Sala sala;

    public Reserva(LocalDateTime dataInicio, LocalDateTime dataFim, Usuario usuario, Sala sala) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.usuario = usuario;
        this.sala = sala;
    }

    public Reserva() {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public Sala getSala() {
        return sala;
    }

    @Override
    public String toString() {
        return "Reserva {" +
                "ID=" + id +
                ", Data da Reserva =" + dataReserva +
                ", Horário de Início =" + dataInicio +
                ", Horário do Fim =" + dataFim +
                ", Usuário =" + usuario.getNome() +
                ", Sala =" + sala.getNome() +
                '}';
    }
}
