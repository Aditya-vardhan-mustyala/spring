package springboot.demo.exampleboot.dao;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springboot.demo.exampleboot.entities.Employee;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO
{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Employee> getall()
    {
        Session sess=entityManager.unwrap(Session.class);

       return  sess.createQuery("from Employee").getResultList();
    }

    @Override
    public Employee getOne(int id)
    {
        Session sess=entityManager.unwrap(Session.class);
        return sess.get(Employee.class,id);
    }

    @Override
    public void save(Employee emp)
    {
        Session sess=entityManager.unwrap(Session.class);
        sess.saveOrUpdate(emp);
    }

    @Override
    public void delete(int id)
    {
        Session sess=entityManager.unwrap(Session.class);
        sess.createQuery("delete from Employee where id="+id).executeUpdate();

    }
}
