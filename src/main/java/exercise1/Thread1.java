package exercise1;

import java.util.Random;

import exercise1.Lamp.Status;

public class Thread1 extends Thread{
	@Override
	public void run() {
		while(true) {
			Store store=Store.getInstance();
			Random rd=new Random();
			//Create field x to random quantity of listlamp
			int x;
			x=rd.nextInt(20);
			for(int i=0;i<x;i++) {
				Lamp lamp=new Lamp();
				//set lamp status random ( ON or OFF or REPAIR)
				lamp.setStatus(r.random());
				//store all Lamp to Store class
				store.storeLamp(lamp);
				System.out.println("Thread 1: add new lamp " + lamp.toString());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static final RandomEnum<Status> r=new RandomEnum<Status>(Status.class);
	
	//function to create random for status
	private static class RandomEnum<E extends Enum<Status>>{
		private static final Random RD=new Random();
		private final Status[] values;
		public RandomEnum(Class<Status> token) {
			values=token.getEnumConstants();
		}
		public Status random() {
			return values[RD.nextInt(values.length)];
		}
	}
}
