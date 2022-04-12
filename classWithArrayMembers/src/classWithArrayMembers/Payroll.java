package classWithArrayMembers;

import java.util.Arrays;

public class Payroll {
	
	private double [] salary;
	
	/** @param empSalaries
	 */
	public Payroll (double [] empSalaries) {
		this.salary = new double [empSalaries.length];
		
		for (int i = 0; i < empSalaries.length; i++) {
			this.salary[i] = empSalaries[i];
		}
	}
	
	/** @param newPayroll
	 */
	public Payroll (Payroll newPayroll) {
		this.salary = new double[newPayroll.salary.length];
		
		for (int i = 0; i < salary.length; i++) {
			this.salary[i] = newPayroll.salary[i];
		}
	}

	public static void main(String[] args) {
		double [] empSalaries = {40000, 50000, 60000, 70000, 80000, 90000, 100000};
		
		Payroll payrollOne = new Payroll(empSalaries);
		Payroll payrollTwo = new Payroll(payrollOne);
		
	}

}
