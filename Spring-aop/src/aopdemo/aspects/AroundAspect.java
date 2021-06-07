package aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class AroundAspect 
{
	@Around("aopdemo.aspects.PointcutDeclerations.pointcut2()")
	public Object time(ProceedingJoinPoint handle) throws Throwable
	{
		System.out.println("=====> Aspect 4");
		long begin=System.currentTimeMillis();
		Object result;
		try {
		 result=handle.proceed();
		}
		catch(Exception e)
		{System.out.println("Exception handled by aspect");
		result="done";
		}
		long end=System.currentTimeMillis();
		
		System.out.println("\n=====> Execution time for "+handle.getSignature()+"is "+((end-begin)/1000.0)+"seconds\n");
		
		return result;
	
	}


}
