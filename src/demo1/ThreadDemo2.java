package demo1;

public class ThreadDemo2 extends Thread{

	private String name2;
	
	public ThreadDemo2(String name){
		super(name);
		this.name2 = name;
	}
	
	public synchronized void run(){
		for(int i = 0;i< 30;i++){
			System.out.println("Thread " + this.name2 + " " + Thread.currentThread().getName() + " : " + i);
		}
	}
	
	public static void main(String[] args) {
		Runnable demo2_0 = new ThreadDemo2("Bob");
		Thread demo2_1 = new Thread(demo2_0,"Go home");
		Thread demo2_2 = new Thread(demo2_0,"Back to station");
		demo2_1.start();
		demo2_2.start();
	}
}
