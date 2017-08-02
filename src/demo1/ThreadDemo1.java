package demo1;

public class ThreadDemo1 implements Runnable{

	private String name;
	public ThreadDemo1(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0;i < 30;i++){
			System.out.println("ThreadDemo1 obj:" + this.getName() + i);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		ThreadDemo1 demo1 = new ThreadDemo1("AKG-");
		Thread thread1 = new Thread(demo1);
		ThreadDemo1 demo2 = new ThreadDemo1("Sony-");
		Thread thread2 = new Thread(demo2);
		
		thread1.start();
		thread2.start();
	}
}
