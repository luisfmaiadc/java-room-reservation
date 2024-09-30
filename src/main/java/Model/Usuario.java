package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    public Usuario() {
    }

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "ID =" + id +
                ", Nome ='" + nome +
                ", E-mail ='" + email +
                '}';
    }
}
