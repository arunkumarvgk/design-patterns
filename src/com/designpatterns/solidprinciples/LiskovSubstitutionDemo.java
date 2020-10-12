package com.designpatterns.solidprinciples;

public class LiskovSubstitutionDemo {

	public static void main(String[] args) {
		final Rectangle rect = ObjectFactory.getInstance();
		rect.setHeight(10);
		rect.setWidth(9);

		// We expect it to be 90 but it is 81 since 
		// Square class changes the behavior of rectangle
		System.out.println(rect.getArea());
		
		final Quadrilateral qurad = new SquareLSP();
		qurad.setHeight(9);
		
		// Returns 81 
		System.out.println(qurad.getArea());
		
		final Quadrilateral rect2 = new RectangleLSP();
		rect2.setHeight(9);
		rect2.setHeight(10);
		
		// Returns 90
		System.out.println(rect2.getArea());
	}

}

class Rectangle {
	int height;
	int width;
	
	public int getArea() {
		return height * width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}

class Square extends Rectangle {
	@Override
	public int getArea() {
		return height * width;
	}

	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}

	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}
}

class ObjectFactory {
	public static Rectangle getInstance() {
		return new Square();
	}
}

class Quadrilateral {
	int height;
	int width;
	
	public int getArea() {
		return height * width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}

class RectangleLSP extends Quadrilateral { }

class SquareLSP extends Quadrilateral {
	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}

	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}
}

class ObjectFactoryLSP {
	public static Quadrilateral getInstance() {
		return new SquareLSP();
	}
}
