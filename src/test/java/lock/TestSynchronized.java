package lock;

//类锁的修饰（静态）方法和代码块
public class TestSynchronized {
	//代码块的方式
	public void test1() throws InterruptedException{
		synchronized(TestSynchronized.class){
			int i=5;
			while (i-- > 0){
				System.out.println(Thread.currentThread().getName()+" : "+i);
				Thread.sleep(500);
			}
		}
	}
	
	//修饰符的方式
	public synchronized static void test2() throws InterruptedException{
		int i = 5;
		while (i-- > 0){
			System.out.println(Thread.currentThread().getName()+" : "+i);
			Thread.sleep(500);
		}
	}
	
	
	private static int num = 5;
	public static void add(){
		synchronized(TestSynchronized.class){
			num++;
			System.out.println(Thread.currentThread().getName()+" : "+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void sub(){
		synchronized(TestSynchronized.class){
			num--;
			System.out.println(Thread.currentThread().getName()+" : "+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//main方法
	public static void main(String[] args){
		/*
		final TestSynchronized test = new TestSynchronized();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					test.test1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}},"A");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					TestSynchronized.test2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}},"B");
		t1.start();
		t2.start();
		*/
		
		/*
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run() {
				TestSynchronized.add();
			}
		},"C");
		Thread t4 = new Thread(new Runnable(){
			@Override
			public void run() {
				TestSynchronized.sub();
			}},"D");
		t3.start();
		t4.start();
		*/
		
		for (int i=0;i<3;i++){
			Thread ta = new Thread(new Runnable(){
				@Override
				public void run() {
					TestSynchronized.add();
				}
			},"E");
			
			Thread tb = new Thread(new Runnable(){
				@Override
				public void run() {
					TestSynchronized.sub();
				}
			},"F");
			ta.start();
			tb.start();
		}
	}
}
