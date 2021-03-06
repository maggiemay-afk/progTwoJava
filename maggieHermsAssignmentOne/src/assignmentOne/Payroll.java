/*************************************************************************************************************
Name: Maggie Herms
Email: mkherms@uwm.edu
Start Date: 2/1/2022
Last Modified: 2/5/2022
Description: This program reads employee data from an input file and outputs to a file payroll information
*************************************************************************************************************/
package assignmentOne;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Payroll {

		//Declaring all final and static variables in payroll class so we can use them in all methods and only initialize variables once
		final static Double lowTaxRate = .18;
		final static Double middleTaxRate = .23;
		final static Double highTaxRate = .28;
		final static Double otherTaxRate = .33;
		final static Double lowTaxBracket = 250.00;
		final static Double middleTaxBracket = 550.00;
		final static Double highTaxBracket = 1100.00;
		
		static String lastName, firstName;
		static Double payRate, hoursWorked, taxRate; 
		static Double totalPayroll = 0.0, totalTaxes = 0.0, payrollChecksTotal = 0.0;
		static Double grossSalary, taxes, netIncome;
		
		final static String strNumEmp = "Number of Employees Processed:";
		final static String strTotalPayroll = "Total Payroll:";
		final static String strTotalTaxes = "Total Taxes:";
		final static String strPayrollCheckTotal = "Payroll Checks Total:";
		
	public static void main(String[] args) throws FileNotFoundException{
	
		//ask user to input number of employees in the file - 23 for this program
		int countOfEmployees = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of "
				+ "employees in the file")); 
		
		//creates new scanner class and print writer class called inFile and outFile - provides path
		Scanner inFile = new Scanner(new FileReader("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\maggieHermsAssignmentOne\\employees.txt")); 
		PrintWriter outFile = new PrintWriter("c:\\Users\\Maggie Herms\\Documents\\progTwoJava\\maggieHermsAssignmentOne\\payroll.txt");

		for (int i = 1; i <= countOfEmployees; i++) { //loops through each employee in the employee.txt file
			lastName = inFile.next();
			firstName = inFile.next();
			payRate = inFile.nextDouble();
			hoursWorked = inFile.nextDouble();
			
			//below line of code would show "Processing first last" for each employee. Optional line, I removed because it's not necessary and uses lots of dialog boxes
			//JOptionPane.showMessageDialog(null, "Processing: " + firstName + " " + lastName, "Processing", JOptionPane.INFORMATION_MESSAGE);
			
			grossSalary = (hoursWorked * payRate); //computations for gross salary, taxes, and net income
			taxRate = getTaxRate(grossSalary); //calls getTaxRate method, passes in gross salary
			taxes = (taxRate * grossSalary);
			netIncome = (grossSalary - taxes);
			
			outFile.format("First Name:\t%s\nLast Name:\t%s\nPay Rate:\t$%.2f\nHours Worked:\t%.2f\n"
					+ "Gross Salary:\t$%.2f\nTaxes:\t\t$%.2f\nNet Income:\t$%.2f\n", 
					firstName, lastName, payRate, hoursWorked, grossSalary, taxes, netIncome);
			makeDottedLine(outFile); //calls make dotted line function, passes in our print writer class called outFile
			
			totalPayroll += grossSalary; //adds each current employee's gross salary, taxes, and net income to our employee totals
			totalTaxes += taxes;
			payrollChecksTotal += netIncome;
			
		} //end for loop
		
		makeDottedLine(outFile); //calls make dotted line function again - passing in our Print Writer called outFile
		outFile.format("%-31s%d\n%-31s$%.2f\n%-31s$%.2f\n%-31s$%.2f\n", strNumEmp, countOfEmployees, strTotalPayroll, 
				totalPayroll, strTotalTaxes, totalTaxes, strPayrollCheckTotal, payrollChecksTotal);
		JOptionPane.showMessageDialog(null,"Payroll Processing Complete.\nPlease See: Payroll.txt", "Program Finished",JOptionPane.INFORMATION_MESSAGE);
	
		outFile.flush();
		inFile.close();
		outFile.close();
	} //end main method
	
	public static Double getTaxRate(double employeeSalary) { //method that takes in user salary and, using if statements, identifies their tax bracket
		
		if (employeeSalary <= lowTaxBracket) {
			taxRate = lowTaxRate;
		} else if (employeeSalary <= middleTaxBracket) {
			taxRate = middleTaxRate;
		} else if (employeeSalary <= highTaxBracket) {
			taxRate = highTaxRate;
		} else taxRate = otherTaxRate;
		
		return taxRate;
	}//end get tax rate method
	
	public static void makeDottedLine(PrintWriter payrollFileWriter) { //method that prints to the payroll file a dotted line
		payrollFileWriter.print("---------------------------------------------------------\n");
	} //end make dotted line method
	
} //end payroll class


