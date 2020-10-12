package com.designpatterns.creational.prototype;

import java.util.Arrays;

public class PrototypeUsingCopyCons {

	public static void main(String[] args) {
		/* Ramesh Gupta , Suresh Gupta and Mahesh Gupta are brothers and 
		 * they live next to each other stay in same city 
		 * Here we can we can use existing object 
		 * */
		final Person1 ramesh = new Person1(new String[] {"Ramesh", "Gupta"}, 
				"Hari Gupta", 
				"Lakshmi Gupta",
				new Address1(123, "Mumbai", "Maharastra", "India"));
		
		final Person1 suresh = new Person1(ramesh);
		final Person1 mahesh = new Person1(ramesh);
		
		
		System.out.println(ramesh);
		System.out.println(suresh);
		System.out.println(mahesh);
		
		suresh.names[0] = "Suresh";
		suresh.address.streetNo = 124;

		mahesh.names[0] = "Mahesh";
		mahesh.address.streetNo = 125;
		
		System.out.println("____________After______________");
		System.out.println(ramesh);
		System.out.println(suresh);
		System.out.println(mahesh);
	}

}

class Person1 {
	String names[];
	Address1 address;
	String fatherName;
	String motherName;
	
	public Person1(final String[] names, final String fatherName, final String motherName, final Address1 address) {
		super();
		this.names = names;
		this.address = address;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	public Person1(final Person1 person) {
		this(person.names, person.fatherName, person.motherName, new Address1(person.address));
	}
	
	@Override
	public String toString() {
		return "Person [names=" + Arrays.toString(names) + ", address=" + address + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + "]";
	}
}

class Address1 {
	int streetNo;
	String city;
	String state;
	String country;

	public Address1(final int streetNo, final String city, final String state, final String country) {
		super();
		this.streetNo = streetNo;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Address1(final Address1 address) {
		this(address.streetNo, address.city, address.state, address.country);
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
}
