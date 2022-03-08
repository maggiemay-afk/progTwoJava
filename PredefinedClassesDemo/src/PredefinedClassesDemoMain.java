import java.lang.*;
import javax.swing.*;


public class PredefinedClassesDemoMain {
	
	public static double getUserInput() {
		Double x = Double.NaN;
		
		while (Double.isNaN(x)) {
			try {
				// removes commas, in case anyone wants to input one lol 
				String strUserInput = JOptionPane.showInputDialog("Please enter a value for 'X'");
				strUserInput = strUserInput.replaceAll(",", "");
				x = Double.parseDouble(strUserInput);
		
			} catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}	
		return x;
	}
	
	public static void main(String[] args){
		
		Double x = getUserInput();
		Double sinValue = Math.sin(Math.PI / 4);
		Double userAnswer = (sinValue - Math.log(x));
		
		JOptionPane.showMessageDialog(null, String.format("The answer is: %.6f", userAnswer), 
				"Instant Math", JOptionPane.INFORMATION_MESSAGE);
		
	}
}

