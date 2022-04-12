package examsAPI;

public class Exam {
	private int scores[];

	public Exam(int [] scores){
		this.scores = new int[scores.length];
		for (int i = 0; i < scores.length; i++)
			this.scores[i] = scores[i];
	}
	
	/*public Exam(Exam e){
		this.scores = new int[e.scores.length];
		for (int i = 0; i < scores.length; i++)
			this.scores[i] = e.scores[i];
	}*/
	
	//A better approach to copy construction
	public Exam(Exam e){
		this(e.scores);
	}
}

