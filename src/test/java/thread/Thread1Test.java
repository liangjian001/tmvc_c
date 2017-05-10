package thread;

public class Thread1Test {
	public static void main(String[] args){
		Thread1 thd1 = new Thread1("A");
		Thread1 thd2 = new Thread1("B");
		thd1.start();
		thd2.start();
	}
}
