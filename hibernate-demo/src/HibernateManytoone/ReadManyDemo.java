package HibernateManytoone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateFetchTypes.Review;
import HibernateMappingOneOne.Instructor;
import HibernateMappingOneOne.InstructorDetails;

public class ReadManyDemo {

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
			sess.beginTransaction();
			//InstructorDetails detail=new InstructorDetails("earth","none");
			Instructor instructor=sess.get(Instructor.class,14);
			System.out.println("inst is "+instructor);
			List<Course> courses=instructor.getCourses();
			for(Course c:courses)
				System.out.println(c);
			
			
			
			
			
			
			sess.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}
	}

}
