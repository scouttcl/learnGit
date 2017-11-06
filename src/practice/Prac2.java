package practice;

import java.util.Arrays;

public class Prac2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "你好，欢迎来到Java世界";
		int strLen = str.length();
		System.out.println("str lentth: " + strLen);
		char[] charStr = str.toCharArray();
		System.out.println("charStr: " + Arrays.toString(charStr));
		if(str.indexOf("J") != -1){
			System.out.print("value: " + charStr[str.indexOf("J")] + ",");
			System.out.println("index: " + str.indexOf("J"));
			System.out.println(str.substring(str.indexOf("J"), str.indexOf("J") + 4));
		}
	}

}
