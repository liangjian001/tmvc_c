package lock;

public class Task implements Runnable{

	@Override
	public void run() {
		//Status.selfIncrease();
		Status.selfDecrease();
	}

	
	public static void main(String[] args) throws Exception {  
		Task task = new Task();
		Thread t1 = new Thread(task,"A");
		Thread t2 = new Thread(task,"B");
		Thread t3 = new Thread(task,"C");
		Thread t4 = new Thread(task,"D");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
