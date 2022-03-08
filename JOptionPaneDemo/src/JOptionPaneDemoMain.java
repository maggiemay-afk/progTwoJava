import javax.swing.JOptionPane; 

public class JOptionPaneDemoMain {

	public static void main(String[] args) {
		
		String strUserHours;
		String strUserPayRate;
		
		double userWeeklyHours;
		double userPayRate;
		double userWeeklySalary;
		
		int numStudents;
		
		/*strUserHours = JOptionPane.showInputDialog("Please enter your number of hours worked this week:");
		strUserPayRate = JOptionPane.showInputDialog("Please enter your hourly rate of pay:");
		
		userWeeklyHours = Double.parseDouble(strUserHours);
		userPayRate = Double.parseDouble(strUserPayRate);
		
		userWeeklySalary = userWeeklyHours * userPayRate;
		
		JOptionPane.showMessageDialog(null, 
									 String.format("Your weekly salary is: %.2f", userWeeklySalary), 
									 "User Income Information", 
									 JOptionPane.INFORMATION_MESSAGE);
		*/
		numStudents = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of students in this course"));
	
		
	}
}
