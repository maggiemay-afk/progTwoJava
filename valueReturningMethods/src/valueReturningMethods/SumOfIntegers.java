package valueReturningMethods;

import javax.swing.JOptionPane;

public class SumOfIntegers {

	public static void main(String[] args) {

		int userNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a whole number: "));
		double userSum = findSum(userNum);
		JOptionPane.showMessageDialog(null, "The sum is: " + userSum, "Answer", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static double findSum (int num) {
		double sum = 0;
		for (int i = num; i > 0; i--) {
			sum += i;
		}
		return sum;
	}
}
