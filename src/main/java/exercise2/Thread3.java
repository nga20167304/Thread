package exercise2;



public class Thread3 extends Thread{
	@Override
	public void run() {
		while(true) {
			Store store=Store.getInstance();
			Trash trash=Trash.getInstance();
			//If lamp has status repair remove Trash and add to Store
			store.addRepairLamp(trash.listTrashLamp,store);
			
			
			//Lamp has status OFF if x==0 remove Trash and not add to Store
			//if x==1 change status to repair and add to Store
			trash.removeTrash(trash.listTrashLamp, store);		
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
