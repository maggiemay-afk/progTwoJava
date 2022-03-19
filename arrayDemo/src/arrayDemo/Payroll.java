package arrayDemo;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Payroll {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner inFile = new Scanner(new FileReader("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\employees.txt")); 
		
		String lastName, firstName;
		Double empSalary;
		int numEmployees = 0;
		
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			numEmployees ++;
		} 
		
		Double [] salary = new Double [numEmployees];
		inFile = new Scanner(new FileReader("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\employees.txt"));
		
		for (int i = 0; i < numEmployees ; i++) {
			lastName = inFile.next();
			firstName = inFile.next();
			empSalary = inFile.nextDouble();
			
			salary[i] = empSalary;
		}
		
		Double [] shallowSalary = salary;
		Double [] deepSalary = Arrays.copyOf(salary, salary.length);
		
		//System.out.println(numEmployees);
		System.out.println("Original Array: " + Arrays.toString(salary));
		System.out.println("Shallow Copy: " + Arrays.toString(shallowSalary));
		System.out.println("Deep Copy: " + Arrays.toString(deepSalary) + "\n");
		
		salary [0] = 0.0;
		
		System.out.println("Changed original array at index 0, effects shallow copy not deep copy\n");
		System.out.println("Original Array: " + Arrays.toString(salary));
		System.out.println("Shallow Copy: " + Arrays.toString(shallowSalary));
		System.out.println("Deep Copy: " + Arrays.toString(deepSalary));

		inFile.close();
	}
}
