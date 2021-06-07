package aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDeclerations 
{
	@Pointcut("execution(* *(int,int))")
	public void point1() {}
	
	
	@Pointcut("execution(* *(..))")
	public void pointcut2() {}

}
