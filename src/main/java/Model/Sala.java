package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer capacidade;
    private String descricao;
    private Boolean disponivel = Boolean.TRUE;

    @OneToMany(mappedBy = "sala")
    private List<Reserva> reservas;

    public Sala(String nome, Integer capacidade, String descricao) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.descricao = descricao;
    }

    public Sala() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
