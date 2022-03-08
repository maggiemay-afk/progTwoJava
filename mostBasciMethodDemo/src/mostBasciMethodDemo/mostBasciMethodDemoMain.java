package mostBasciMethodDemo;

public class mostBasciMethodDemoMain {
	
	public static void haveANiceDay(){
	     System.out.println("The program is now terminating.");
	     System.out.println("have a nice day!");
	     return;
	}
	
	public static void helloAndWelcome () {
		System.out.println("Welcome to my program!");
		return;
	}

	public static void main(String[] args) { 
		System.out.println("Now calling hello function:");
		helloAndWelcome();
		System.out.println("Just returned from hello function. Now calling goodbye function:");
		haveANiceDay(); 
		System.out.println("Now calling hello function:");
		helloAndWelcome();
		System.out.println("Just returned from hello function. Now calling goodbye function:");
		haveANiceDay();
		System.out.println("Thanks for visiting!");
	}
}
