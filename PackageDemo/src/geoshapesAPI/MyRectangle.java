package geoshapesAPI;
import pointAPI.*;

public class MyRectangle {
	MyPoint topLeft, bottomRight;
	
	public MyRectangle(MyPoint topLeft, MyPoint bottomRight){
		this.topLeft = new MyPoint(topLeft);
		this.bottomRight = new MyPoint(bottomRight);
	}
	
	public String toString(){
		return "( " + topLeft + ", " + bottomRight + " )";
	}
}
