package HibernateMappingOneOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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
			//InstructorDetails detail=new InstructorDetails("earth","none");
			Instructor instructor=new Instructor("adi","var","sds");
			
			
			sess.beginTransaction();
			InstructorDetails detail=sess.get(InstructorDetails.class,2);
			//Creating many - one
			instructor.setInstructorDetails(detail);
			System.out.println("saving instructor");
			
			sess.save(instructor);
			sess.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}
