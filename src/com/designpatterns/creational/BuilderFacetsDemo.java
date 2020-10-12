package com.designpatterns.creational;

public class BuilderFacetsDemo {

	public static void main(String[] args) {
		final PersonBuilder2 pb = new PersonBuilder2();
		Person2 person = pb
				.lives()
					.streetAddress("JP nagar")
					.inCity("Bengaluru")
					.postcode("560000")
				.works()
					.worksAt("ISRO")
					.position("Engineer")
					.withAnnualIncome(123000)
				.build();
		System.out.println(person);
	}
}

class Person2 {
	public String streetAddress, postcode, city;

	public String companyName, position;
	public int annualIncome;

	@Override
	public String toString() {
		return "Person2{" + "streetAddress='" + streetAddress + '\'' + ", postcode='" + postcode + '\'' + ", city='"
				+ city + '\'' + ", companyName='" + companyName + '\'' + ", position='" + position + '\''
				+ ", annualIncome=" + annualIncome + '}';
	}
}

class PersonBuilder2 {
	protected Person2 person = new Person2();

	public PersonJobBuilder works() {
		return new PersonJobBuilder();
	}

	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder();
	}

	public Person2 build() {
		return person;
	}

}

class PersonJobBuilder extends PersonBuilder2 {
	

	public PersonJobBuilder worksAt(final String company) {
		person.companyName = company;
		return this;
	}

	public PersonJobBuilder position(final String position) {
		person.position = position;
		return this;
	}

	public PersonJobBuilder withAnnualIncome(final int annualIncome) {
		person.annualIncome = annualIncome;
		return this;
	}
}

class PersonAddressBuilder extends PersonBuilder2 {

	public PersonAddressBuilder streetAddress(final String streetAddress) {
		person.streetAddress = streetAddress;
		return this;
	}

	public PersonAddressBuilder postcode(final String postcode) {
		person.postcode = postcode;
		return this;
	}

	public PersonAddressBuilder inCity(final String city) {
		person.city = city;
		return this;
	}
}
