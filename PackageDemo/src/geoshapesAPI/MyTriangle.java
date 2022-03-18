package geoshapesAPI;
import pointAPI.*;

public class MyTriangle {
	MyPoint p1, p2, p3;
	
	public MyTriangle (MyPoint p1, MyPoint p2, MyPoint p3){
		this.p1 = new MyPoint(p1);
		this.p2 = new MyPoint(p2);
		this.p3 = new MyPoint(p3);
	}
	
	public String toString(){
		return "( " + p1 + ", " + p2 + ", " + p3 + " )";
	}
}
