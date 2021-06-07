package springboot.demo.exampleboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import springboot.demo.exampleboot.dao.EmployeeDAO;
import springboot.demo.exampleboot.dao.EmployeeRepository;
import springboot.demo.exampleboot.entities.Employee;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService
{
    @Autowired
    //@Qualifier("employeeDAOImp")
    private EmployeeRepository employeeDAO;

    @Override

    public List<Employee> getall()
    {
        return employeeDAO.findAll();
    }

    @Override
    //@Transactional
    public Employee getOne(int id)
    {
        Optional<Employee> res=employeeDAO.findById(id);
        if(res.isPresent())
            return res.get();
        else
            throw new RuntimeException("employee not found");
    }

    @Override
   // @Transactional
    public void save(Employee emp)
    {
        employeeDAO.save(emp);
    }

    @Override
    //@Transactional
    public void delete(int id)
    {
        employeeDAO.deleteById(id);
    }
}
