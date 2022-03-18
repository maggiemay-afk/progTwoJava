package diy;
import javax.swing.*;

public class Rectangle {
	
	private static final double DEFAULT_WIDTH = 5;
	private static final double DEFAULT_HEIGHT = 5;
	private double width, length, area;
	
	public Rectangle (double userWidth, double userLength) {
		setWidth(userWidth);
		setLength(userLength);
		computeArea();
	}
	
	public Rectangle () {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Rectangle (Rectangle rect) {
		this(rect.width, rect.length);
	}
	
	public void computeArea () {
		area = width * length;
	}
	
	public double getArea () {
		return area;
	}
	
	public void setWidth (double x) {
		width = x;
	}
	
	public void setLength (double y) {
		length = y;
	}
	
	public String toString () {
		return String.valueOf(getArea());
	}
	
	public static void main (String[] args) {	
		Rectangle rect = new Rectangle(
				Double.parseDouble(JOptionPane.showInputDialog("Please enter a rectangle width:")), 
				Double.parseDouble(JOptionPane.showInputDialog("Please enter a rectangle length:"))
		);
		Rectangle rect2 = new Rectangle();
		
		JOptionPane.showMessageDialog(null, rect, "Rectangle Area", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, rect2, "Rectangle Area", JOptionPane.INFORMATION_MESSAGE);
		
		Rectangle rect3 = new Rectangle(rect); //deep copy
		JOptionPane.showMessageDialog(null, rect3, "Rectangle Area", JOptionPane.INFORMATION_MESSAGE);
		
		Rectangle rect4 = rect; //shallow copy
		rect.setWidth(20);      //affects both rect and rect4
		rect.computeArea();    
		JOptionPane.showMessageDialog(null, rect3, "Rectangle Area", JOptionPane.INFORMATION_MESSAGE); //changes to rect do not affect rect3 here - deep copy
		JOptionPane.showMessageDialog(null, rect4, "Rectangle Area", JOptionPane.INFORMATION_MESSAGE); //changes to rect DO affect rect4 here - shallow copy
	
	}
}
