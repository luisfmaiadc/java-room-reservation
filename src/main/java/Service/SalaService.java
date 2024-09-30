package Service;

import Config.JPAUtil;
import Dao.SalaDAO;
import Model.Sala;

import javax.persistence.EntityManager;

public class SalaService {

    public void cadastrarSala(String nome, Integer capacidade, String descricao) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        SalaDAO salaDAO = new SalaDAO(entityManager);

        try {
            Sala sala = new Sala(nome, capacidade, descricao);
            entityManager.getTransaction().begin();
            salaDAO.cadastrarSala(sala);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Sala cadastrada com sucesso!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSala(Integer id) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        SalaDAO salaDAO = new SalaDAO(entityManager);

        Sala sala = salaDAO.buscarSala(id);
        return sala != null;
    }


    public void verificarSalaDisponivel(Integer id) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        SalaDAO salaDAO = new SalaDAO(entityManager);
        boolean isSala = this.isSala(id);

        if (isSala) {
            if (salaDAO.isSalaDisponivel(id)) {
                System.out.println("Sala disponível para reserva.");
            } else
                System.out.println("Sala ocupada.");
        } else {
            System.out.println("A ID da sala informada não existe.");
        }
    }
}
