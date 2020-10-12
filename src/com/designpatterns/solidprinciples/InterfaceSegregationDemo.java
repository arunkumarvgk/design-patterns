package com.designpatterns.solidprinciples;

public class InterfaceSegregationDemo {
	public static void main(String[] args) {}
}

final class Document {
}

interface Machine {
	void print(Document doc);

	void scan(Document doc);

	void fax(Document doc);
}

class ModernMachine implements Machine {

	@Override
	public void print(Document doc) {
	}

	@Override
	public void scan(Document doc) {
	}

	@Override
	public void fax(Document doc) {
	}

}

/* Old Machines can only print they can't scan or fax the document */
class OldMachine implements Machine {

	@Override
	public void print(Document doc) {
	}

	@Override
	public void scan(Document doc) {
	}

	@Override
	public void fax(Document doc) {
	}
}

/*
 * The Solution is to Segregate the interface into multiple smaller interfaces.
 */
interface Printer {
	void print(Document doc);
}

interface Scanner {
	void scan(Document doc);
}

interface Fax {
	void fax(Document doc);
}

interface MultiModeMachine extends Printer, Scanner, Fax {
}

/* Old age machines can only print */
class OldAgeMachine implements Printer {
	@Override
	public void print(Document doc) {
	}
}

/* Middle age machines can only print and Scan */
class MiddleAgeMachine implements Printer, Scanner {
	@Override
	public void print(Document doc) {
	}

	@Override
	public void scan(Document doc) {
	}
}

/* Modern age machines can only print, Scan and Fax */
class ModernAgeMachine implements MultiModeMachine {
	@Override
	public void print(Document doc) {
	}

	@Override
	public void scan(Document doc) {
	}

	@Override
	public void fax(Document doc) {
	}
}
