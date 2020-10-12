package com.designpatterns.creational;

public class FactoryMethodDemo {

	public static void main(String[] args) {
		final Point cartisianPoint = Point.Factory.newCartisianPoint(10, 20);
		final Point polarPoint  = Point.Factory.newPolarPoint(2,  3);
		
		System.out.println(cartisianPoint);
		System.out.println(polarPoint);
	}

}

class Point {
	private double x;
	private double y;

	private Point(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

	static class Factory {
		public static Point newCartisianPoint(final double x, final double y) {
			return new Point(x, y);
		}

		public static Point newPolarPoint(final double rho, final double theta) {
			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}
	}
	
	@Override
	public String toString() {
		return "Point x: "+x+", y: "+y;
	}
}