package Service;

import Config.JPAUtil;
import Dao.UsuarioDAO;
import Model.Usuario;

import javax.persistence.EntityManager;

public class UsuarioService {

    public void cadastrarUsuario(String nome, String email) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);

        try {
            Usuario usuario = new Usuario(nome, email);
            entityManager.getTransaction().begin();
            usuarioDAO.cadastrarUsuario(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void buscarUsuario(Integer id) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);

        Usuario usuario = usuarioDAO.buscarUsuario(id);
        if (usuario != null) {
            System.out.println(usuario.toString());
        } else {
            System.out.println("Este usuário não existe.");
        }
    }

    public boolean isUsuario(Integer id) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);

        Usuario usuario = usuarioDAO.buscarUsuario(id);
        return usuario != null;
    }

}
