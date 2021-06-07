package springboot.demo.exampleboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.demo.exampleboot.dao.EmployeeDAO;
import springboot.demo.exampleboot.entities.Employee;
import springboot.demo.exampleboot.service.EmployeeService;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController
{
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public String home()
    {
        return "Hello world at "+ LocalDateTime.now();
    }

    @GetMapping("/employees")
    public List<Employee> getall()
    {
        return employeeService.getall();
    }

    @GetMapping("/employees/{id}")
    public Employee getone(@PathVariable int id)
    {
        return employeeService.getOne(id);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee emp)
    {
        emp.setId(0);
        employeeService.save(emp);
        return emp;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee emp)
    {
        employeeService.save(emp);
        return emp;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteone(@PathVariable int id)
    {
        Employee emp=employeeService.getOne(id);
        if(emp==null)
            throw new RuntimeException("employee not found");
        employeeService.delete(id);
        return "employee with id "+id+" is deleted";
    }







}
