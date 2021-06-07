package component.daos;

import java.util.List;

import hibernateEntities.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Object getCustomer(int id);

	public void deletecustomer(int id);

}
