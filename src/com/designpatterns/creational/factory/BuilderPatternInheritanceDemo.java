package com.designpatterns.creational.factory;

public class BuilderPatternInheritanceDemo {

	public static void main(String[] args) {
		final Person person = new EmployeeBuilder()
				.withName("Sachin")
				.withPosition("Batsman")
				.worksAt("BCCI")
				.build();
		System.out.println(person.toString());
	}

}

class Person {
	public String name;
	public String position;
	public String company;

	@Override
	public String toString() {
		return "Person {" + "name=" + name +", position=" + position+" company="+company+"}";
	}
}

class PersonBuilder<T extends PersonBuilder<T>> {
	protected Person person = new Person();

	public T withName(final String name) {
		person.name = name;
		return self();
	}

	public T withPosition(final String pos) {
		person.position = pos;
		return self();
	}

	public Person build() {
		return person;
	}

	@SuppressWarnings("unchecked")
	protected T self() {
		return (T) this;
	}
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
	public EmployeeBuilder worksAt(final String company) {
		person.company = company;
		return self();
	}

	@Override
	protected EmployeeBuilder self() {
		return this;
	}
}
