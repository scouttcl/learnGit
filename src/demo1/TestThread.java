package demo1;

public class TestThread {

//	singleton pattern
	private static final TestThread testObj = new TestThread();
	private static Inner testInnerObj = null;

//	private constructor
	private TestThread(){
	}
	
	public static TestThread getInstance(){
		return testObj;
	}
	
	public static synchronized Inner getInnerInstance(){
		if(testInnerObj == null){
			testInnerObj = testObj.new Inner();
		}
		return testInnerObj;
	}
	public void sayHello(){
		synchronized (this) {
			for(int i = 0;i < 10;i++){
				System.out.println(Thread.currentThread().getName() + ":Hello" + i);
			}
		}
	}
	
	public void sayGoodbye(){
		for(int i = 0;i < 10;i++){
			System.out.println(Thread.currentThread().getName() + ":Goodbye" + i);
		}
	}
	
	public void saySorry(Inner inner){
		synchronized(inner){
			inner.saySorry();
		}
	}
	public void sayOk(Inner inner){
		synchronized (inner) {
			inner.sayOk();
		}
	}
	
//	inner class
	class Inner{
		
		public void saySorry(){
			for(int i = 0;i < 20;i++){
				System.out.println(Thread.currentThread().getName() + ":Sorry" + i);
			}
		}
		public void sayOk(){
			for(int i = 0;i< 20;i++){
				System.out.println(Thread.currentThread().getName() + ":Ok" + i);
			}
		}
	}
}
