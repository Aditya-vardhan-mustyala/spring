package HibernateManytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateFetchTypes.Review;
import HibernateMappingOneOne.Instructor;
import HibernateMappingOneOne.InstructorDetails;

public class DeleteManyDemo {

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
			
			//delete course
			/*sess.beginTransaction();
			Course c1=sess.get(Course.class,7);
			System.out.println("deleteing course");
			
			sess.delete(c1);
			sess.getTransaction().commit();*/
			
			//deleteing instructor
			sess.beginTransaction();
			//Instructor inst=sess.get(Instructor.class,14);
			Course c1=sess.get(Course.class,21);
			//System.out.println("deleteing instructor "+inst);
			sess.delete(c1);
			sess.getTransaction().commit();
			
			
			
		}
		finally
		{
			factory.close();
		}

	}
}
