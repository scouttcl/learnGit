package practice;

public class Prac1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		times table, implement
		int intArr[][] = new int[9][9];
		for(int i = 1;i <= 9;i++){
			for(int j = 1;j <= i;j++){
				intArr[i - 1][j - 1] = i * j;
				System.out.print(j + "*" + i + "=" + intArr[i - 1][j - 1] + " ");
			}
			System.out.println();
		}
		
	}
}
