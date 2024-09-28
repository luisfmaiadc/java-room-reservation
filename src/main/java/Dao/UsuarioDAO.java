package Dao;

import Model.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDAO {

    private EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuario = entityManager.merge(usuario);
        entityManager.remove(usuario);
    }

}
