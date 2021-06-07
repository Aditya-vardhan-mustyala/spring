package component.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import component.daos.CustomerDAO;
import hibernateEntities.Customer;

@Service
public class CustomerServiceImp implements CustomerService 
{
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() 
	{
		return customerDAO.getCustomers();
		
	}

	@Override
	@Transactional
	public void savecustomer(Customer customer) 
	{
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Object getCustomer(int id) 
	{
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deletecustomer(int id) 
	{

		customerDAO.deletecustomer(id);
		// TODO Auto-generated method stub
		
	}

}
