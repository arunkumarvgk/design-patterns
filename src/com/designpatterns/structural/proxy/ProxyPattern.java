package com.designpatterns.structural.proxy;

import java.util.Objects;

public class ProxyPattern {

	public static void main(String[] args) {
		final ExpensiveObject expensiveObject = new ExpensiveObjectImpl();
		expensiveObject.process();
		
		// From the second call uses existing instance
		expensiveObject.process();
	}

}

interface ExpensiveObject {
	void process();
}

/* Expensive object so created only on demand */
class ExpensiveObjectImpl implements ExpensiveObject {

	public ExpensiveObjectImpl() {
		System.out.println("Expensive object created");
	}

	@Override
	public void process() {
		System.out.println("Processing");
	}
}

/* Proxy Object acts as protection for original object */
class ExpensiveObjectProxy implements ExpensiveObject {
	private static ExpensiveObject expensiveObject;
	
	@Override
	public void process() {
		if (Objects.isNull(expensiveObject)) {
			expensiveObject = new ExpensiveObjectImpl();
		}
		expensiveObject.process();
	}
}
