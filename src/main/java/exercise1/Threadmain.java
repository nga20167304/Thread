package exercise1;

public class Threadmain{
	public static void main(String[] argv) {
		Thread1 thread1=new Thread1();
		Thread2 thread2=new Thread2();
		thread1.start();
		thread2.start();
	}
}
