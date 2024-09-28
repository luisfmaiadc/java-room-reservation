package Dao;

import Model.Reserva;

import javax.persistence.EntityManager;

public class ReservaDAO {

    private EntityManager entityManager;

    public ReservaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarReserva(Reserva reserva) {
        entityManager.persist(reserva);
    }

    public void atualizarReserva(Reserva reserva) {
        entityManager.merge(reserva);
    }

    public void removerReserva(Reserva reserva) {
        reserva = entityManager.merge(reserva);
        entityManager.remove(reserva);
    }
}
