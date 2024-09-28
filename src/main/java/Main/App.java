package Main;

import Config.JPAUtil;
import Dao.ReservaDAO;
import Dao.SalaDAO;
import Dao.UsuarioDAO;
import Model.Reserva;
import Model.Sala;
import Model.Usuario;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        System.out.println("Seja bem-vindo(a) ao Sistema de Reservas de Sala utilizando JPA e Hibernate.");
        popularBanco();
    }

    private static void popularBanco() {

        Usuario usuario = new Usuario("Luis Felipe", "lf.mcosta23@gmail.com");
        Sala sala = new Sala("Sala 01 - Térreo", 30, "Sala com projetor e bancos inclinados",
                true);
        LocalDateTime dataInicio = LocalDateTime.of(2024, 9, 28, 10, 0);
        LocalDateTime dataFim = LocalDateTime.of(2024, 9, 28, 12, 0);
        Reserva reserva = new Reserva(dataInicio, dataFim, usuario, sala);

        EntityManager entityManager = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);
        SalaDAO salaDAO = new SalaDAO(entityManager);
        ReservaDAO reservaDAO = new ReservaDAO(entityManager);

        entityManager.getTransaction().begin();

        usuarioDAO.cadastrarUsuario(usuario);
        salaDAO.cadastrarSala(sala);
        reservaDAO.cadastrarReserva(reserva);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
