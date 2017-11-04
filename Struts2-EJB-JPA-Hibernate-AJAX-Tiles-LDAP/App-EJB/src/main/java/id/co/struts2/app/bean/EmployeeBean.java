package id.co.struts2.app.bean;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import id.co.struts2.app.entity.Employee;

@Stateless
public class EmployeeBean implements EmployeeRemote {

    @PersistenceContext(unitName = "TestPU")
    EntityManager em;

    @Override
    public boolean createEmployee(Employee e) {
        em.persist(e);
        return true;
    }

    @Override
    public void addEmployee(String name, String age) {
        Employee e = new Employee();
        e.setName(name);
        e.setAge(Integer.parseInt(age));
        em.persist(e);
    }

    @Override
    public Employee getEmployeeById(String id) {
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.id = :id");
        query.setParameter("id", Long.parseLong(id));
        Employee employee = (Employee) query.getSingleResult();
        return employee;
    }

    @Override
    public List<Employee> showEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = query.getResultList();
        return employees;
    }
    
    @Override
    public void updateEmployee(String id, String name, String age) {
        Query query = em.createQuery("UPDATE Employee e SET e.name = :name, e.age = :age WHERE e.id = :id");
        query.setParameter("id", Long.parseLong(id));
        query.setParameter("name", name);
        query.setParameter("age", Integer.parseInt(age));
        query.executeUpdate();
    }

    
    @Override
    public void deleteEmployee(String id) {
        Query query = em.createQuery("DELETE FROM Employee e WHERE e.id = :id");
        query.setParameter("id", Long.parseLong(id));
        query.executeUpdate();
    }
}
