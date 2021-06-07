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

public class ReadStudentCourse 
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
			sess.beginTransaction();
			Student stu=sess.get(Student.class,22);
			System.out.println("student is "+stu);
			List<Course> courses=stu.getCourses();
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
