package arrayInitialization;
import java.util.Arrays;
import javax.swing.*;

public class ArrayInitialization {
	
	public static int totalEmployees;

	public static void main(String[] args) {
		totalEmployees = Integer.parseInt(
				JOptionPane.showInputDialog("Please enter the total number of employees: ")
		);
		
		Double [] empSalary = new Double [totalEmployees];
		String [] empClassification = new String [totalEmployees];
		
		for (int i = 0; i < empSalary.length; i ++) {
			empSalary[i] = Double.parseDouble(
					JOptionPane.showInputDialog("Please enter the current employees salary: ")
			);	
			
			empClassification[i] = JOptionPane.showInputDialog("Please enter the current employees classification: "
							+ "\n'E' = Executive\n'S' = Sales\n'H' = Human Resources\n'O' = Other");	
		}
		
		System.out.println("Total Employees: " + totalEmployees);
		System.out.println("Employee Salaries: " + Arrays.toString(empSalary));
		System.out.println("Employee Classifications: " + Arrays.toString(empClassification));
	}
	
	public static void arrayComparison() {
		int [] w = {10, 21, 40, 40};
		int [] x = {10, 20, 30, 40};
		int [] y = {10, 21, 40, 40};
		int [] z = x;
		
		System.out.println(w == x);
		
		
	}	
}
