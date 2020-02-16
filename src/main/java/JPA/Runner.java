package JPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");

        entityManagerFactory.close();
    }
}
