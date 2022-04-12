package classWithArrayOfClassObjects;
import arraysOfObjects.Student;
import java.util.Arrays;
import javax.swing.*;

public class StudentList {
	public int numStudents;
	public int last = 0;
	public Student [] students;

	public StudentList (int initialSize) {
		this.numStudents = initialSize;
		students = new Student [initialSize + 1];
	}
	
	public void addStudent (Student stu) {
		if (last >= students.length -1) {
			doubleTheSize();
		}
		
		students[last] = stu; 
		last++;
		
		System.out.println(Arrays.toString(students));
	}
	
	private void doubleTheSize () {
		Student [] newStudentArray = new Student [students.length * 2];
		
		for (int i = 0; i < students.length; i++) {
			newStudentArray[i] = students[i];
		}
		students = newStudentArray;
	}
	
	public static void main(String[] args) {
		StudentList stuRoster = new StudentList(
				Integer.parseInt(JOptionPane.showInputDialog("How many students in your class?"))
		);
			
		Student stuOne = new Student("Hermione", 100, 'A');
		stuRoster.addStudent(stuOne);
		
		Student stuTwo = new Student("Harry", 89, 'B');
		stuRoster.addStudent(stuTwo);
		
		Student stuThree = new Student("Ron", 85, 'B');
		stuRoster.addStudent(stuThree);

	}

}
