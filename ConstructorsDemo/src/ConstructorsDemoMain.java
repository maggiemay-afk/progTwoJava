import accountAPI.Account;

public class ConstructorsDemoMain {

	public static void main(String[] args) {
		Account a1 = new Account(200.00, 0.1);
		a1.displayAccount();
		
		Account a2 = new Account(535.23);
		a2.displayAccount();
		
		Account a3 = new Account();
		a3.displayAccount();
	}
}
