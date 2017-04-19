package demo1;

import demo1.TestThread.Inner;

public class TestThreadCaseSum implements Runnable{

	public static void main(String[] args) {
		TestThreadCaseSum ttcm = new TestThreadCaseSum();
		Thread t1 = new Thread(ttcm,"T1");
		Thread t2 = new Thread(ttcm,"T2");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		TestThread testObj = TestThread.getInstance();
//		synchronized method
//		testObj.sayHello();
//		unsynchronized method
//		testObj.sayGoodbye();
		
//		get Inner object of TestThread
		Inner innerObj = TestThread.getInnerInstance();
		testObj.sayOk(innerObj);
		testObj.saySorry(innerObj);
	}
}
