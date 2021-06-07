package springboot.thymeleafdemo.service;

//import springboot.demo.exampleboot.entities.Employee;
import springboot.thymeleafdemo.entities.Employee;

import java.util.List;

public interface EmployeeService
{
    public List<Employee> getall();

    public Employee getOne(int id);

    public void save(Employee emp);

    public void delete(int id);

}
