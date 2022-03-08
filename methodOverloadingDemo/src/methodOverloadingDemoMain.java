public class methodOverloadingDemoMain {
	
	public static int findSum(int w, int x){
		int a = w + x;
		return a;
	}
	public static int findSum(int w, int x, char y){
		int b = w + x;
		return b;
	}
	public static int findSum(int w, char x, int y, char z) {
		int c = w + y;
		return c;
	}
	public static void main(String[] args) {
		int value;
		char x = 'x';
		char y = 'y';
		
		value = findSum(1, 2);
		System.out.println(value);
		value = findSum(4, 5, x);
		System.out.println(value);
		value = findSum(10, x, 6, y);
		System.out.println(value);
	}
	
}
