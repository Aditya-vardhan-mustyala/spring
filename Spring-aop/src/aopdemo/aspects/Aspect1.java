package aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class Aspect1 
{
	
	
	@Before("!aopdemo.aspects.PointcutDeclerations.point1()")
	public void beforeTarget()
	{
		System.out.println("=====> ASPECT 1");
	}

}
