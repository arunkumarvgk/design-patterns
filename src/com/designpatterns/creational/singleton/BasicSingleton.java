package com.designpatterns.creational.singleton;

public class BasicSingleton {

	public static void main(String[] args) {
		final Singleton sa = Singleton.getInstance();
		System.out.println(sa.getMessage());
	}
}

class Singleton {
	private static Singleton INSTANCE = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return INSTANCE;
	}
	
	public String getMessage() {
		return "Hello from singleton class";
	}
}
