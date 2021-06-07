package HibernateManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateFetchTypes.Review;
import HibernateManytoone.Course;
import HibernateMappingOneOne.Instructor;
import HibernateMappingOneOne.InstructorDetails;
import jdbc.Student;

public class CreateStudentandCourse 
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
			
			Course c1=new Course("c1");
			Course c2=new Course("c2");
			Course c3=new Course("c3");
			Student s1=new Student("s1","b","c");
			Student s2=new Student("s2","b","c");
			sess.beginTransaction();
			s1.addcourse(c1);
			s1.addcourse(c2);
			
			c3.addStudent(s2);
			
			System.out.println("saving all");
			
			sess.save(c1);
			sess.save(c2);
			sess.save(c3);
			sess.save(s1);
			sess.save(s2);
			sess.getTransaction().commit();
			System.out.println("done");
			
		}
		finally
		{
			factory.close();
		}

	}

}
