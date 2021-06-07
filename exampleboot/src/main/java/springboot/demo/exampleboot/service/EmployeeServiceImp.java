package springboot.demo.exampleboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.demo.exampleboot.dao.EmployeeDAO;
import springboot.demo.exampleboot.entities.Employee;


import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService
{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getall()
    {
        return employeeDAO.getall();
    }

    @Override
    @Transactional
    public Employee getOne(int id)
    {
        return employeeDAO.getOne(id);
    }

    @Override
    @Transactional
    public void save(Employee emp)
    {
        employeeDAO.save(emp);
    }

    @Override
    @Transactional
    public void delete(int id)
    {
        employeeDAO.delete(id);
    }
}
