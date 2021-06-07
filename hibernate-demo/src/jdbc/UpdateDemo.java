package jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		Session sess=factory.getCurrentSession();
		
		try {
			Student obj=new Student("14th","name","sdsd");
			System.out.println("created student");
			sess.beginTransaction();
			sess.save(obj);
			System.out.println("saved student");
			sess.getTransaction().commit();
			System.out.println("completed");
			System.out.println(obj);
			Session sec=factory.getCurrentSession();
			
			sec.beginTransaction();
			Student stu=sec.get(Student.class,12);
			stu.setEmail("newmail@gmail");
			
			System.out.println("changed obj is"+stu);
			sec.getTransaction().commit();
			System.out.println("updated");
			
			
			Session ses=factory.getCurrentSession();
			ses.beginTransaction();
			ses.createQuery("update Student set email='sdsddd'").executeUpdate();
			ses.getTransaction().commit();
			System.out.println("query updated");
			
			
		}
		finally {
			factory.close();
		}
	}
}
