package examPractice;

public class Scope {

	int a;
	public void f1(int x) {
		int b =10;
		
		if (a>10) {
			int e =10;
			b +=x;
			
			if (a>20) {
				
				int d=10;
				b+=x;
				b+=d;
				b+=e;
				
			} else {
				int c=10;
				b+=x;
				b+=c;
				b+=e;
			}
		}
		
		b+=x;

	}

}
