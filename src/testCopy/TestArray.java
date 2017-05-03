package testCopy;

import java.util.Arrays;

public class TestArray {

	public static void main(String[] args) {
		Object[] objArr = {1,2,3,33,4};
		Integer[] intArr = new Integer[5];
		try {
			System.arraycopy(objArr, 0, intArr, 0, 4);
			
		} catch (ArrayStoreException e) {
			System.out.println("copy error");
		}
		System.out.println("intArr:" + Arrays.toString(intArr));
		
		Integer[] intArr2 = null;
		try {
			intArr2 = (Integer[]) Arrays.copyOf(objArr, objArr.length);
			System.out.println(Arrays.toString(intArr2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
