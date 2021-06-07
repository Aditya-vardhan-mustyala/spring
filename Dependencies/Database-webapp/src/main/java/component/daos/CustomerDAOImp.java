package component.daos;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import hibernateEntities.Customer;


@Repository
public class CustomerDAOImp implements CustomerDAO 
{

	@Autowired
	private SessionFactory factory;
	
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() 
	{
		Session sess=factory.getCurrentSession();
		Query<Customer> query=sess.createQuery("from Customer order by firstName",Customer.class);
		List<Customer> customers=query.getResultList();
		
		return customers;
		//return sess.createQuery("from Customer").getResultList();
		
		
	}


	@Override
	public void saveCustomer(Customer customer) 
	{
		Session sess=factory.getCurrentSession();
		
		sess.saveOrUpdate(customer);
			
		
	}


	@Override
	public Object getCustomer(int id) 
	{
		Session sess=factory.getCurrentSession();
		
		return sess.get(Customer.class,id);
	}


	@Override
	public void deletecustomer(int id) 
	{
		Session sess=factory.getCurrentSession();
		sess.createQuery("delete from Customer where id="+id).executeUpdate();
		// TODO Auto-generated method stub
		
	}

}
