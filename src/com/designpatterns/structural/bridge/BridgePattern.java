package com.designpatterns.structural.bridge;

public class BridgePattern {

	public static void main(String[] args) {
		final Shape shape = new Square(new Red());
		System.out.println(shape.draw());
		
		// Anonymous implementation for square
		System.out.println(new Square(() -> "Green").draw());
	}

}

/*
 * Instead of making RedSquare, GreenSquare, RedCircle, GreenCircle soon..
 * We had to do above as we had two dimensions Color and Form
 * 
 * With Bridge Pattern we can extract on dimension and make it a separate hierarchy(The color interface)
 * Change the inheritance to composition 
 * Shape becomes abstract class and has color object in it.
 * 
 * Bridge pattern has 2 parts (1) Abstraction (2) Implementation
 */
interface Color {
	String getColor();
}

class Red implements Color {
	@Override
	public String getColor() {
		return "Red";
	}
}

abstract class Shape {
	protected Color color;

	abstract String draw();
}

class Square extends Shape {
	private final Color color;

	public Square(final Color color) {
		this.color = color;
	}

	@Override
	public String draw() {
		return "Square drawn in "+color.getColor();
	}
}