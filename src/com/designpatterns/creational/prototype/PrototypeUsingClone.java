package com.designpatterns.creational.prototype;

import java.util.Arrays;

public class PrototypeUsingClone {

	public static void main(String[] args) {
		
		/* Ramesh Gupta , Suresh Gupta and Mahesh Gupta are brothers and 
		 * they live next to each other stay in same city 
		 * Here we can we can use existing object 
		 * */
		final Person ramesh = new Person(new String[] {"Ramesh", "Gupta"}, 
				"Hari Gupta", 
				"Lakshmi Gupta",
				new Address(123, "Mumbai", "Maharastra", "India"));
		
		final Person suresh = (Person) ramesh.clone();
		final Person mahesh = (Person) ramesh.clone();
		
		
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

class Person {
	String names[];
	Address address;
	String fatherName;
	String motherName;
	
	public Person(final String[] names, final String fatherName, final String motherName, final Address address) {
		super();
		this.names = names;
		this.address = address;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "Person [names=" + Arrays.toString(names) + ", address=" + address + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + "]";
	}
	
	@Override
	public Object clone() {
		return new Person(names.clone(), fatherName, motherName, (Address) address.clone());
	}
}

class Address implements Cloneable {
	int streetNo;
	String city;
	String state;
	String country;

	public Address(final int streetNo, final String city, final String state, final String country) {
		super();
		this.streetNo = streetNo;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	
	@Override
	public Object clone() {
		return new Address(streetNo, city, state, country);
	}
}
