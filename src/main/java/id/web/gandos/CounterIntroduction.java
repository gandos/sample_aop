package id.web.gandos;

import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.After; 
import org.aspectj.lang.annotation.DeclareParents; 

@Aspect
public class CounterIntroduction {	
	@DeclareParents(
		value="id.web.gandos.CalculatorImpl",
		defaultImpl=CounterImpl.class)
	public Counter counter;
	
	@After("execution(* CalculatorImpl.*(..))  && this(counter)")
	public void increaseCounter(Counter counter) {
		counter.increase();
	}
}