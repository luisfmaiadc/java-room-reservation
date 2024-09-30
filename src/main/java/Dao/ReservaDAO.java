package Dao;

import Model.Reserva;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

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

    public List<Reserva> buscarReserva(Integer id) {
        String jpql = "SELECT r FROM Reserva r WHERE r.usuario.id = :usuarioID";
        return entityManager.createQuery(jpql, Reserva.class).setParameter("usuarioID", id)
                .getResultList();
    }

    public List<Reserva> buscarReservaPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reserva> criteriaQuery = builder.createQuery(Reserva.class);
        Root<Reserva> root = criteriaQuery.from(Reserva.class);

        Predicate filtro = builder.and(
                builder.greaterThanOrEqualTo(root.get("dataInicio"), dataInicio),
                builder.lessThanOrEqualTo(root.get("dataFim"), dataFim)
        );

        criteriaQuery.select(root).where(filtro);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
