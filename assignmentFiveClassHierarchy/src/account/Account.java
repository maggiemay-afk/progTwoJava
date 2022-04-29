package account;

public class Account {
	
	protected final static double DEFAULT_BAL = 1000.00;
	private static int nextAvailableAcctNumber = 0;
	protected double bal; //account balance
	private int number; //account number

	/** Sets account balance to parameter balance, sets account number to the next available account number, increments next available
	 * 
	 * @param bal amount for initial balance of account
	 */
	public Account (double bal) {
		this.bal = bal;
		this.number = nextAvailableAcctNumber;
		nextAvailableAcctNumber ++;
	}
	
	/**
	 * Creates an instance of account. Uses first constructor of Account to set balance to 0.0 and get an account number
	 */
	public Account () {
		this(0.0);
	}
	
	/** Copy constructor. Calls first Account constructor and sets the new instance balance equal to copyAcct balance
	 * 
	 * @param copyAcct instance of Account
	 */
	public Account (Account copyAcct) {
		this(copyAcct.bal);
	}
	
	/** Deposits money into account as long as the deposit amount is greater than 0
	 * 
	 * @param amt amount to deposit into account
	 */
	public void deposit (double amt) {
		if (amt > 0) {
			this.bal += amt;
		}
	}
	
	/**
	 * Returns account number and current account balance
	 */
	public String toString () {
		return String.format("Account Number: %d" + "\nBalance: %.2f", this.number, this.bal);
	}
	
	/** Checks the current instance account number against the parameter Account instance account number. 
	 * Returns true if they equal, otherwise returns false
	 * 
	 * @param thisAccount instance of Account
	 * @return Boolean True or False
	 */
	public boolean equals (Account thisAccount) {
		if (this.number == thisAccount.number) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return current account balance
	 */
	public double getBal () {
		return this.bal;
	}
	
	/**
	 * @return current account number
	 */
	public int getAcctNumber () {
		return this.number;
	}

}
