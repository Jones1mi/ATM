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
		
		boolean found = false;
		int indexOfAcct = 0;
		
		for(int i = 0; i < accounts.length; i++) {
			if (acctNum.equals(accounts[i].accountNumber)) {
				found = true;
				indexOfAcct = i;
			}
		}
		
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
		
		System.out.println("\n1) Balance Inquiry");
		System.out.println("2) Withdrawal");
		System.out.println("3) Deposit");
		System.out.println("4) Fast Cash");
		System.out.println("5) Exit");
		
		System.out.print("\nPlease pick an option: ");
		option = sc.nextInt();
		System.out.println();
		
			switch(option) {
			
			case 1:
				
				accounts[indexOfAcct].checkBalance();
				
				option = shouldUserContinue(sc);
				break;
				
			case 2:
				
				System.out.print("Withdrawal: ");
				double withdrawal = sc.nextDouble();
				
				accounts[indexOfAcct].withdraw(withdrawal, sc);
				
				option = shouldUserContinue(sc);
				break;
				
			case 3:
				
				System.out.print("Deposit: ");
				double deposit = sc.nextDouble();
				
				accounts[indexOfAcct].deposit(deposit, sc);
				
				option = shouldUserContinue(sc);
				break;
				
			case 4:
				
				System.out.println("1) $20");
				System.out.println("2) $40");
				System.out.println("3) $100");
				
				option = sc.nextInt();
				
				if (option == 1) {
					accounts[indexOfAcct].fastCash(20, sc);
				}
				if (option == 2) {
					accounts[indexOfAcct].fastCash(40, sc);
				}
				if (option == 3) {
					accounts[indexOfAcct].fastCash(100, sc);
				}
				
				option = shouldUserContinue(sc);
				
				break;
				
			case 5:
				
				System.out.println("Thank you for your patronage.");
				break;
				
			default:
				
				System.out.println("Please enter a valid option.");
				break;
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
	
	public static int shouldUserContinue (Scanner sc) {
		
		System.out.println("\nDo you wish to make another transaction?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		
		int option = sc.nextInt();
		
		if (option == 1) {
			return 1;
		} else if (option == 2) {
			return 5;
		} else {
			return 1;
		}
	}
}
