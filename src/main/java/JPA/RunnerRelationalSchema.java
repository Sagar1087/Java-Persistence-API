package JPA;

import JPA.Entity.Address;
import JPA.Entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerRelationalSchema {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setFirstName("firstUser");
        user.setLastName("lastname");

        Address address = new Address();
        address.setState("CO");
        address.setSteet("Golden");
        address.setZipcode(80521);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        user.setAddress(address);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();

    }
}
