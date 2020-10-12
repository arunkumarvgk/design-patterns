package com.designpatterns.solidprinciples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OpenClosedDemo {
	public static void main(String[] args) {
		final Product p1 = new Product("T-Shirt 1", 100, Color.RED, Size.SMALL);
		final Product p2 = new Product("T-Shirt 2", 130, Color.GREEN, Size.MEDIUM);
		final Product p3 = new Product("T-Shirt 3", 120, Color.GREEN, Size.SMALL);
		final Product p4 = new Product("T-Shirt 4", 200, Color.YELLOW, Size.LARGE);
		final Product p5 = new Product("T-Shirt 5", 400, Color.BLUE, Size.LARGE);
		final Product p6 = new Product("T-Shirt 6", 80, Color.YELLOW, Size.MEDIUM);

		final List<Product> products = Arrays.asList(p1, p2, p3, p4, p5, p6);
		System.out.println("All Products");
		products.stream().forEach(p -> System.out.println(p.toString()));
		
		// Old way of filtering
		final ProductFilter pf = new ProductFilter();
		System.out.println("\nFilter by color RED");
		pf.filterByColor(products, Color.RED).forEach(p -> System.out.println(p.toString()));
		System.out.println("\nFilter by size Large");
		pf.filterBySize(products, Size.LARGE).forEach(p -> System.out.println(p.toString()));
		System.out.println("\nFilter by price > 150");
		pf.priceGreaterThan(products, 150).forEach(p -> System.out.println(p.toString()));
		
		// If we have to add more filters we need to modify Product Filter which is not correct and is Anti Pattern
		// New extention was of filtering
		final NewFilter<Product> filter = new NewFilter<Product>();
		System.out.println("\nFilter by color RED");
		filter.filter(products, new ColorSpecification(Color.RED)).forEach(p -> System.out.println(p.toString()));
		System.out.println("\nFilter by size Large");
		filter.filter(products, new SizeSpecification(Size.LARGE)).forEach(p -> System.out.println(p.toString()));
		
		System.out.println("Filter by price <100");
		filter.filter(products, (p) -> p.getPrice() < 100).forEach(p -> System.out.println(p.toString()));
	}
}

enum Color {
	RED, BLUE, GREEN, YELLOW;
}

enum Size {
	SMALL, MEDIUM, LARGE;
}

final class Product {
	private final String name;
	private final float price;
	private final Color color;
	private final Size size;

	public Product(String name, float price, Color color, Size size) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public Color getColor() {
		return color;
	}

	public Size getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return name+" : "+price+" : "+color.name()+" : "+size.name();
	}
}

/**
 * Here in this class everytime we need to add a new filter we have to modify
 * product filter class
 */
final class ProductFilter {
	public Stream<Product> filterByColor(final List<Product> products, final Color color) {
		return products.stream().filter(p -> p.getColor() == color);
	}

	public Stream<Product> filterBySize(final List<Product> products, final Size size) {
		return products.stream().filter(p -> p.getSize() == size);
	}

	public Stream<Product> priceGreaterThan(final List<Product> products, final int price) {
		return products.stream().filter(p -> p.getPrice() > price);
	}
}

interface Specification<T> {
	boolean isSatisfied(T t);
}

interface Filter<T> {
	Stream<T> filter(List<T> list, Specification<T> spec);
}

/**
 * Color specification
 */
final class ColorSpecification implements Specification<Product> {
	private final Color color;

	public ColorSpecification(final Color color) {
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product t) {
		return this.color == t.getColor();
	}
}

/**
 * Size Spacification
 *
 */
final class SizeSpecification implements Specification<Product> {

	private final Size size;

	public SizeSpecification(final Size size) {
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product t) {
		return this.size == t.getSize();
	}
}


/**
 * Common filter class for all filters
 */
final class NewFilter<T> implements Filter<T> {

	@Override
	public Stream<T> filter(List<T> list, Specification<T> spec) {
		return list.stream().filter(p -> spec.isSatisfied(p));
	}
}
