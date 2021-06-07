package HibernateMappingOneOne;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteBi {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetails.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			/*int id = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
			System.out.println("Deleting Instuctor Details: "+tempInstructorDetail);
			System.out.println("Deleting instructor: "+tempInstructorDetail.getInstructor());
			session.delete(tempInstructorDetail);*/
			//TO DELETE INSTRUCTOR DETAIL WITHOUT DELETING INSTRUCTOR
			//FIRST REMOVE THE DIRECTION LINK FROM INSTRUCTOR TO INSTRUCTOR DETAIL and DELETE
			//THE INSTRUCTOR DETAIL removes all links
			int id = 3;
			InstructorDetails tempInstructorDetail = session.get(InstructorDetails.class, id);
			//tempInstructorDetail.getInstructor().setInstructorDetails(null);
			//session.getTransaction().commit();
			//session = factory.getCurrentSession();
			//session.beginTransaction();
			//session.refresh(tempInstructorDetail);
			//Instructor inst=tempInstructorDetail.getInstructor();
			//System.out.println(inst);
			session.delete(tempInstructorDetail);
			session.getTransaction().commit();
			System.out.println("success");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

