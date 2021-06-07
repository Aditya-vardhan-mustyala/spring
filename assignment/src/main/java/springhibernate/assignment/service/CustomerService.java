package springhibernate.assignment.service;

import springhibernate.assignment.entities.Customer;

public interface CustomerService {
    Customer findById(String username);

    void save(Customer customer);
}
