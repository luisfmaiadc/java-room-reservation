package Dao;

import Model.Sala;

import javax.persistence.EntityManager;

public class SalaDAO {

    private EntityManager entityManager;

    public SalaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarSala(Sala sala) {
        entityManager.persist(sala);
    }

    public void atualizarSala(Sala sala) {
        entityManager.merge(sala);
    }

    public void removerSala(Sala sala) {
        sala = entityManager.merge(sala);
        entityManager.remove(sala);
    }

}
