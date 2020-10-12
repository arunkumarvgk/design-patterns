package com.designpatterns.creational.singleton;

public class ThreadSafeLazySingleton {

	public static void main(String[] args) {
		final SingletonLazyThreadSafe sa = SingletonLazyThreadSafe.getInstance();
		System.out.println(sa.getMessage());
	}
}

class SingletonLazyThreadSafe {
	private static SingletonLazyThreadSafe INSTANCE;
	
	private SingletonLazyThreadSafe() {}
	
	public static synchronized SingletonLazyThreadSafe getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonLazyThreadSafe();
		}
		return INSTANCE;
	}
	
	// Double Checking 
	public static SingletonLazyThreadSafe getInstanceInGoodTime() {
		if (INSTANCE == null) {
			synchronized (SingletonLazyThreadSafe.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonLazyThreadSafe();
				}
			}
		}
		return INSTANCE;
	}
	
	public String getMessage() {
		return "Hello from singleton class";
	}
}
