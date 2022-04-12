package arrayParameters;

public class ArrayParameters {

	public static void main(String[] args) {
		int [] w = {10, 21, 40, 40};
		int [] x = {10, 20, 30, 40};
		int [] y = {10, 21, 40, 40};
		int [] z = x;
		
		if (isEqual(x, w)) {
			System.out.println("X and W are equal"); 
		} else {
			System.out.println("X and W are not equal");
		}
		
		if (isEqual(x, y)) {
			System.out.println("X and Y are equal"); 
		} else {
			System.out.println("X and Y are not equal");
		}
		
		if (isEqual(x, z)) {
			System.out.println("X and Z are equal"); 
		} else {
			System.out.println("X and Z are not equal");
		}
		
		if (isEqual(w, y)) {
			System.out.println("W and Y are equal"); 
		} else {
			System.out.println("W and Y are not equal");
		}
	}
	
	public static boolean isEqual (int [] arrayOne, int [] arrayTwo) {

		if (arrayOne.length != arrayTwo.length) {
			return false;
		}
		
		for (int i = 0; i < arrayOne.length; i++) {
			if (arrayOne[i] != arrayTwo[i]) {
				return false;
			}
		}
		return true;
	}
}
