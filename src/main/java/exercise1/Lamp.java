package exercise1;

import java.util.concurrent.atomic.AtomicInteger;

//Class Lamp has field index and status
public class Lamp {
	public enum Status {ON,OFF}
	
	//Creates a new AtomicInteger with the given initial value 
	private static final AtomicInteger count = new AtomicInteger(0);
	private final int index;
	private Status status;
	
	//Constructor of Lamp with index auto increment
	public Lamp(){
	    index = count.incrementAndGet(); 
	}
	
	public int getIndex() {
		return index;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	//Print index and status of Lamp
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Index= %d , Status= %s ", getIndex(), getStatus());
	}
}
