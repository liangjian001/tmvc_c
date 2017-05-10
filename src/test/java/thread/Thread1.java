package thread;

public class Thread1 extends Thread{
	private String name;
	public Thread1(String str){
		this.name = str;
	}

	public void run(){
		for (int i=0;i<5;i++){
			System.out.println(name+"运行:"+i);
			try{
				sleep((int) Math.random() * 10);
			}catch (InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
}
