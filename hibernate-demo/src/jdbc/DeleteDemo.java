package jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		Session sess=factory.getCurrentSession();
		
		try {
			
			sess.beginTransaction();
			sess.createQuery("delete from Student where firstName = 'aditya'").executeUpdate();
			sess.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}
}
