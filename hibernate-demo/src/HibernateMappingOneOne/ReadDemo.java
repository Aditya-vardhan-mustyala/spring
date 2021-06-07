package HibernateMappingOneOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDemo {
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
			
			InstructorDetails details=sess.get(InstructorDetails.class,2);
			System.out.println("instructordetails is"+details);
			
			Instructor inst=details.getInstructor();
			System.out.println("retlated instrcutoer is "+inst);
			sess.getTransaction().commit();
			System.out.println("success");
			
		}
		finally
		{
			factory.close();
		}

	}

}
