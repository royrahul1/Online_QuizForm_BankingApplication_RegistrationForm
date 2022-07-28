//package rahulroy;

import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount obj1 = new BankAccount("RAHUL KUMAR","A7845");
		obj1.showMenu();
	}
}

class BankAccount {
	int balance;
	int PreviousTransaction;
	String customerName;
	String customerId;
	
	 BankAccount(String cname,String cid){
		customerName = cname;
		customerId = cid;
	}
	
	void deposit(int amount) {
		if (amount != 0) {
		balance = balance + amount;
		PreviousTransaction = amount;			
		}
		
	}
	void withdraw(int amount) {
		if (amount != 0) {
		balance = balance + amount;
		PreviousTransaction = -amount;		
		}
	}
	void getPreviousTransaction() {
		if (PreviousTransaction > 0) {
			System.out.println("Deposited:"+PreviousTransaction);	
		}
		else if(PreviousTransaction < 0 ) {
			System.out.println("withdrawn:"+Math.abs(PreviousTransaction));	
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	void showMenu() {
		
		char option='\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome "+customerName);
		System.out.println("Your Id is "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Perivious transaction");
		System.out.println("E. Exit");
		do {
			System.out.println("=======================");
			System.out.println("Enter an option");
			System.out.println("=======================");
			option = sc.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'A':
				System.out.println("=======================");
				System.out.println("Balance = "+balance);
				System.out.println("=======================");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("=======================");
				System.out.println("Enter the amount to deposits:");
				System.out.println("=======================");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("=======================");
				System.out.println("Enter the amount to withdraw:");
				System.out.println("=======================");
				int amount2 = sc.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("=======================");
				getPreviousTransaction();
				System.out.println("=======================");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("=======================");
				break;
				
				default:
					System.out.println("Invalid option !!.Please enter again");
					break;
			}
		}
		  while(option !='E');
		System.out.println("Thank You for using our services");
	}
}
	
