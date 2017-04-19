package demo1;

import java.util.HashMap;
import java.util.Hashtable;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String abc = "125"; 
		String ab = new String("125");
		if(abc.equals(ab)){
			System.out.printf("value same");
		}
		Hashtable<String,String> htbl = new Hashtable<String,String>();
		htbl.put("a", "aa");	//if key or value is null, leads to nullPointer Exception
		htbl.get("a");
		HashMap hm = new HashMap();
		hm.put(null, null);
	}
}
