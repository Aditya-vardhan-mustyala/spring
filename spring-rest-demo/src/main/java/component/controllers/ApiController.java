package component.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import component.entity.CustomErrorResponse;
import component.entity.CustomExceptionStudnotfound;
import component.entity.Student;

@RestController
@RequestMapping("/api")
public class ApiController 
{
	private List<Student> students;
	
	@PostConstruct
	public void	 load()
	{
		students=new ArrayList<>();
		
		students.add(new Student("adi","var"));
		students.add(new Student("rut","mad"));
		students.add(new Student("ram","mad"));
		
		
	}
	
	@GetMapping("/students")
	public List<Student> stud()
	{
			
		return students;
	}
	
	@GetMapping("/students/{stuid}")
	public Student studid(@PathVariable int stuid)
	{
		
		if(stuid >=students.size())
		{
			throw new CustomExceptionStudnotfound("student not found");
		}
			
		return students.get(stuid);
	}
	
	
}
