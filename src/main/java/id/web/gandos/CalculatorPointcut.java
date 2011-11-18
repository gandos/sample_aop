package id.web.gandos;

import org.aspectj.lang.annotation.Pointcut; 

public class CalculatorPointcut {
	@Pointcut("within(ArithmeticCalculator+)")
	public void arithmeticOperation(){}
	
	@Pointcut("execution(* *.sub(..)) && target(target) && args(a,b)")
	public void pointcutParameter(Object target, double a, double b) {}
}