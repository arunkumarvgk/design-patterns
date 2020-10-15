package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositePattern {

	public static void main(String[] args) {
		final Box box = new Box();
		box.addProduct(new Product1());
		box.addProduct(new Product2());
		box.addProduct(() -> 30);
		box.addProduct(() -> 50);
		System.out.println(box.getPrice());
		
		System.out.println("-----------------------------------------");
		
		final HeadDepartment department = new HeadDepartment();
		department.addDepartment(() -> "Civil");
		department.addDepartment(new ECDepartment());
		department.addDepartment(new CSDepartment());
		System.out.println(department.getDepartementName());

	}

}

// First example
// Product (Scalar/Individual) and Box (Composite)
// Both implement same interface
interface Product {
	int getPrice();
}

class Product1 implements Product {
	@Override
	public int getPrice() {
		return 20;
	}
}

class Product2 implements Product {
	@Override
	public int getPrice() {
		return 20;
	}
}

class Box implements Product {
	final private List<Product> products = new ArrayList<>();
	
	@Override
	public int getPrice() {
		return products.stream().map(p -> p.getPrice()).collect(Collectors.summingInt(p -> p));
	}
	
	public void addProduct(final Product product) {
		this.products.add(product);
	}

	public void removeProduct(final Product product) {
		this.products.remove(product);
	}
}

//First example
//Department (Scalar/Individual) and HeadDepartment (Composite)
//Both implement same interface
interface Department {
	String getDepartementName();
}

class CSDepartment implements Department {
	@Override
	public String getDepartementName() {
		return "Computer Science";
	}
}

class ECDepartment implements Department {
	@Override
	public String getDepartementName() {
		return "Electronic Science";
	}
}

class HeadDepartment implements Department {

	private final List<Department> departments = new ArrayList<>();

	@Override
	public String getDepartementName() {
		return departments.stream().map(d -> d.getDepartementName()).collect(Collectors.joining(", "));
	}

	public void addDepartment(final Department department) {
		this.departments.add(department);
	}

	public void removeDepartment(final Department department) {
		this.departments.remove(department);
	}
}
