package Service;

import Config.JPAUtil;
import Dao.ReservaDAO;
import Dao.SalaDAO;
import Dao.UsuarioDAO;
import Model.Reserva;
import Model.Sala;
import Model.Usuario;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class ReservaService {


    public void cadastrarReserva(LocalDateTime dataInicio, LocalDateTime dataFim,
                                 Integer idUsuario, Integer idSala) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        ReservaDAO reservaDAO = new ReservaDAO(entityManager);

        UsuarioService usuarioService = new UsuarioService();
        SalaService salaService = new SalaService();
        boolean isUsuario = usuarioService.isUsuario(idUsuario);
        boolean isSala = salaService.isSala(idSala);
        if (isUsuario) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);
            Usuario usuario = usuarioDAO.buscarUsuario(idUsuario);
            if (isSala) {
                SalaDAO salaDAO = new SalaDAO(entityManager);
                Sala sala = salaDAO.buscarSala(idSala);
                boolean isSalaDisponivel = salaDAO.isSalaDisponivel(sala.getId());
                if (isSalaDisponivel) {
                    try {
                        Reserva reserva = new Reserva(dataInicio, dataFim, usuario, sala);
                        entityManager.getTransaction().begin();
                        reservaDAO.cadastrarReserva(reserva);
                        sala.setDisponivel(false);
                        salaDAO.atualizarSala(sala);
                        entityManager.getTransaction().commit();
                        entityManager.close();
                        System.out.println("Reserva realizada com sucesso!");
                    } catch (RuntimeException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("A sala informada já foi reservada por outro usuário.");
                }
            } else {
                System.out.println("O ID da sala informada não existe.");
            }
        } else {
            System.out.println("O ID de usuário informado não existe.");
        }
    }

    public void buscarReserva(Integer id) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        ReservaDAO reservaDAO = new ReservaDAO(entityManager);

        UsuarioService usuarioService = new UsuarioService();
        boolean isUsuario = usuarioService.isUsuario(id);
        if (isUsuario) {
            List<Reserva> reservaList = reservaDAO.buscarReserva(id);
            if (!reservaList.isEmpty()) {
                reservaList.forEach(System.out::println);
            } else {
                System.out.println("Nenhuma reserva encontrada para o ID de usuário informado.");
            }
        } else {
            System.out.println("O ID de usuário informado não existe.");
        }
    }
}
