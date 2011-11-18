package id.web.gandos;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
import org.aspectj.lang.JoinPoint; 
import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.Before; 
import org.aspectj.lang.annotation.After; 
import org.aspectj.lang.annotation.AfterReturning; 
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

@Aspect //aspek dari cross-cutting concern logging
public class LoggerAspect {
	private Log log = LogFactory.getLog(this.getClass());
	
	@Before("execution(double CalculatorImpl.add(double,double))")
	public void logBeforeAddMethod() {
		log.info("hola mas bro, numpang mejeng sebelum tambah :P");
	}
	
	@After("execution(* *.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("telah selamat sampai tujuan dengan utuh setelah method: "+
				  joinPoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut="execution(* CalculatorImpl.*(..))",
					returning="result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		log.info("hasil dari method: "+joinPoint.getSignature().getName() +
				 "=" +result);
	}
	
	@AfterThrowing(pointcut="CalculatorPointcut.arithmeticOperation()",
					throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
	}
	
	@Before("CalculatorPointcut.pointcutParameter(target,a,b)")
	public void aroundInvoke(Object target, double a, double b) {
	}
}