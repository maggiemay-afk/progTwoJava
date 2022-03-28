package diceGame;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Die {
	public static final int DEFAULT_NUM_FACES = 6;
	
	public static int faceValue;
	public static int numFaces;
	public static int tossOne;
	public static int tossTwo;
	public static int tossThree;
	
	public Die (int x, int y) {
		
	}
	
	public Die (int x) {
		
	}
	
	public Die () {
		
	}
	
	public Die (Die z) {
		
	}
	
	public static int getFaceValue () {
		faceValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		//System.out.println(faceValue); use to test random number generation
		return faceValue;
	}
	
	public int getNumFaces () {
		return 3;
	}
	
	public void setFaceValue (int z) {
		
	}
	
	public static void roll () {
		faceValue = getFaceValue();
	}
		
	public static void greeting () {
		JOptionPane.showMessageDialog(null, "Welcome to Maggie's Dice Game.\nPlayers get three rolls.", "Greetings!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String toString () {
		return String.format("Toss 0: generated a ", faceValue);
	}

	public static void main(String[] args) {
		Die.greeting();
		Die.roll();
		
		//random number generation test
		/*for (int i = 0; i < 100; i++) {
			Die.roll();
		}*/
		

	}

}
