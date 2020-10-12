package com.designpatterns.creational.factory;

public class CodeBuilderDemo {

	public static void main(String[] args) {
		System.out.println(new CodeBuilder("Person").addField("age", "int").addField("name", "String"));
	}

}

class CodeBuilder {
	private StringBuilder sb = new StringBuilder();

	public CodeBuilder(String className) {
		sb.append("public class ").append(className).append(System.lineSeparator()).append("{")
				.append(System.lineSeparator());
	}

	public CodeBuilder addField(String name, String type) {
		sb.append("  ").append("public ").append(type).append(" ").append(name).append(";")
				.append(System.lineSeparator());
		return this;
	}

	@Override
	public String toString() {
		sb.append("}");
		return sb.toString();
	}
}