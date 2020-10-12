package com.designpatterns.creational.prototype;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.lang3.SerializationUtils;

public class PrototypeUsingSerialization {

	public static void main(String[] args) {
		/* Ramesh Gupta , Suresh Gupta and Mahesh Gupta are brothers and 
		 * they live next to each other stay in same city 
		 * Here we can we can use existing object 
		 * */
		final Person2 ramesh = new Person2(new String[] {"Ramesh", "Gupta"}, 
				"Hari Gupta", 
				"Lakshmi Gupta",
				new Address2(123, "Mumbai", "Maharastra", "India"));
		
		final Person2 suresh = SerializationUtils.roundtrip(ramesh);
		final Person2 mahesh = SerializationUtils.roundtrip(ramesh);
		
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

class Person2 implements Serializable {

	private static final long serialVersionUID = 4541430803450736961L;

	String names[];
	Address2 address;
	String fatherName;
	String motherName;
	
	public Person2(final String[] names, final String fatherName, final String motherName, final Address2 address) {
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
}

class Address2 implements Serializable {

	private static final long serialVersionUID = -4807182429085407267L;
	
	int streetNo;
	String city;
	String state;
	String country;

	public Address2(final int streetNo, final String city, final String state, final String country) {
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
}

