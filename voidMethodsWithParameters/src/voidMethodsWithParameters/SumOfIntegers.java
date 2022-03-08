package voidMethodsWithParameters;
import javax.swing.*;

public class SumOfIntegers {
	
	public static void main(String[] args) {
		int userNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter any whole number: "));
		findAndDisplaySum(userNum);
	}
	
	public static void findAndDisplaySum (int num) {
		double sum = 0;
		for (int i = num; i > 0; i--) {
			sum += i;
		}
		displaySum(sum);
	}

	public static void displaySum (double userSum) {
		JOptionPane.showMessageDialog(null, "The sum is: " + userSum, "Answer", JOptionPane.INFORMATION_MESSAGE);
	}
}
