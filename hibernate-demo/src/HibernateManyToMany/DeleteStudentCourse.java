package HibernateManyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateFetchTypes.Review;
import HibernateManytoone.Course;
import HibernateMappingOneOne.Instructor;
import HibernateMappingOneOne.InstructorDetails;
import jdbc.Student;

public class DeleteStudentCourse 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		Session sess=factory.getCurrentSession(); 
		try
		{
			/*sess.beginTransaction();
			Course c1=sess.get(Course.class,7);
			System.out.println("deleteing course");
			
			sess.delete(c1);
			sess.getTransaction().commit();*/
			
			//deleteing instructor
			sess.beginTransaction();
			//Instructor inst=sess.get(Instructor.class,14);
			Student s1=sess.get(Student.class,22);
			//System.out.println("deleteing instructor "+inst);
			sess.delete(s1);
			sess.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
