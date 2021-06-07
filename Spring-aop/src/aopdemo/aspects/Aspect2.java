package aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Aspect2 
{
	@Before("aopdemo.aspects.PointcutDeclerations.pointcut2()")
	public void advice2_1(JoinPoint jp)
	{
		System.out.println("=====> ASPECT 2 ");
		MethodSignature ms=(MethodSignature) jp.getSignature();
		System.out.println("signature is "+ms);
		
		Object[] args=jp.getArgs();
		System.out.println("arguments are");
		for(Object ob:args)
		{
			System.out.println(ob);
		}
	}

	

}
