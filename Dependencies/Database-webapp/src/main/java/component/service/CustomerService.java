package component.service;

import java.util.List;

import hibernateEntities.Customer;

public interface CustomerService
{
	public List<Customer> getCustomers();

	public void savecustomer(Customer customer);

	public Object getCustomer(int id);

	public void deletecustomer(int id);

}
