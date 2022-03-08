package accountAPI;

public class Account {	
	//CLASS MEMBER
	//Class constants - These are public unless they are only intended for use by class members and offer no value to the public
	public final static double DEFAULT_INTEREST_RATE = 0.05;
	public final static double DEFAULT_BALANCE = 0.0;

	//Class variables - These are generally private
	private static int nextAvailableAccountNumber = 0;
	
	//Class methods
	public static void resetAvailableAccountNumber(){
		nextAvailableAccountNumber = 0;
	}
	
	public static void setAvailableAccountNumber(int availableAcctNumber){
		nextAvailableAccountNumber = availableAcctNumber;
	}
	
	public static int getNextAvailableAccountNumber() {
		int acctNumberToReturn =  nextAvailableAccountNumber;
		nextAvailableAccountNumber++;
		return acctNumberToReturn;
	}
	
	//INSTANCE MEMBERS
	//Instance variables
	private double balance, rate;
	private int accountNumber;

	//Instance methods
	public Account(double balance, double rate){
		this.balance = balance; 
		this.rate = rate;
		accountNumber = getNextAvailableAccountNumber();
	}
	
	public Account(double balance){
		this(balance, DEFAULT_INTEREST_RATE);
	}
	
	public Account(){
		this(DEFAULT_BALANCE, DEFAULT_INTEREST_RATE);
	}
	
	public void deposit(double amt){
		balance += amt;
	}
	
	public double withdrawal(double amt){
		if(balance >= amt)
			balance -= amt;
		else
			balance = 0;
		return balance;
	}
	
	public void setBalance(double b){
		balance = b;
	}
	
	public void setRate(double r){
		rate = r;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double getRate(){
		return rate;
	}
	
	public void displayAccount(){
		System.out.println(String.format("AcountNumber:%30d\nBalance:%30.2f\nRate:%30.2f", accountNumber, balance, rate));	
	}
}

