package exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



//Class Trash store lamp has status off
public class Trash {
	List<Lamp> listTrashLamp=Collections.synchronizedList(new ArrayList<Lamp>());
	
	//private constructor
	private Trash() {}
		
	//Static inner class-inner classes are not loaded until they are referenced
	private static class TrashHolder{
		private static Trash trash=new Trash();
	}
		
	//global access point
	public static Trash getInstance() {
		return TrashHolder.trash;
	}
	
	//function to store lamp
	public void storeTrashLamp(Lamp lamp) {
		listTrashLamp.add(lamp);
	}
	
	//function to read listLamp
	public  void readTrashLamp() {
		for(Lamp lamp:listTrashLamp) {
			System.out.println("Lamp "+ lamp.getIndex() + " Status: "+lamp.getStatus());
		}
	}

}
