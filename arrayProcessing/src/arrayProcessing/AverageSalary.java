package arrayProcessing;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class AverageSalary {
	
	public static String lastName;
	public static String firstName;
	public static double yearlySalary;
	public static double avgSalary;
	public static int numOfEmployees;

	public static void main(String[] args) throws FileNotFoundException{
		Scanner inFile = new Scanner(new FileReader("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\employees.txt"));
		
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			numOfEmployees ++;
		}
		
		Double [] salary = new Double [numOfEmployees];
		inFile = new Scanner(new FileReader("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\employees.txt"));
		
		for (int i = 0; i < numOfEmployees ; i++) {
			lastName = inFile.next();
			firstName = inFile.next();
			yearlySalary = inFile.nextDouble();
			
			salary[i] = yearlySalary;
		}
		
		double currentMax = salary[0];
		double currentMin = salary[0];
		double sum = 0;
		
		for (int i = 1; i < salary.length; i++) {
			if (salary[i] > currentMax) {
				currentMax = salary[i];
			}
			
			if (salary[i] < currentMin) {
				currentMin = salary[i];
			}
			
			sum += salary[i];
		}
		
		avgSalary = sum / salary.length;
		
		System.out.println("Employee Salaries: " + Arrays.toString(salary));
		System.out.println("Maximum Salary: $ " + currentMax);
		System.out.println("Minimum Salary: $ " + currentMin);
		System.out.println(String.format("Average Salary: $ %.2f", avgSalary));

	}
}


