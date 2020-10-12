package com.designpatterns.creational.singleton;

class StaticInnerClassSingleton {

	private StaticInnerClassSingleton() {}
	
	public static class Impl {
		private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
	}
	public static StaticInnerClassSingleton getInstance() {
		return Impl.INSTANCE;
	}
	
	public String getMessage() {
		return "Hello from singleton class";
	}
}