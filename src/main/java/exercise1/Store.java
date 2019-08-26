package exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exercise1.Lamp.Status;

//Class Store can store all lamp created
public class Store {
	//Create listLamp is synchronized list 
	List<Lamp> listLamp=Collections.synchronizedList(new ArrayList<Lamp>());
	
	//private constructor
	private Store() {}
	
	//Static inner class-inner classes are not loaded until they are referenced
	private static class StoreHolder{
		private static Store store=new Store();
	}
	
	//global access point
	public static Store getInstance() {
		return StoreHolder.store;
	}
	//function to store lamp
	public void storeLamp(Lamp lamp) {
		listLamp.add(lamp);
	}
	
	//function to read listLamp
	public  void readLamp() {
		for(Lamp lamp:listLamp) {
			System.out.println("Lamp "+ lamp.getIndex() + " Status: "+lamp.getStatus());
		}
	}
	
	//function to remove lamp has status off
	public void removeLamp(List<Lamp> listLamp,Trash trash) {
		for(int i=0;i<listLamp.size();i++) {
			Lamp lamp = listLamp.get(i);
			if(lamp.getStatus()==Status.OFF)
			{
				trash.listTrashLamp.add(lamp);
				listLamp.remove(lamp);
				System.out.println(String.format("Thread 2: remove lamp from Store %s"
						, lamp.toString()));
			}
		}
	}
}
