package exercise2;

public class Thread2 extends Thread{
	@Override
	public void run(){
		while(true) {
			Store store=Store.getInstance();
			Trash trash=Trash.getInstance();
			//Check and remove lamp has status off and repair
			store.removeLamp(store.listLamp,trash);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
