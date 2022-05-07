import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		Account [] accounts = new Account[10];
		
		File accountsFile = new File("Accts_ATM.txt");
		
		readInFromFile(accountsFile, accounts);
		
		System.out.print("Please enter your account number: ");
		String acctNum = sc.next();
		// how to access just one account's info? an if statement?
		
		boolean found = false;
		int indexOfAcct = 0;
		
		for(int i = 0; i < accounts.length; i++) {
			// this accesses the account as a whole, not just the acct number portion
			// what I put isn't correct, but is essentially the idea I'm trying to get at
			if (acctNum.equals(accounts[i].accountNumber)) {
				found = true;
				indexOfAcct = i;
			}
		}
			// limit to 4? separate boolean or same?
			if (found == true) {
				System.out.print("Please enter your PIN: ");
				int PIN = sc.nextInt();
					if (PIN != (accounts[indexOfAcct].pin)) {
						found = false;
						System.out.println("ERROR: Incorrect PIN.");
				}
			}
			
		int option = 0;
		
		if (found == true) {
			
		while (option != 5) {
		
		System.out.println("1) Balance Inquiry");
		System.out.println("2) Withdrawal");
		System.out.println("3) Deposit");
		System.out.println("4) Fast Cash");
		System.out.println("5) Exit");
		
		System.out.print("Please pick an option: ");
		option = sc.nextInt();
		System.out.println();
		
			switch(option) {
			
			// would have to have scope of i continue to here in order to access correct account?
			case 1:
				
				accounts[indexOfAcct].checkBalance();
				break;
			case 2:
				
				System.out.print("Withdrawal: ");
				double withdrawal = sc.nextDouble();
				
				accounts[indexOfAcct].withdraw(withdrawal, sc);
				break;
			case 3:
				// need cash or check ope
				System.out.println("1) Checking");
				System.out.println("2) Savings");
				
				option = sc.nextInt();
				
				if (option == 1) {
					System.out.print("Deposit: ");
					break;
				}
			}
		}
		}
	}
	public static void readInFromFile(File fileName, Account [] accounts) throws FileNotFoundException {
		Scanner sc = new Scanner(fileName);
		int counter = 0;
		while(sc.hasNextLine()) {
			String [] array = sc.nextLine().split(", ");
			Account newAccount = new Account(array[0], array [1], array [2], Integer.parseInt(array[3]), Double.parseDouble(array[4]), Double.parseDouble(array[5]));
			accounts[counter] = newAccount;
			counter++;
		}
	}
}
