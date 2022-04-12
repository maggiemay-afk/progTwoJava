/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * Last updated: 4/3/2022
 * Description: dice game that uses a random number generator to "roll" any number of die.
 * Then calculates the summation for each roll and the total of all rolls
 */

package diceGame;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;


public class Die {
	public static final int DEFAULT_NUM_FACES = 6;
	
	private int faceValue;
	private int numFaces;

	/**
	 * Create a die with user inputed face value and user inputed number of faces
	 * @param inputFaceValue
	 * @param inputNumFaces
	 */
	public Die (int inputFaceValue, int inputNumFaces) {
		faceValue = inputFaceValue;
		numFaces = inputNumFaces;
		
		if (faceValue > numFaces) { // ensures user can't have a die with a higher face value than number of faces allows for
			throw new Error("face value must be less than or equal to default number of faces");
		}
	}
	
	/**
	 * Create a Die with default number of faces and inputed face value
	 * @param inputFaceValue - The die's current face value
	 */
	public Die (int inputFaceValue) {
		faceValue = inputFaceValue;
		numFaces = DEFAULT_NUM_FACES;
		
		if (faceValue > numFaces) { // ensures user can't have a die with a higher face value than number of faces allows for
			throw new Error("face value must be less than or equal to default number of faces");
		}
	}
	
	/**
	 * Creates a die with default face value of 6 and default number of faces as 6
	 */
	public Die () {
		faceValue = DEFAULT_NUM_FACES;
		numFaces = DEFAULT_NUM_FACES;
	}
	
	/**
	 * Copy constructor of Die class. 
	 * Sets face value and number of faces to the values from the inputed instance of Die
	 * @param copyDie
	 */
	public Die (Die copyDie) {
		this(copyDie.faceValue, copyDie.numFaces);
	}
	
	public int getFaceValue () { //getter - returns current face value of die instance
		return faceValue;
	}
	
	public int getNumFaces () { //getter - returns current number of faces on die for die instance
		return numFaces;
	}
	
	/**
	 * Takes user inputed value and updates the face value of die
	 * @param inputFaceValue
	 */
	public void setFaceValue (int inputFaceValue) {
		faceValue = inputFaceValue;
	}
	
	/**
	 * Uses threadLocalRandom from Java Util package to generate a random number for the face value of a die. 
	 * Number is between 1 and however many sides are on the die. 
	 * A 6 sided die will produce a random number between 1 and 6
	 */
	public void roll () {
		faceValue = ThreadLocalRandom.current().nextInt(1, numFaces + 1);
	}
	
	/**
	 * GUI for welcome message
	 */
	public static void greeting () {
		JOptionPane.showMessageDialog(null, "Welcome to Maggie's Dice Game.\nPress 'OK' to continue", 
				"Greetings!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Tests for each overloaded constructor and the copy constructor of Die class
	 * Tests each method of Die class
	 */
	public static void QA () {
		Die QADie = new Die(); // test overloaded constructor with no inputs
		System.out.println("Tests for Die constructor with no parameters: ");
		System.out.println("Face value for QA Die. Expected Value = 6. Real Value: " + QADie.getFaceValue()); 
		System.out.println("Number of faces for QA Die. Expected Value = 6. Real Value: " + QADie.getNumFaces());
		
		Die QADieTwo = new Die(5); //test overloaded constructor with one input
		System.out.println("\nTests for Die constructor with one parameter: ");
		System.out.println("Face value for QA Die Two. Expected Value = 5. Real Value: " + QADieTwo.getFaceValue()); 
		System.out.println("Number of faces for QA Die Two. Expected Value = 6. Real Value: " + QADieTwo.getNumFaces());
		
		QADieTwo.setFaceValue(4); //update setter for face value
		System.out.println("\nTests for updating face value of Die constructor with one parameter: ");
		System.out.println("Face value for QA Die Two. Expected Value = 4. Real Value: " + QADieTwo.getFaceValue()); 
		System.out.println("Number of faces for QA Die Two. Expected Value = 6. Real Value: " + QADieTwo.getNumFaces());
		
		Die QADieThree = new Die(7, 10); //test overloaded constructor with two inputs
		System.out.println("\nTests for Die constructor with two parameters: ");
		System.out.println("Face value for QA Die Three. Expected Value = 7. Real Value: " + QADieThree.getFaceValue());
		System.out.println("Number of faces for QA Die Three. Expected Value = 10. Real Value: " + QADieThree.getNumFaces());
		
		Die QACopy = new Die(QADieTwo); //test copy constructor
		System.out.println("\nTests for Die copy constructor using QA Die Two: ");
		System.out.println("Face value for QA Copy Die. Expected Value = 4. Real Value: " + QACopy.getFaceValue());
		System.out.println("Number of faces for QA Copy Die. Expected Value = 6. Real Value: " + QACopy.getNumFaces());
		
		//tests random number generator - roll Method and toString method
		System.out.println("\nTests for roll Method and toString Method using QA Die:");
		for (int i = 0; i <= 50; i++) {
			QADie.roll();
			System.out.println(QADie);
		}
	}
	
	public String toString () {
		return String.format("(%d)", faceValue);
	}

	public static void main(String[] args) {
		//Die.QA();
		Die.greeting(); 
		
		// first instance of die with user input for number of faces. Face value to be updated by roll method
		Die dieOne = new Die(1, 
				Integer.parseInt(JOptionPane.showInputDialog("How many faces are on the first die?\nEnter an integer value:"))
		);
		
		//second instance of die with user input for number of faces. Face value to be updated by roll method
		Die dieTwo = new Die(1, 
				Integer.parseInt(JOptionPane.showInputDialog("How many faces are on the Second die?\nEnter an integer value:"))
		);
		
		int rollCount = 3;
		int totalRollsCount = 0;
		
		//Loops through die one and die two instances. Uses the roll method to generate random numbers for each "roll"
		for (int i = 1; i <= rollCount; i++) {
			dieOne.roll();
			dieTwo.roll();
			totalRollsCount += dieOne.getFaceValue() + dieTwo.getFaceValue();
			
			//Print roll value for each toss of die one and die two, then calculates summation of each toss
			System.out.println("Toss " + i + ": generated a " + dieOne + " and a " + dieTwo
					+ " for a total of " + (dieOne.getFaceValue() + dieTwo.getFaceValue())
			);
		}
		// print total value of all three rolls of two dice
		System.out.println("Total of the three tosses is: " + totalRollsCount);
	}
	
}
