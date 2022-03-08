package findAverage;

public class GetAverage {

	public static void main(String[] args) {
		int a=3, b=5, c=9;
		System.out.println(average(a, 2*b, a+b+c));
	}
	
	public static double average (int x, int y, int z) {
		return (x+y+z)/3.0;
	}
}
