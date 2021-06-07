package HibernateFetchTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateManytoone.Course;
import HibernateMappingOneOne.Instructor;
import HibernateMappingOneOne.InstructorDetails;

public class CreateManyReviewDemo {

	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		Session sess=factory.getCurrentSession(); 
		try
		{
			Course c1=new Course("java");
			Review r1=new Review("bad");
			Review r2=new Review("good");
			
			c1.add(r2);
			c1.add(r1);
			
			sess.beginTransaction();
			
			
			System.out.println("saving course and reviews");
			sess.save(c1);
			
			
			sess.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}
}
