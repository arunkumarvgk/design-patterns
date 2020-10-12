package com.designpatterns.creational.singleton;

public class StaticSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class SingletonStatic {
	private static SingletonStatic instance;
	
	private SingletonStatic() throws Exception {
		throw new Exception("For some reason");
	}
	
	static {
		try {
			instance = new SingletonStatic();
		} catch (final Exception e) {
			System.err.println(e);
		}
	}

	public static SingletonStatic getInstance() {
		return instance;
	}
}
