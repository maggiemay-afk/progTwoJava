import examsAPI.*;

public class ClassesWithArrayMembersDemoMain {
	
	public static void main(String[] args) {
		int[] examScores = {19, 87, 79, 99, 56, 69, 38};
		
		Exam test1 = new Exam(examScores);
		Exam test2 = new Exam(test1);
	}
}
