import java.util.Scanner;

public class Account {

	String firstName;
	String lastName;
	String accountNumber;
	int pin;
	double checkingBalance;
	double savingsBalance;
	
	public Account(String firstName, String lastName, String accountNumber, int pin, double checkingBalance, double savingsBalance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		
	}
	
	public void withdraw(double withdrawal, Scanner sc) {
		
		System.out.println("\n1) Checking");
		System.out.println("2) Savings");
		
		int option = sc.nextInt();
	
		if (option == 1) {
			if (this.checkingBalance >= withdrawal) {
				this.checkingBalance -= withdrawal;
				checkBalance();
				} else {
					System.out.println("ERROR: Withdrawal exceeds balance.");
				}
		}
		if (option == 2) {
			if (this.savingsBalance >= withdrawal) {
				this.savingsBalance -= withdrawal;
				checkBalance();
				} else {
					System.out.println("ERROR: Withdrawal exceeds balance.");
				}
		}
		if (option != 1 && option != 2) {
			System.out.println("ERROR: Please select a valid option.");
		}
	}
	
	public void deposit(double deposit, Scanner sc) {
			
			System.out.println("\n1) Checking");
			System.out.println("2) Savings");
			
			int option = sc.nextInt();
		
			if (option == 1) {
					this.checkingBalance += deposit;
					checkBalance();
			}
			if (option == 2) {
					this.savingsBalance += deposit;
					checkBalance();
			}
			if (option != 1 && option != 2) {
				System.out.println("ERROR: Please select a valid option.");
			}
	}
		
	public void checkBalance() {
		System.out.println("Balance Inquiry");
		System.out.println(returnAcctNumber());
		System.out.printf("Checking $%,-15.2f\n", this.checkingBalance);
		System.out.printf("Savings $%,-15.2f\n", this.savingsBalance);
		
	}
	
	public String returnAcctNumber() {
		return ("*".repeat(12) + this.accountNumber.substring(12));
	}
	
	public void fastCash(double withdrawal, Scanner sc) {
			if (this.checkingBalance >= withdrawal) {
				this.checkingBalance -= withdrawal;
				checkBalance();
				} else {
					System.out.println("ERROR: Withdrawal exceeds balance.");
				}
	}
}

