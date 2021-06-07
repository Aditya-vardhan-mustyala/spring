package component.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect
{
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* component.spring_controllers.*.*(..))")
	private void controllerPackage() {}
	
	@Pointcut("execution(* component.service.*.*(..))")
	private void servicePackage() {}
	
	@Pointcut("execution(* component.daos.*.*(..))")
	private void daoPackage() {}
	
	
	@Pointcut("controllerPackage() || servicePackage() ||daoPackage() ")
	private void forMVC() {}
	
	@Before("forMVC()")
	public void before(JoinPoint jp)
	{
		System.out.println("==> in @Before for method "+jp.getSignature());
		
		Object[] arg=jp.getArgs();
		for(Object ob:arg)
		{
			System.out.println("arguements for method are "+ob);
		}
		
	}
	
	@AfterReturning(pointcut="forMVC()",returning="result")
	public void after(JoinPoint jp,Object result)
	{
		System.out.println("==> in @After from method "+jp.getSignature().toShortString());
		
		System.out.println("the data being returned is  "+result);
	}

}
