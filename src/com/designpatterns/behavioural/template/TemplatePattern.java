package com.designpatterns.behavioural.template;

public class TemplatePattern {

	public static void main(String[] args) {
		new GlassHouseConstruction().build();
		System.out.println("==============================================================");
		new ConcreteHouseConstruction().build();
	}
}

abstract class HouseConstruction {
	
	abstract void constructWall();
	abstract void constructRoof();
	abstract void paint();
	
	public void constrctBase() {
		System.out.println("Base is common for all house construction, done with big stones ");
	}
	
	public void constructDoors() {
		System.out.println("Doors are common for all house construction (Wooden) ");
	}
	
	public void constructWindows() {
		System.out.println("Windows are common for all house construction (Wooden)");
	}
	
	public void build() {
		constrctBase();
		constructWall();
		constructDoors();
		constructWindows();
		constructRoof();
		paint();
	}
}

class ConcreteHouseConstruction extends HouseConstruction {
	@Override
	void constructWall() {
		System.out.println("Constructed with bricks");
	}

	@Override
	void constructRoof() {
		System.out.println("Constructed with 20MM Stones, Sand and Cement");
	}

	@Override
	void paint() {
		System.out.println("Can be painted with any color");
	}
}

class GlassHouseConstruction extends HouseConstruction {
	@Override
	void constructWall() {
		System.out.println("Constructed with toughend hard glass");
	}

	@Override
	void constructRoof() {
		System.out.println("Constructed with toughend glass and some wood");
	}

	@Override
	void paint() {
		System.out.println("No paint, its transperent");
	}
}