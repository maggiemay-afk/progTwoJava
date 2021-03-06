/***************************************************************************************************
* Name: Maggie Herms
* Email: mkherms@uwm.edu 
* Started: 2/25/2022
* Last Modified: 
* Description: Payroll processing program
****************************************************************************************************/

package assignmentTwoPayroll;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Assignment2Main {

	//User Instruct method
	public static void userInstruct () {
		JOptionPane.showMessageDialog(null,"This program processes payroll for AvaCam Inc.\nFor authorized use by "
				+ "AvaCam employees only", "User Instructions", JOptionPane.INFORMATION_MESSAGE);
	}

	//findSalary method
	public static double findSalary (double empPayRate, double empHoursWorked, double empOvertimeRate) {
		double empSalary = 0, totalOvertimeHours, overtimeSalary;
		
		//if someone works over 40 hours, add overtime pay to normal salary
		if (empHoursWorked > 40) {
			totalOvertimeHours = empHoursWorked - 40;
			overtimeSalary = totalOvertimeHours * (empOvertimeRate * empPayRate);
			empSalary = (empPayRate * 40) + overtimeSalary;
		} else {
			empSalary = empPayRate * empHoursWorked;
		}
		return empSalary;
	}
	
	//findTaxes method
	public static double findTaxes (double empGrossSalary) {
		double taxes;
		
		if (empGrossSalary <= 250.00) {
			taxes = empGrossSalary * 0.18;
		} else if (empGrossSalary <= 550.00) {
			taxes = empGrossSalary * 0.23;
		} else if (empGrossSalary <= 1100) {
			taxes = empGrossSalary * 0.28;
		} else {
			taxes = empGrossSalary * 0.33;
		}
		return taxes;
	}
	
	//findNetIncome method
	public static double findNetIncome (double empSalary, double empTaxes) {
		double netIncome = empSalary - empTaxes;
		return netIncome;
	}
	
	//displayPayroll method with hours, salary, taxes and netIncome goes here
	public static void displayPayroll (double empHours, double empGrossSalary, double empTaxes, double empNetIncome) {
		
		JOptionPane.showMessageDialog(null, String.format("Hours: %.2f\nSalary: %.2f\nTaxes: %.2f\nNet Income: %.2f", 
				empHours, empGrossSalary, empTaxes, empNetIncome), "Employee Information", JOptionPane.INFORMATION_MESSAGE);
	}
	 
	//displayPayroll method with hours, rateOfPay, overtimePay, salary, taxes and netIncome goes here
	public static void displayPayroll(double empHours, double empPayRate, double overtimeRate, double empGrossSalary, 
			double empTaxes, double empNetIncome) {
		
		JOptionPane.showMessageDialog(null, String.format("Hours: %.2f\nRate of Pay: %.2f\nOvertime Rate: %.2f\nSalary: "
				+ "%.2f\nTaxes: %.2f\nNet Income: %.2f", empHours, empPayRate, overtimeRate, empGrossSalary, empTaxes, 
				empNetIncome), "Employee Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//writePayroll method with hours, salary, taxes, netIncome and a printwriter goes here
	public static void writePayroll (double empHours, double empGrossSalary, double empTaxes, double empNetIncome, PrintWriter outFile) {
		
		//writes relevant payroll information to output file
		outFile.println(String.format("Hours: %.1f", empHours));
		outFile.println(String.format("Salary: %.2f", empGrossSalary));
		outFile.println(String.format("Taxes: %.2f", empTaxes));
		outFile.println(String.format("Net Income: %.2f", empNetIncome));
	}
	
	//writePayroll method with hours, rateOfPay, overtimePay, salary, taxes, netIncome and a printwriter goes here
	public static void writePayroll (double empHours, double empPayRate, double overtimeRate, double empGrossSalary, 
			double empTaxes, double empNetIncome, PrintWriter outFile) {
		
		//writes relevant payroll information to output file
		outFile.println(String.format("Hours: %.1f", empHours));
		outFile.println(String.format("Rate of Pay: %.2f", empPayRate));
		outFile.println(String.format("Overtime Rate: %.2f", overtimeRate));
		outFile.println(String.format("Salary: %.2f", empGrossSalary));
		outFile.println(String.format("Taxes: %.2f", empTaxes));
		outFile.println(String.format("Net Income: %.2f", empNetIncome));
	}
	
	public static void QA() throws FileNotFoundException {
	
	// This is the QA method.  
	// You should develop your methods (as listed in the assignment and above) one at
	// a time and test them using this QA method.  You should make sure that each method you
	// develop works before moving to development of the next method.  
	
	// YOU MUST NOT CHANGE THE STATEMENT OF THIS QA METHOD.  You may however, uncomment the 
	// sections when testing the corresponding method  
	
		System.out.println("Starting with QA");
		
		//create dummy values for testing the methods		
		double hoursBelow40 = 23, hoursAbove40 = 47;
		double rateOfPay = 13, overtimeRate = 1.3;
		double salary, taxes, netIncome;
		double salaryBelowFirstTaxBracket = 200;
		double salaryBelowsecondTaxBracket = 500;
		double salaryBelowThirdTaxBracket = 1000;
		double salaryAbovelastTaxBracket = 2000;
		
		//testing userInstruct - don't develop the next method until this is done. 
		//uncomment the following to test the method
		
		 System.out.println("Testing userInstruct");
		 userInstruct();
		 
		
		//testing findSalary - don't develop the next method until this is done.
		//uncomment the following to test the method
		
		System.out.println("Testing findSalary");
		salary = findSalary(hoursBelow40, rateOfPay, overtimeRate);
		System.out.println("Salary for "+ hoursBelow40 + " hours at rate " + rateOfPay + ": " + salary);
		salary = findSalary(hoursAbove40, rateOfPay, overtimeRate);
		System.out.println("Salary for "+ hoursAbove40 + " hours at rate " + rateOfPay + " and overtime rate " + overtimeRate +": " + salary);
		

		//testing findTaxes - don't develop the next method until this is done.
		//uncomment the following to test the method
		
		System.out.println("Testing findTaxes");
		taxes = findTaxes(salaryBelowFirstTaxBracket);
		System.out.println("Taxes for "+ salaryBelowFirstTaxBracket + ": " + taxes);	
		taxes = findTaxes(salaryBelowsecondTaxBracket);
		System.out.println("Taxes for "+ salaryBelowsecondTaxBracket + ": " + taxes);
		taxes = findTaxes(salaryBelowThirdTaxBracket);
		System.out.println("Taxes for "+ salaryBelowThirdTaxBracket + ": " + taxes);
		taxes = findTaxes(salaryAbovelastTaxBracket);
		System.out.println("Taxes for "+ salaryAbovelastTaxBracket + ": " + taxes);
		
		
		//testing findNetIncome- don't develop the next method until this is done.
		//uncomment the following to test the method
		
		System.out.println("Testing findNetIncome");
		netIncome = findNetIncome(salaryAbovelastTaxBracket, taxes);
		System.out.println("Net Income: "+ netIncome);
		
		
		//testing displayPayroll method with hours, salary, taxes and netIncome 
		//don't develop the next method until this is done.
		//uncomment the following to test the method
		
		System.out.println("Testing displayPayroll method with hours, salary, taxes and netIncome");
		displayPayroll(20, 200, 50, 150);
		
		
		//testing displayPayroll method with hours, rateOfPay, overtimePay, salary, taxes and netIncome
		//don't develop the next method until this is done.
		//uncomment the following to test the method
		
		System.out.println("Testing displayPayroll method with hours, rateOfPay, overtimePay, salary, taxes and netIncome");
		displayPayroll(20, 13, 20, 200, 50, 150);
		
		
		PrintWriter outFile = new PrintWriter("C:/Users/Maggie Herms/Documents/progTwoJava/assignmentTwoPayroll/QA.txt");
		
		
		//testing writePayroll method with hours, salary, taxes, netIncome and printWrite
		//don't develop the next method until this is done.
		//uncomment the following to test the method
		
		System.out.println("displayPayroll method with hours, salary, taxes, netIncome and printWrite");
		writePayroll(20, 200, 50, 150, outFile);
		
		
		outFile.println();

		
		//testing writePayroll method with hours, rateOfPay, overtimePay, salary, taxes, netIncome and printWrite
		//don't develop the next method until this is done.
		//uncomment the following to test the method
		
		System.out.println("displayPayroll method with hours, rateOfPay, overtimePay, salary, taxes, netIncome and printWrite");
		writePayroll(20, 13, 20, 200, 50, 150, outFile);
		
		outFile.close();
		
		System.out.println("Done with QA");
	}

	
	public static void main(String[] args) throws FileNotFoundException{

		//QA();
		//Once done with QA, comment the above call to QA.  Then uncomment the 
		//partially developed code below and complete it to accomplish 
		// the task of the assignment.
		
		userInstruct();
	
		Scanner inFile = new Scanner(new FileReader("C:/Users/Maggie Herms/Documents/progTwoJava/assignmentTwoPayroll/employees.txt"));
		PrintWriter  outFile = new PrintWriter("C:/Users/Maggie Herms/Documents/progTwoJava/assignmentTwoPayroll/employeeOutput.txt");
		
		String firstName, lastName;
		int numEmployeesToProcess;
		double hoursWorked, grossSalary, payRate, overtimeRate, taxes, netIncome, totalSalary=0, totalTaxes=0, payrollChecksTotal=0;
		numEmployeesToProcess = Integer.parseInt(JOptionPane.showInputDialog("How many employees to process?")); //23
		
		overtimeRate = inFile.nextDouble();
		
		//loops through employees in the employees file
		//captures employee information and calculates salary, taxes, income
		//writes information to GUI and output file 
		for (int i = 1; i<=numEmployeesToProcess; i++) {
			lastName = inFile.next();
			firstName = inFile.next();
			payRate = inFile.nextDouble();
			hoursWorked = inFile.nextInt();
			
			
			grossSalary = findSalary(payRate, hoursWorked, overtimeRate);
			taxes = findTaxes(grossSalary);	
			netIncome = findNetIncome(grossSalary, taxes);
			
			//displayPayroll(hoursWorked, grossSalary, taxes, netIncome);
			displayPayroll(hoursWorked, payRate, overtimeRate, grossSalary, taxes, netIncome);
			
			//writePayroll(hoursWorked, grossSalary, taxes, netIncome, outFile);
			writePayroll(hoursWorked, payRate, overtimeRate, grossSalary, taxes, netIncome, outFile);
			outFile.println("----------------------------------------------------------");
			
			totalSalary += netIncome;
			totalTaxes  += taxes;
			payrollChecksTotal += grossSalary;	
		}
		
		//writes total payroll information to output file
		outFile.println("----------------------------------------------------------");
		outFile.println(String.format("Number of Employees Processed:\t%d", numEmployeesToProcess));
		outFile.println(String.format("Total Payroll:\t\t\t$%.2f", totalSalary));
		outFile.println(String.format("Total Taxes:\t\t\t$%.2f", totalTaxes));
		outFile.println(String.format("Payroll Checks Total:\t\t$%.2f", payrollChecksTotal));
		
		inFile.close();
		outFile.close();
		
		//End of main code
	}
}
