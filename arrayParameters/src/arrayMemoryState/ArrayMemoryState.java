package arrayMemoryState;

import java.util.Arrays;

public class ArrayMemoryState {

	public static void main(String[] args) {
		int [] x = {1,2,3,4};
		
		//System.out.println("Array X before testing method: " + Arrays.toString(x));
		int [] y = testing(x);
		//System.out.println("Array X after testing method: " + Arrays.toString(x));
	}
	
	public static int [] testing (int [] arrayOne) {
		int [] z = arrayOne;
		
		for (int i = 0; i < arrayOne.length; i++) {
			z[i] = (arrayOne[i] * 2);
		}
		
		//System.out.println("Array Z from testing method: " + Arrays.toString(z));
		//System.out.println("Array X (passed in as arrayOne parameter) during testing method: " + Arrays.toString(arrayOne));
		return z;
	}
}
