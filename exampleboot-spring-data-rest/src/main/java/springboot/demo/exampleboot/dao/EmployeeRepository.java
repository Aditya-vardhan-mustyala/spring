package springboot.demo.exampleboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.exampleboot.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
}
