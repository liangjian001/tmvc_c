package lock;

public class Status {
	private static int num = 0;
	public synchronized static void selfIncrease(){
		num++;
		System.out.println(Thread.currentThread().getName()+" : "+num);
	}
	
	private static Object lock = new Object();
	public static void selfDecrease(){
		synchronized (lock) {
			num--;
			System.out.println(Thread.currentThread().getName()+" : "+num);
		}
	}
}
