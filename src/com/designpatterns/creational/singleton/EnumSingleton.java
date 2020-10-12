package com.designpatterns.creational.singleton;

public class EnumSingleton {

	public static void main(String[] args) {
		 final SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
		 System.out.println(singletonEnum.getValue());
	}

}

// Cannot inherit and deserialize always re-initializes the value
enum SingletonEnum {
	INSTANCE;

	//Private by default
	SingletonEnum() {
		this.value = 23;
	}

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}