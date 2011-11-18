package id.web.gandos;

public class CounterImpl implements Counter {
	private int counter;
	
	public void increase() {
		counter++;
	}
	
	public int getCount() {
		return counter;
	}
}