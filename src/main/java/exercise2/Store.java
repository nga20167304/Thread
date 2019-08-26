package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exercise2.Lamp.Status;

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
	
	//function to remove lamp has status off and repair
	public void removeLamp(List<Lamp> listLamp,Trash trash) {
		for(int i=0;i<listLamp.size();i++) {
			Lamp lamp = listLamp.get(i);
			if(lamp.getStatus()==Status.OFF || lamp.getStatus()==Status.REPAIR)
			{
				trash.listTrashLamp.add(lamp);
				listLamp.remove(lamp);
				System.out.println(String.format("Thread 2: remove lamp from Store %s"
						, lamp.toString()));
			}
		}
	}
	
	//function to check lamp has status repair remove Trash and add to Store
	public void addRepairLamp(List<Lamp> listTrashLamp,Store store ) {
		for(int i=0;i<listTrashLamp.size();i++) {
			Lamp lamp=listTrashLamp.get(i);
			if(lamp.getStatus()==Status.REPAIR)
			{
				store.listLamp.add(lamp);
				System.out.println(String.format("Thread 3: add lamp to Store %s"
						, lamp.toString()));
				listTrashLamp.remove(lamp);
				System.out.println(String.format("Thread 3: remove lamp has status Repair from Trash %s"
						,lamp.toString()));
			}
		}
	}
}
