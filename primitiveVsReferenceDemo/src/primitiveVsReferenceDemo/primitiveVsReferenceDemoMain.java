package primitiveVsReferenceDemo;

public class primitiveVsReferenceDemoMain {
	  
    public static int funForAll(int x, String y) {
        int a = 5;
        x = a;
        y = "fun";
        return 2*a;
    }
    public static void main(String[] args) {
        int x = 2, a = 3;
        String s = "funny";
        
        x = funForAll(a, s);
        
        System.out.println(s + a + x);
    }
 }
