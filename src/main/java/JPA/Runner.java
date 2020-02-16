package JPA;

import JPA.Entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//INSERT Query


/*        Employee emp = new Employee();
        emp.setFirstName("Sagar");
        emp.setLastName("Bhatt");
        emp.setEmail("Sambhu@gmail.com");

        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();
*/


//Find By ID Query
/*
        Employee emp = entityManager.find(Employee.class, "20e008c4-5009-431e-9038-bc9df44414af");
        System.out.println(emp);
*/

//Update specific column
/*
        Employee emp1 = entityManager.find(Employee.class, "20e008c4-5009-431e-9038-bc9df44414af");
        emp.setFirstName("Ram");

        entityManager.getTransaction().begin();
        entityManager.merge(emp1);
        entityManager.getTransaction().commit();
*/

//DELETE
/*        Employee emp2 = entityManager.find(Employee.class, "9287700e-dee7-42c3-afbb-b4c7c3288ae5");

        entityManager.getTransaction().begin();
        entityManager.remove(emp2);
        entityManager.getTransaction().commit();*/

//Customize query => FindAll -- Specific business logic. provide Typed query.

        //TypedQuery<Employee> query = entityManager.createQuery("select emp from Employee emp order by emp.firstName DESC", Employee.class);

        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.FindAll", Employee.class);
        List<Employee> result = query.getResultList();

        for(Employee emp: result) {
            System.out.println(emp + "\n");
        }

//Find by email -- Query defined at class level @Employee class.

        TypedQuery<Employee> queryByEmail = entityManager.createNamedQuery("Employee.FindByEmail",Employee.class);
        queryByEmail.setParameter("paramEmail","Sambhu@gmail.com");

        List<Employee> resultEmail = queryByEmail.getResultList();

        for (Employee emp : resultEmail) {
            System.out.println("Result ----- " + emp);
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
