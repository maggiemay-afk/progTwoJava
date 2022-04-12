package partiallyFilledArrays;

import java.util.Arrays;
import javax.swing.*;

public class AddArrays {
	
	public static void main (String[] args) {
		
		double [] a1 = {1,3,5,7,9};
		double [] a2 = {2,4,6,8,10}; 
		int numElm = a1.length;
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		
		double [] summationArray = addTwoArrays(a1, a2, numElm);
		
		System.out.println(Arrays.toString(summationArray));
	}
	
	public static double [] addTwoArrays (double [] arrayOne, double [] arrayTwo, int numElm) {
		double [] elementSumArray = new double[numElm];
		
		for (int i = 0; i < arrayOne.length; i++) {
			elementSumArray[i] = arrayOne[i] + arrayTwo[i];
		}
		return elementSumArray;
	}
}
