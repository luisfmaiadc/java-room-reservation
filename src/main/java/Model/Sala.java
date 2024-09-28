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
    private boolean disponivel;

    @OneToMany(mappedBy = "sala")
    private List<Reserva> reservas;

    public Sala(String nome, Integer capacidade, String descricao, boolean disponivel) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.disponivel = disponivel;
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
}
