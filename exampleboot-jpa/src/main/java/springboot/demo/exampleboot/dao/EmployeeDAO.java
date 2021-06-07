package springboot.demo.exampleboot.dao;

import springboot.demo.exampleboot.entities.Employee;

import java.util.List;

public interface EmployeeDAO
{
    public List<Employee> getall();

    Employee getOne(int id);

    void save(Employee emp);

    void delete(int id);
}
