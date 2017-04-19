package demo1;

public class TestASC {

	public static void main(String[] args) {
		String number = "123456";
		String numberTest = "02304";
		numberToLowerCase(number);
		System.out.println("\n~~~~~~");
		numberToUpperCase(number);
		System.out.println("\n~~~~~~");
		boolean resultFlag = isNumeric(numberTest);
		System.out.println("isNumeric: " + resultFlag);
	}
	
	public static void numberToLowerCase(String input){
		byte[] inputArr = input.getBytes();
		for(byte ele:inputArr){
			System.out.print((char)(ele + 48));
		}
	}
	
	public static void numberToUpperCase(String input){
		byte[] inputArr = input.getBytes();
		for(byte ele:inputArr){
			System.out.print((char)(ele + 16));
		}
	}
	
	public static boolean isNumeric(String input){
		byte[] inputArr = input.getBytes();
		for(byte ele:inputArr){
			if(ele > 57 ||  ele < 48){
				return false;
			}
		}
		return true;
	}
}
