package springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import springboot.demo.exampleboot.entities.Employee;
import springboot.thymeleafdemo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
}
