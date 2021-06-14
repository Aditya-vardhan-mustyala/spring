package springhibernate.assignment.service.serviceInterfaces;

import springhibernate.assignment.entities.Customer;

public interface CustomerService {
    Customer findById(String username);

    void save(Customer customer);
}
