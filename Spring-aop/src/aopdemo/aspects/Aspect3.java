package aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class Aspect3 
{
	@Before("aopdemo.aspects.PointcutDeclerations.pointcut2()")
	public void advice2_1()
	{
		System.out.println("=====> ASPECT 3 ");
	}

	

}
