package com.designpatterns.creational.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SingletonTesting {

	public static void main(String[] args) {
		// This makes a DB call and becomes a integration test.
		final CityFinder cityFinder = new CityFinder();
		cityFinder.findCitiesNameStartsWith("B").forEach(System.out::println);

		// Solution is with Dependency inversion principle
		// Inject dependency via constructor
		final CityFinderDI cityFinderDI = new CityFinderDI(SingletonCityFinderDI.getInstance());
		cityFinderDI.findCitiesNameStartsWith("B").forEach(System.out::println);

		// In case of unit testing we can pass the dummy implementation
		final CityFinderDI cityFinderTest = new CityFinderDI(() -> Arrays.asList("Delhi", "Patna", "Madurai", "Chithoor"));
		assert(cityFinderTest.findCitiesNameStartsWith("M").findFirst().get().equals("Madurai"));
	}

}

class SingletonCityFinder {
	private static final SingletonCityFinder INSTANCE = new SingletonCityFinder();
	private List<String> cities = new ArrayList<>();

	private SingletonCityFinder() {
		// Get Cities from Database
		cities = getCitiesFromDB();
	}

	public static SingletonCityFinder getInstance() {
		return INSTANCE;
	}

	public List<String> getCities() {
		return cities;
	}

	private List<String> getCitiesFromDB() {
		// Consider this is return from a db call
		return Arrays.asList("Bengaluru", "Capetown", "Auckland", "Sydney", "Bali");
	}
}

class CityFinder {
	final SingletonCityFinder singletonCityFinder = SingletonCityFinder.getInstance();

	public Stream<String> findCitiesNameStartsWith(final String name) {
		return singletonCityFinder.getCities().stream().filter(c -> c.startsWith(name));
	}

	public Stream<String> findCitiesNameEndsWith(final String name) {
		return singletonCityFinder.getCities().stream().filter(c -> c.endsWith(name));
	}
}

interface City {
	List<String> getCities();
}

// We implement city
class SingletonCityFinderDI implements City {
	private static final SingletonCityFinderDI INSTANCE = new SingletonCityFinderDI();
	private List<String> cities = new ArrayList<>();

	private SingletonCityFinderDI() {
		// Get Cities from Database
		cities = getCitiesFromDB();
	}

	public static SingletonCityFinderDI getInstance() {
		return INSTANCE;
	}

	public List<String> getCities() {
		return cities;
	}

	private List<String> getCitiesFromDB() {
		// Consider this is return from a db call
		return Arrays.asList("Bengaluru", "Capetown", "Auckland", "Sydney", "Bali");
	}
}

// CityFinder dependends on Abstraction not directly on low level class
class CityFinderDI {
	private final City city;

	public CityFinderDI(final City city) {
		this.city = city;
	}

	public Stream<String> findCitiesNameStartsWith(final String name) {
		return city.getCities().stream().filter(c -> c.startsWith(name));
	}

	public Stream<String> findCitiesNameEndsWith(final String name) {
		return city.getCities().stream().filter(c -> c.endsWith(name));
	}
}
