package com.designpatterns.structural.decorator;

public class ShapeDecorator {

	public static void main(String[] args) {
		final Shape square = new Square();
		final Shape traingle = new Traingle();
		
		final ColoredShapeDecorator redSquare = new ColoredShapeDecorator(square, "Red");
		final ColoredShapeDecorator greenTraingle = new ColoredShapeDecorator(traingle, "Green");
		
		System.out.println(redSquare.getInfo());
		System.out.println(greenTraingle.getInfo());
	}

}

interface Shape {
	String getInfo();
}

class Square implements Shape {
	@Override
	public String getInfo() {
		return "Its a Square";
	}
}

class Traingle implements Shape {
	@Override
	public String getInfo() {
		return "Its a Traingle";
	}
}

// Now we wanted to add color to shape but we are not allowed to modify it open closed princliple
// so we add decorator
class ColoredShapeDecorator implements Shape {
	private final Shape shape;
	private final String color;
	
	public ColoredShapeDecorator(final Shape shape, final String color) {
		this.color = color;
		this.shape = shape;
	}

	@Override
	public String getInfo() {
		return shape.getInfo() + " "+ color +" colored";
	}
}