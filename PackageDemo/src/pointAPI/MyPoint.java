package pointAPI;


public class MyPoint {
	private int x, y;
	
	public MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public MyPoint(MyPoint p){
		this.x = p.x;
		this.y = p.y;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
}
