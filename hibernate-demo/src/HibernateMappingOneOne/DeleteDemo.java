package HibernateMappingOneOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		Session sess=factory.getCurrentSession(); 
		try
		{
			sess.beginTransaction();
			Instructor instructor=sess.get(Instructor.class,3);
			System.out.println("instructor is"+instructor);
			
			sess.delete(instructor);
			System.out.println("dleeted");
			sess.getTransaction().commit();
			System.out.println("success");
			
		}
		finally
		{
			factory.close();
		}

	}

}
