package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import exercise2.Lamp.Status;



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
	
	//function to remove lamp for thread 3
	public void removeTrash(List<Lamp> listTrashLamp,Store store) {
		for(int i=0;i<listTrashLamp.size();i++)
		{
			Lamp lamp = listTrashLamp.get(i);
			//Check lamp has status OFF
			if(lamp.getStatus()==Status.OFF )
			{
				Random rd=new Random();
				//x is random 0-1
				int x=rd.nextInt(2);
				//If x==1 change status to Repair and add to class Store
				if(x==1) {
					lamp.setStatus(Status.REPAIR);
					store.storeLamp(lamp);
					listTrashLamp.remove(lamp);
				}
				//if x==0 change remove lamp from Trash and not add to class Store
				else {
					listTrashLamp.remove(lamp);
				}
			}
		}
	}

}
