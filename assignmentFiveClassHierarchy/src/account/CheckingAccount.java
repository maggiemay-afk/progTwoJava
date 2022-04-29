package account;

public class CheckingAccount extends Account{
	private final static double DEFAULT_LIMIT = 1000.00;
	private final static double DEFAULT_CHARGE = 2.00;
	
	private double limit; //minimum balance for a free checking. When balance drops below limit, every check cashed will have charge
	private double charge; //charge amount on every withdrawal when balance is below limit
	
	/** Creates instance of Checking account with parameter balance, limit, and charge values.
	 * Uses super for Account parent class to set balance and get account number
	 * Then sets limit to parameter value and charge to parameter value
	 * 
	 * @param bal amount to set initial checking account balance to
	 * @param limit minimum balance for free checking
	 * @param charge amount to charge on every withdraw when balance is less than limit
	 */
	public CheckingAccount (double bal, double limit, double charge) {
		super(bal);
		this.limit = limit; 
		this.charge = charge; 
	}
	
	/** Creates instance of checking account with parameter value for balance and default limit and default charge values
	 * Uses first Checking Account constructor which calls super for Account parent class to set balance and get account number
	 * Then, in the first Checking account constructor, sets limit and charge to default values
	 * 
	 * @param bal amount to set initial checking account balance to
	 */
	public CheckingAccount (double bal) {
		this(bal, DEFAULT_LIMIT, DEFAULT_CHARGE);
	}
	
	/** Creates instance of checking account with default balance, limit, and charge values
	 * Uses first checking account constructor which calls super for Account Parent class to set balance and get account number
	 * then, in the first checking account constructor, sets limit and charge to default values
	 */
	public CheckingAccount () {
		this(DEFAULT_BAL, DEFAULT_LIMIT, DEFAULT_CHARGE);
	}
	
	/** Copy constructor. Creates instance of checking account with balance, limit, and charge from instance parameter
	 * Uses super from Account parent class's copy constructor to set balance to acct parameters balance and then get account number
	 * Then, we set limit and charge to acct parameter values for limit and charge
	 * 
	 * @param acct instance of checking account
	 */
	public CheckingAccount (CheckingAccount acct) {
		super(acct);
		this.limit = acct.limit;
		this.charge = acct.charge;
	}
	
	/** Attempts to make a withdraw from current balance. If the amount to withdraw is greater than balance, return 0.0
	 * If the amount to withdraw is less than balance, but the new balance is less than the current limit, a charge fee is applied 
	 * to the withdraw. If the new balance is greater than the account limit, no charge fee is applied
	 * 
	 * @param amt amount to withdraw from current balance
	 * @return total amount withdrawn from current balance, including charge fees, if applicable
	 */
	public double withd (double amt) {
		if (amt > this.bal) {
			return 0.0; //return 0.0 because they attempted to withdraw more than their balance
		} else {
			this.bal -= amt;
			if (this.bal < this.limit) {
				this.bal -= this.charge;
				return (amt + charge);
			}
			return amt;
		}
	}
	
	/**
	 * Calls super for Account parent class which returns the current balance and account number
	 * Then, returns the current limit and charge amounts
	 */
	public String toString () {
		return String.format(super.toString() + "\nMinimum balance before a charge: %.2f" + 
		"\nCharge per check if balance falls bellow the minimem: %.2f" , this.limit, this.charge);
	}
	
	/**
	 * @return current Checking Account limit
	 */
	public double getLimit() {
		return this.limit;
	}
	
	/**
	 * @return current Checking account charge amount
	 */
	public double getCharge() {
		return this.charge;
	}

}
