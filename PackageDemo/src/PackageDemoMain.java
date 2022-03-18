import javax.swing.JOptionPane;
import geoshapesAPI.*;
import pointAPI.*;


public class PackageDemoMain {

	public static void main(String[] args) {
			MyPoint p1 = new MyPoint(
					Integer.parseInt(JOptionPane.showInputDialog("Please enter an integer number: ")),
					Integer.parseInt(JOptionPane.showInputDialog("Please enter another integer: "))
			);
					
			MyPoint p2 = new MyPoint(
					Integer.parseInt(JOptionPane.showInputDialog("Please enter an integer number: ")),
					Integer.parseInt(JOptionPane.showInputDialog("Please enter another integer: "))
			);
			
			MyPoint p3 = new MyPoint(
					Integer.parseInt(JOptionPane.showInputDialog("Please enter an integer number: ")),
					Integer.parseInt(JOptionPane.showInputDialog("Please enter another integer: "))
			);
			
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);
			
			MyRectangle r1 = new MyRectangle(p1, p2);
			MyRectangle r2 = new MyRectangle(p2, p3);
			System.out.println(r1);
			System.out.println(r2);
			
			MyTriangle t1 = new MyTriangle(p1, p2, p3);
			System.out.println(t1);
			
			MyLine line1 = new MyLine (p1, p2);
			System.out.println(line1);
	}

}
