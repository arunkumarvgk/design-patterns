package com.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {

	public static void main(String[] args) {
		final Pen rpen = PenFactory.getThickPen("Red");
		final Pen gpen = PenFactory.getThinPen("Green");
		final Pen bpen = PenFactory.getMediumPen("Blue");
		
		final Pen rpen2 = PenFactory.getThickPen("Red");
		
		rpen.draw("Square");
		gpen.draw("Rectangle");
		bpen.draw("Square");
		rpen2.draw("Square");
		
		System.out.println(rpen == rpen2);
	}

}

class PenFactory {
	private static final Map<String, Pen> PEN_MAP = new HashMap<>();
	
	public static Pen getThinPen(final String color) {
		Pen pen = PEN_MAP.get(color+ "_thin");
		if (pen == null) {
			pen = new ThinPen(color);
			PEN_MAP.put(color+ "_thin", pen);
		}
		return pen;
	}
	
	public static Pen getThickPen(final String color) {
		Pen pen = PEN_MAP.get(color+ "_thick");
		if (pen == null) {
			pen = new ThickPen(color);
			PEN_MAP.put(color+ "_thick", pen);
		}
		return pen;
	}
	
	public static Pen getMediumPen(final String color) {
		Pen pen = PEN_MAP.get(color+ "_medium");
		if (pen == null) {
			pen = new MediumPen(color);
			PEN_MAP.put(color+ "_medium", pen);
		}
		return pen;
	}
}

interface Pen {
	public void draw(String content);
}


final class ThinPen implements Pen {
	private final String color;
	
	public ThinPen(final String color) {
		this.color = color;
	}
	
	@Override
	public void draw(final String content) {
		System.out.println("Drawning thin sized "+content +" in "+color);
	}
	
}

final class MediumPen implements Pen {
	private final String color;
	
	public MediumPen(final String color) {
		this.color = color;
	}
	
	@Override
	public void draw(final String content) {
		System.out.println("Drawning medium sized "+content +" in "+color);
	}
	
}

final class ThickPen implements Pen {
	private final String color;
	
	public ThickPen(final String color) {
		this.color = color;
	}
	
	@Override
	public void draw(final String content) {
		System.out.println("Drawning thick sized "+content +" in "+color);
	}
}
