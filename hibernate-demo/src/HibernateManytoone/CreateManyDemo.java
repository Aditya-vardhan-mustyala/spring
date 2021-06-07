package HibernateManytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateFetchTypes.Review;
import HibernateMappingOneOne.Instructor;
import HibernateMappingOneOne.InstructorDetails;

public class CreateManyDemo {

	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)								.buildSessionFactory();
		Session sess=factory.getCurrentSession(); 
		try
		{
			//InstructorDetails detail=new InstructorDetails("earth","none");
			Instructor instructor=new Instructor("aditya","vardhan","dontcare");
			//nstructorDetails detail=new InstructorDetails("hyd","sleeeping");
			//instructor.setInstructorDetails(detail);
			Course c1=new Course("spring");
			c1.setInstructor(instructor);
			Course c2=new Course("java");
			c2.setInstructor(instructor);
			//Course c3=new Course("db");
			//c3.setInstructor(instructor);
			
			sess.beginTransaction();
			
			
			System.out.println("saving courses");
			
			sess.save(c1);
			sess.save(c2);
			//sess.save(c3);
			sess.save(instructor);
			sess.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}
}
