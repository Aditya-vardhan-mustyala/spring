package aopdemo.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO 
{
	public void method()
	{
		System.out.println("method from member dao");
	}

	public String Random()
	{
		try {
			TimeUnit.SECONDS.sleep(3);
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}
		return "This is an example method for around";
	}
}
