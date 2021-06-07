package HibernateFetchTypes;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateMappingOneOne.Instructor;
import HibernateMappingOneOne.InstructorDetails;
import HibernateManytoone.Course;

public class ReadManyDemo {

	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session sess=factory.getCurrentSession(); 
		try
		{
			sess.beginTransaction();
			
			
			sess.getTransaction().commit();
			
		}
		finally
		{
			sess.close();
			factory.close();
		}
	}

}
