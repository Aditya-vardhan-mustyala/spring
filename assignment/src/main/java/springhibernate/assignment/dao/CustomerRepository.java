package springhibernate.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springhibernate.assignment.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String>{
}
