package geoshapesAPI;
import pointAPI.*;

public class MyLine {
	MyPoint firstPoint, secondPoint;
	
	public MyLine (MyPoint pointOne, MyPoint pointTwo) {
		this.firstPoint = new MyPoint(pointOne);
		this.secondPoint = new MyPoint (pointTwo);
	}
	
	public String toString () {
		return "( " + firstPoint + ", " + secondPoint + " )";
	}

}
