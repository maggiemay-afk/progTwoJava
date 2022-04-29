/**********************************************************************************************************************************
 * Name: Maggie Herms
 * Contact: mkherms@uwm.edu
 * Started: 4/25/2022 Last Updated: 4/25/2022
 * About: This program uses the Account manager class to create instances of generic accounts, savings accounts, and checking accounts. 
 * 			The Account Manager class tests inheritance of parent class Account to child classes Saving Account and Checking Account.
 ***********************************************************************************************************************************/
package manager;
import account.*;

public class AccountManager {

	public static void main(String[] args) {
		//create three instances of Account, one for each constructor
		Account AccountOne = new Account();
		Account AccountTwo = new Account(27000.00);
		Account AccountThree = new Account(AccountTwo);
		
		//create four instances of Saving Account, one for each constructor
		SavingAccount SavAccountOne = new SavingAccount();
		SavingAccount SavAccountTwo = new SavingAccount(33000.00, 0.07);
		SavingAccount SavAccountThree = new SavingAccount(9000.00);
		SavingAccount SavAccountFour = new SavingAccount(SavAccountTwo);
		
		//create four instances of Checking Account, one for each constructor
		CheckingAccount CheckAccountOne = new CheckingAccount();
		CheckingAccount CheckAccountTwo = new CheckingAccount(12000.00, 200.00, 15.50);
		CheckingAccount CheckAccountThree = new CheckingAccount(18000.00);
		CheckingAccount CheckAccountFour = new CheckingAccount(CheckAccountTwo);
		
		//Begin testing for Account class methods
		System.out.println("BEGIN TESTING GENERIC ACCOUNTS\n");
		System.out.println("Do Account Two and Account Three share an account number? " + AccountTwo.equals(AccountThree));
		System.out.println("Do Account One and Account One share an account number? " + AccountOne.equals(AccountOne));
		System.out.println(String.format("\nAccount One Account Number: %d" + "\nAccount One Initial Balance: %.2f", 
				AccountOne.getAcctNumber(), AccountOne.getBal()));
		AccountOne.deposit(1700.50);
		System.out.println("Account One After Deposit\n" + AccountOne);
		System.out.println("\nAccount Two\n" + AccountTwo);
		System.out.println("\nAccount Three\n" + AccountThree);
		
		//Begin testing for Saving Account methods
		System.out.println("\nBEGIN TESTING SAVINGS ACCOUNTS\n");
		System.out.println("Initial Saving Accounts Informaiton:");
		System.out.println("\nSaving Account One\n" + SavAccountOne);
		System.out.println("\nSaving Account Two\n" + SavAccountTwo);
		System.out.println("\nSaving Account Three\n" + SavAccountThree);
		System.out.println("\nSaving Account Four\n" + SavAccountFour);
		System.out.println("\nSaving Account Four Interest Rate: " + SavAccountFour.getRate());
		System.out.println("Compound Interest of Saving Account Four: " + SavAccountFour.compound());
		System.out.println("New Balance of Saving Account Four: " + SavAccountFour.getBal());
		System.out.println("\nAmount to Withdraw From Saving Account Two: " + SavAccountTwo.withd(1700.00));
		System.out.println("New Balance of Saving Account Two: " + SavAccountTwo.getBal());
		System.out.println("\nAmount to Withdraw From Saving Account Three: " + SavAccountThree.withd(9400.00));
		System.out.println("New Balance of Saving Account Three: " + SavAccountThree.getBal());
		
		//Begin testing for Checking Account methods
		System.out.println("\nBEGIN TESTING CHECKING ACCOUNTS\n");
		System.out.println("Initial Checking Account Informaiton:");
		System.out.println("\nChecking Account One\n" + CheckAccountOne);
		System.out.println("\nChecking Account Two\n" + CheckAccountTwo);
		System.out.println("\nChecking Account Three\n" + CheckAccountThree);
		System.out.println("\nChecking Account Four\n" + CheckAccountFour);
		System.out.println("\nChecking Account One Amount to Withdraw: " + CheckAccountOne.withd(1100.00));
		System.out.println("Checking Account One New Balance: " + CheckAccountOne.getBal());
		System.out.println("\nChecking Account Three Amount to Withdraw: " + CheckAccountThree.withd(17500.00));
		System.out.println("Checking Account Three New Balance: " + CheckAccountThree.getBal());
		System.out.println("\nChecking Account Four Limit: " + CheckAccountFour.getLimit());
		System.out.println("Checking Account Four Charge: " + CheckAccountFour.getCharge());

	}

}
