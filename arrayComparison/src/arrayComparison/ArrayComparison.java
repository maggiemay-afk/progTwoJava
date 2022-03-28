package arrayComparison;
import java.util.Arrays;

public class ArrayComparison {
	
	public static void main(String[] args) {

		int [] w = {10, 21, 40, 40};
		int [] x = {10, 20, 30, 40};
		int [] y = {10, 21, 40, 40};
		int [] z = x;
		
		System.out.println("Shallow array comparison check:");
		System.out.println("Are X and W equal? " + (x == w));
		System.out.println("Are X and Y equal? " + (x == y));
		System.out.println("Are X and Z equal? " + (x == z));
		System.out.println("Are W and Y equal? " + (w == y));
		
		System.out.println("\nDeep array comparison function:");
		System.out.println("Are X and W equal? " + CompareLoop(x, w));
		System.out.println("Are X and Y equal? " + CompareLoop(x, y));
		System.out.println("Are X and Z equal? " + CompareLoop(x, z));
		System.out.println("Are W and Y equal? " + CompareLoop(w, y));
		
		//built in array function
		System.out.println("\nArray comparison function (Deep):");
		System.out.println("Are X and W equal? " + Arrays.equals(x, w));
		System.out.println("Are X and Y equal? " + Arrays.equals(x, y));
		System.out.println("Are X and Z equal? " + Arrays.equals(x, z));
		System.out.println("Are W and Y equal? " + Arrays.equals(w, y));
	}
	
	public static boolean CompareLoop(int[] arrayOne, int[] arrayTwo) {
		boolean isEqual = (arrayOne.length == arrayTwo.length);
		
		for (int i = 0; (i < arrayOne.length) && isEqual; i++) {
			isEqual = (arrayOne[i] == arrayTwo[i]);
		}
		return isEqual;
	}
}
