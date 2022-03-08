
import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileOutputDemoMain {
	public static void main(String[] args) throws FileNotFoundException{
		String fileName;
		String lastName; 
		String firstName;
		double salary, totalSalary=0; 
		int countOfEmployees;
		fileName = JOptionPane.showInputDialog("Enter the name of the file that holds employee information");
		countOfEmployees = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of employees in the file"));
		
		Scanner inFile = new Scanner(new FileReader("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\" + fileName + ".txt")); 
		PrintWriter outFile = new PrintWriter("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\" + fileName + "-out.txt");
		
		for (int i = 1; i <=countOfEmployees; i++) {
			lastName = inFile.next();
			firstName = inFile.next();
			salary = inFile.nextDouble();
			JOptionPane.showMessageDialog(null, String.format("Processing: %s %s", firstName, lastName), "Processing", JOptionPane.INFORMATION_MESSAGE);
			outFile.format("Employee count so far:\t%d\t%s\t%s\t%.2f\n", i, firstName, lastName, salary);
			totalSalary += salary;
		}		
		String formattedString = String.format("Number of employees processed: %d\nTotal Salary: %.2f", countOfEmployees, totalSalary);
		JOptionPane.showMessageDialog(null, formattedString, "Processing", JOptionPane.INFORMATION_MESSAGE);
		outFile.print(formattedString);
		outFile.flush();
		
		inFile.close();
		outFile.close();
	}

}
