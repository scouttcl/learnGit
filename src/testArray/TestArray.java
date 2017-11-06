package testArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		数组去重
		List<String> list = new ArrayList<String>();
		if(null != list.toString()){
			System.out.println("not null");
			if(list.toString().equals("")){
				System.out.println("empty string");
			}
			System.out.println("list to string:" + list.toString() + ".");
		}
//		method 1
		String[] arr = {"a","b","c","c","d","e","e","e","a"};
		eradicateDuplicatedData(arr);

//		method 2
		String[] arr2 = {"a","b","c","c","d","e","e","e","a"};
		eradicateDuplicatedData2(arr2);
		
//		数组扩容
		
		
	}
	
	public static void eradicateDuplicatedData(String[] arr){
		List<String> list = new ArrayList<String>();
		for(int i = 0;i < arr.length;i++){
			if(list.toString().indexOf(arr[i]) == -1){
				list.add(arr[i]);
			}
		}
		String[] arrResult = (String[])list.toArray(new String[list.size()]);
		System.out.println("new array:" + Arrays.toString(arrResult));
	}
	
	public static void eradicateDuplicatedData2(String[] arr){
		List<String> list = new ArrayList<String>();
		Arrays.sort(arr);
		list.add(arr[0]);
		for(int i = 1;i < arr.length;i++){
			if(!arr[i].equals(list.get(list.size() - 1))){
				list.add(arr[i]);
			}
		}
		String[] arrResult2 = (String[])list.toArray(new String[list.size()]);
		System.out.println("new array 2:" + Arrays.toString(arrResult2));
	}

}
