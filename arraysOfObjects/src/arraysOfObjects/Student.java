package arraysOfObjects;
import java.util.Arrays;
import javax.swing.*;

public class Student {
	private String name;
	private int score;
	private char grade;
	
	/** @param stuName
	 *  @param stuScore
	 *  @param stuGrade
	 */
	public Student (String stuName, int stuScore, char stuGrade) {
		this.name = stuName;
		this.score = stuScore;
		this.grade = stuGrade;
	}
	
	/**This function finds the average score for the class
	 * @param roster
	 * @return*/
	public static double AverageScore (Student [] roster) {
		double averageScore;
		double sum = 0;
		int count = 0;
		
		for (int i = 0; i < roster.length; i++) {
			sum += roster[i].GetScore();
			count++;
		}
		averageScore = sum / count;
		return averageScore;
	}
	
	/** This function prints students who's score is above the average
	 * @param roster
	 * @param averageScore */
	public static void PrintAboveAverage (Student [] roster, double averageScore) {
		for (int i = 0; i < roster.length; i++) {
			if (roster[i].GetScore() > averageScore) {
				System.out.println(roster[i].GetName() + "'s score was above average!");
			}
		}
	}
	
	/**This function will search for the argument student name and return their score if found
	 * @param roster
	 * @param stuName
	 * @return*/
	public static double FindScore (Student [] roster, String stuName) {
		for (int i = 0; i < roster.length; i++) {
			
			if (roster[i].GetName().toLowerCase().equals(stuName.toLowerCase())) {
				return roster[i].GetScore();
			} 
		}
		return -1;	
	}
		
	public String GetName () {
		return this.name;
	}
	
	public double GetScore () {
		return this.score;
	}
	
	public char GetGrade () {
		return this.grade;
	}
	
	public void SetGrade (char stuGrade) {
		this.grade = stuGrade;
	}
	
	public String toString () {
		 return "Name: " + this.name + "\tScore: " + this.score + "\tGrade: " + this.grade; 
	}

	public static void main(String[] args) {
		int numStudents = Integer.parseInt(
				JOptionPane.showInputDialog("How many students are in your class?")
		);
		Student [] classRoster = new Student [numStudents];
		String tempName;
		int tempScore;
		char tempGrade = 'N';
		
		for (int i = 0; i < classRoster.length; i++) {
			tempName = JOptionPane.showInputDialog("Please enter student " + (i+1) + " name");
			tempScore = Integer.parseInt(
					JOptionPane.showInputDialog("Please enter student " + (i+1) + " score")
			);
			//tempGrade = JOptionPane.showInputDialog("Please enter student " + (i+1) + " letter grade").charAt(0);
			classRoster[i] = new Student(tempName, tempScore, tempGrade); 
		}
		
		for (int i = 0; i < classRoster.length; i++) {
			System.out.println(classRoster[i]);
		}
		
		double averageStuScore = Student.AverageScore(classRoster);
		System.out.println(String.format("The class average score is: %.2f", averageStuScore));
		Student.PrintAboveAverage(classRoster, averageStuScore);
		
		String nameForSearch = JOptionPane.showInputDialog("Enter student name to search for their score:");
		double searchForScore = Student.FindScore(classRoster, nameForSearch);
		
		if (searchForScore == -1) {
			System.out.println("Student name: " + nameForSearch + " - not found");
		} else {
			System.out.println("Student name: " + nameForSearch + "\tScore is: " + searchForScore);
		}
	}
}
