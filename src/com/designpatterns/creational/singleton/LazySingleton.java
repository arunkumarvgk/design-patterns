package com.designpatterns.creational.singleton;

public class LazySingleton {

	public static void main(String[] args) {
		final SingletonLazy sa = SingletonLazy.getInstance();
		System.out.println(sa.getMessage());
	}
}

class SingletonLazy {
	private static SingletonLazy INSTANCE;
	
	private SingletonLazy() {}
	
	public static SingletonLazy getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonLazy();
		}
		return INSTANCE;
	}
	
	public String getMessage() {
		return "Hello from singleton class";
	}
}
