package demo1;

import java.util.LinkedList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		LinkedList<String> lList = new LinkedList<String>();
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("4");
		lList.offer("5");
		System.out.println("index 3 ele:" + lList.get(3));
		
		for(String ele:lList){
			System.out.println("traversal lList:" + ele);
		}
		
		List<String> subList = lList.subList(0, 4);
		System.out.println("subList:" + subList);
		System.out.println("lList before removing 1:" + lList);
		subList.remove(1);
		System.out.println("subList removing 1:" + subList);
		System.out.println("lList removing 1::" + lList);
	}
}
