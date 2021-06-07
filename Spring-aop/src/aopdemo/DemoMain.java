package aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MemberDAO;

public class DemoMain {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext  context =new AnnotationConfigApplicationContext(ConfigClass.class);
		
		AccountDAO acc=context.getBean("accountDAO",AccountDAO.class);
		MemberDAO mem=context.getBean("memberDAO",MemberDAO.class);
		
		acc.targetMethod1(1,3);
		System.out.println("\n2nd tym");
		try {
		acc.targetMethod2();
		}catch(Exception e)
		{System.out.println(e);}
		System.out.println("\n\n");
		mem.method();
		
		System.out.println("\n");
		System.out.println(mem.Random());
		context.close();
		

	}

}
