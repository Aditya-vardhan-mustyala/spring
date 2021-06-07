package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO 
{
	public void targetMethod1(int a ,int b)
	{
		System.out.println("This is target code");
	}
	
	public void targetMethod2() throws Exception
	{
		System.out.println("This is target 2 throwing exception");
		throw new RuntimeException();
	}


}
