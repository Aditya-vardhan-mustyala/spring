package jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		Session sess=factory.getCurrentSession();
		
		try {
			
			Student obj=new Student("10th","name","sdsd");
			System.out.println("created student");
			
			sess.beginTransaction();
			sess.save(obj);
			System.out.println("saved student");
			sess.getTransaction().commit();
			
			System.out.println("completed");
			System.out.println(obj);
			
			Session sec=factory.getCurrentSession();
			
			sec.beginTransaction();
			Student stu=sec.get(Student.class,obj.getId());
				
			System.out.println("got "+stu);
			sec.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
