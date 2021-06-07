package springhibernate.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhibernate.assignment.dao.CustomerRepository;
import springhibernate.assignment.entities.Customer;

import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService
{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(String username)
    {
        Optional<Customer> res= customerRepository.findById(username);
        if(res.isPresent())
            return res.get();
        else
            throw new RuntimeException("employee not found");

    }

    @Override
    public void save(Customer customer)
    {
        customerRepository.save(customer);
    }
}
