package id.web.gandos;

import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Calculator calc = ctx.getBean("calculator",Calculator.class);
		calc.add(1,1);
		calc.substract(4,1);
		
		Counter counter = (Counter) calc;
		System.out.println("counter: " +counter.getCount());
    }
}
