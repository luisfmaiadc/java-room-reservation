package Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import io.github.cdimascio.dotenv.Dotenv;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY;

    static {
        Dotenv dotenv = Dotenv.load();

        Map<String, String> configOverrides = new HashMap<>();
        configOverrides.put("javax.persistence.jdbc.url", dotenv.get("DB_URL"));
        configOverrides.put("javax.persistence.jdbc.user", dotenv.get("DB_USER"));
        configOverrides.put("javax.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));
        configOverrides.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

        FACTORY = Persistence.createEntityManagerFactory("reserva", configOverrides);
    }

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
