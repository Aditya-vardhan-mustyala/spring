package springboot.demo.exampleboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springboot.demo.exampleboot.entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpJPA implements EmployeeDAO
{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getall()
    {
        return entityManager.createQuery("from Employee").getResultList();
    }

    @Override
    public Employee getOne(int id)
    {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void save(Employee emp)
    {
        Employee dbemp=entityManager.merge(emp);
        emp.setId(dbemp.getId());
    }

    @Override
    public void delete(int id)
    {
        entityManager.createQuery("delete from Employee where id="+id).executeUpdate();
    }
}
