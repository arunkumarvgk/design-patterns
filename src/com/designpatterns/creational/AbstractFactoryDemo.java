package com.designpatterns.creational;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		final CarFactory carFactory = CarFactoryProvider.getCarFactory(Location.INDIA);
		final Car car = carFactory.getCar(CarType.SEVENSEATER);
		System.out.println("Engine CC : "+car.getCC()+", Top Speed: "+car.getTopSpeed());
	}

}

enum CarType {
	TWOSEATER, FIVESEATER, SEVENSEATER;
}

interface Car {
	int getTopSpeed();
	int getCC();
}

final class TwoSeaterCar implements Car {
	@Override
	public int getTopSpeed() {
		return 100;
	}

	@Override
	public int getCC() {
		return 600;
	}
}

final class FiveSeaterCar implements Car {
	@Override
	public int getTopSpeed() {
		return 120;
	}

	@Override
	public int getCC() {
		return 1600;
	}
}

final class SevenSeaterCar implements Car {
	@Override
	public int getTopSpeed() {
		return 140;
	}

	@Override
	public int getCC() {
		return 2600;
	}
}

enum Location {
	INDIA, GERMANY
}

interface CarFactory {
	Car getCar(CarType carType);
}

final class IndiaCarFactory implements CarFactory {

	@Override
	public Car getCar(final CarType carType) {
		if (carType == CarType.TWOSEATER) {
			return new TwoSeaterCar();
		} else if (carType == CarType.FIVESEATER) {
			return new FiveSeaterCar();
		} else if (carType == CarType.SEVENSEATER) {
			return new SevenSeaterCar();
		} 
		return null;
	}
}

final class GermanyCarFactory implements CarFactory {

	@Override
	public Car getCar(final CarType carType) {
		if (carType == CarType.TWOSEATER) {
			return new TwoSeaterCar();
		} else if (carType == CarType.FIVESEATER) {
			return new FiveSeaterCar();
		} else if (carType == CarType.SEVENSEATER) {
			return new SevenSeaterCar();
		} 
		return null;
	}
}

class CarFactoryProvider {
	public static CarFactory getCarFactory(final Location loc) {
		if (loc == Location.GERMANY) {
			return new GermanyCarFactory();
		} else if (loc == Location.INDIA) {
			return new IndiaCarFactory();
		}
		return null;
	}
}
