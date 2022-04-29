package account;

public class SavingAccount extends Account{
	
	private final static double DEFAULT_RATE = 0.05;
	private double rate; //account interest rate
	
	/** Creates instance of Saving Account class with parameters for balance and interest rate
	 * calls super for Account parent class constructor to set balance and get account number
	 * then sets interest rate to parameter rate
	 * 
	 * @param bal amount to set initial Saving Account Balance to
	 * @param rate amount to set current Saving Account interest rate to
	 */
	public SavingAccount (double bal, double rate) {
		super(bal);
		this.rate = rate;
	}
	
	/** Creates instance of Saving Account class with parameter balance and default interest rate
	 * uses first Saving Account constructor which calls super for Account parent class constructor to set balance and get account number
	 * then sets interest rate to default interest rate
	 * @param bal amount to set initial balance of Saving Account to
	 */
	public SavingAccount (double bal) {
		this(bal, DEFAULT_RATE);
	}
	
	/**
	 * Creates an instance of Savings Account class with default balance and default interest rate
	 * uses first Saving Account constructor which calls super for Account parent class constructor to set balance and get account number
	 * then sets interest rate to default interest rate
	 */
	public SavingAccount () {
		this(DEFAULT_BAL, DEFAULT_RATE);
	}
	
	/** Copy Constructor. Creates instance of Saving Account by calling super for Account parent class's copy constructor.
	 * Uses parameter acct instance values for balance and the interest rate
	 * 
	 * @param acct Instance of Saving Account
	 */
	public SavingAccount (SavingAccount acct) {
		super(acct);
		this.rate = acct.rate;
	}
	
	/** Calculates compounded Interest by multiplying the current balance with the interest rate.
	 * Adds the compounded interest to the current balance.
	 * 
	 * @return total compounded interest
	 */
	public double compound () {
		double compoundInterest = (this.bal * this.rate);
		this.bal += compoundInterest;
		return compoundInterest;
	}
	
	/** Takes parameter amount and attempts to withdraw it from the current balance. If the user attempted to withdraw more money than
	 * was in the account, it will return 0.0. Otherwise, it will remove the withdraw amount and return the amount that was withdrawn.
	 * 
	 * @param amount total amount to withdraw from account balance
	 * @return amount that was withdrawn from account
	 */
	public double withd (double amount) {
		if (amount > this.bal) {
			return 0.0; //return 0.0 because they attempted to withdraw more than their balance
		} else {
			this.bal -= amount;
			return amount;
		}
	}
	
	/** Calls super for Account parent class which returns the current balance and account number
	 * Then, returns the current interest rate
	 */
	public String toString () {
		return String.format(super.toString() + "\nInterest Rate: %.2f" , this.rate);
	}
	
	/**
	 * @return current interest rate for Saving Account
	 */
	public double getRate () {
		return this.rate;
	}

}
