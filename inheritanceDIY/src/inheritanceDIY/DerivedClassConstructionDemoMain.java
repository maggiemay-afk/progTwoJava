package inheritanceDIY;

public class DerivedClassConstructionDemoMain {
	public static class Student {
		final protected String DEFAULT_NAME = "unknown";
		final protected int DEFAULT_AGE = 0;
		final protected double DEFAULT_GPA = 0.0;
		
		protected String name;
		protected int age;
		protected double GPA;
		
		public Student () {
			this.name = DEFAULT_NAME;
			this.age = DEFAULT_AGE;
			this.GPA = DEFAULT_GPA;
		}
		
		public Student (String stuName, int stuAge, double stuGPA) {
			this.name = stuName;
			this.age = stuAge;
			this.GPA = stuGPA;
		}
		
		public Student (Student copyStu) {
			this.name = copyStu.name;
			this.age = copyStu.age;
			this.GPA = copyStu.GPA;
		}
		
		public void Display () {
			System.out.println("Student Name: " + this.name + "\nStudent Age: " + this.age + "\nStudent GPA: " + this.GPA);
		}
	}
	
	public static class GradStudent extends Student {
		final protected int DEFAULT_GRE = 260;
		final protected Boolean DEFAULT_RESEARCH_STARTED = false;
		
		protected int GREScore;
		protected Boolean researchStarted;

		public GradStudent () {
			super();
			this.GREScore = DEFAULT_GRE;
			this.researchStarted = DEFAULT_RESEARCH_STARTED;
		}
		
		public GradStudent (String stuName, int stuAge, double stuGPA, int stuGRE, Boolean stuResearch) {
			super(stuName, stuAge, stuGPA); 
			this.GREScore = stuGRE;
			this.researchStarted = stuResearch;
		}
		
		public GradStudent (GradStudent copyGradStu) {
			super(copyGradStu);
			this.GREScore = copyGradStu.GREScore;
			this.researchStarted = copyGradStu.researchStarted;
		}
		
		public void Display () {
			super.Display();
			System.out.println("Student GRE Score: " + this.GREScore + "\nResearch Started?: " + this.researchStarted);
		}
		
		public void Display (String x) {
			System.out.println(x);
			this.Display();
		}
	}
	
	public static void main(String[] args) {
		Student stuOne, stuTwo, stuThree;
		GradStudent gradStuOne, gradStuTwo, gradStuThree;
		
		stuOne = new Student("Harry", 19, 3.20);
		stuTwo = new Student(stuOne);
		stuThree = new Student();
		stuOne.Display();
		
		gradStuOne = new GradStudent("Hermione", 23, 4.00, 340, true);
		gradStuTwo = new GradStudent(gradStuOne);
		gradStuThree = new GradStudent();
		//gradStuOne.Display();
		gradStuOne.Display("Hogwarts Graduate School");
	}
}


