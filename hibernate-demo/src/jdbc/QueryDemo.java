package jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		Session sess=factory.getCurrentSession();
		
		try {
			sess.beginTransaction();
			List<Student> lis=sess.createQuery("from Student where firstName like 'th'").getResultList();			
		
			for(Student st: lis)
			{
				System.out.println(st);
			}
		}
		finally {
			factory.close();
		}
	}

}

