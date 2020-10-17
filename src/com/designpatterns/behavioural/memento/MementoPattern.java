package com.designpatterns.behavioural.memento;

public class MementoPattern {

	// Caretaker who performs action in originator
	public static void main(String[] args) {
		final BankAccount account = new BankAccount();
		final BankAccountMemento memento1 = account.setBalance(100);

		System.out.println(account.getBalance());
		// Add 200
		final BankAccountMemento memento2 = account.deposite(200);
		System.out.println(account.getBalance());

		// Add 200
		final BankAccountMemento memento3 = account.deposite(240);
		System.out.println(account.getBalance());
		
		//Roll back last transaction to memento 2.
		account.restore(memento2);
		
		//Similarly we can roll back to diff mementos

	}

}

// Memento which stores the current state
final class BankAccountMemento {
	private final int balance;

	public BankAccountMemento(final int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
}

// Originator which knows how to perform store and restore
class BankAccount {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public BankAccountMemento setBalance(final int balance) {
		this.balance = balance;
		return new BankAccountMemento(balance);
	}

	public BankAccountMemento deposite(final int amount) {
		balance += amount;
		return new BankAccountMemento(balance);
	}

	public void restore(final BankAccountMemento memento) {
		balance = memento.getBalance();
	}
}