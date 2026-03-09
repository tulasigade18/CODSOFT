package Internship;

import java.util.Scanner;

class BankAccount {
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposit Successful!");
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient Balance!");
		} else {
			balance -= amount;
			System.out.println("Withdrawal Successful!");
		}
	}
}

class ATM {
	private BankAccount account;
	private Scanner sc = new Scanner(System.in);

	public ATM(BankAccount account) {
		this.account = account;
	}

	public void start() {
		while (true) {
			System.out.println("**** ATM MENU ****");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			System.out.print("Choose option: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Current Balance: " + account.getBalance());
				break;

			case 2:
				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();
				if (depositAmount > 0)
					account.deposit(depositAmount);
				else
					System.out.println("Invalid amount!");
				break;

			case 3:
				System.out.print("Enter withdraw amount: ");
				double withdrawAmount = sc.nextDouble();
				if (withdrawAmount > 0)
					account.withdraw(withdrawAmount);
				else
					System.out.println("Invalid amount!");
				break;

			case 4:
				System.out.println("Thank you for using ATM!");
				return;

			default:
				System.out.println("Invalid option!");
			}
		}
	}
}

public class ATMInterface {
	public static void main(String[] args) {
		BankAccount userAccount = new BankAccount(1000); // initial balance
		ATM atm = new ATM(userAccount);
		atm.start();
	}

}
