package com.designpatterns.creational;

import java.util.Objects;

// Fluent Builder
public class BuilderPatternDemo {

	public static void main(String[] args) {
		final BankAccount bankAccount = new BankAccount.BankAccountBuilder("Sachin", AccountType.SAVINGS).build();
		System.out.println(bankAccount.toString());

		final BankAccount bankAccount2 = new BankAccount.BankAccountBuilder("Dravid", AccountType.CURRENT)
				.setPanNo(1234567890)
				.setCity("Bengaluru")
				.setState("Karnataka")
				.setCountry("India")
				.build();
		System.out.println(bankAccount2.toString());
	}
}

enum AccountType {
	SAVINGS, CURRENT
}

class BankAccount {
	private final String name;
	private final AccountType accountType;
	private int panNo;
	private String city;
	private String state;
	private String country;

	private BankAccount(String name, AccountType accountType) {
		super();
		this.name = name;
		this.accountType = accountType;
	}

	private BankAccount(String name, AccountType accountType, int panNo, String city, String state, String country) {
		super();
		this.name = name;
		this.accountType = accountType;
		this.panNo = panNo;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public int getPanNo() {
		return panNo;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("[ ");
		sb.append("Name :").append(name);
		sb.append(" | Account Type: ").append(accountType);
		
		if (panNo != 0) {
			sb.append(" | Pan No: ").append(panNo);
		}
		
		if (Objects.nonNull(city)) {
			sb.append(" | City: ").append(city);
		}
		
		if (Objects.nonNull(state)) {
			sb.append(" | State: ").append(state);
		}
		
		if (Objects.nonNull(country)) {
			sb.append(" | Country: ").append(country);
		}
		
		sb.append(" ]");
		return sb.toString();
	}

	static class BankAccountBuilder {
		private String name;
		private AccountType accountType;
		private int panNo;
		private String city;
		private String state;
		private String country;

		public BankAccountBuilder(final String name, final AccountType accountType) {
			this.name = name;
			this.accountType = accountType;
		}

		public BankAccountBuilder setPanNo(final int panNo) {
			this.panNo = panNo;
			return this;
		}

		public BankAccountBuilder setCity(final String city) {
			this.city = city;
			return this;
		}

		public BankAccountBuilder setState(final String state) {
			this.state = state;
			return this;
		}

		public BankAccountBuilder setCountry(final String country) {
			this.country = country;
			return this;
		}
		
		public BankAccount build() {
			return new BankAccount(name, accountType, panNo, city, state, country);
		}
	}
}
