import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DbConfig {
    @Produces
    public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("courses_db")
                .createEntityManager();
    }
}
