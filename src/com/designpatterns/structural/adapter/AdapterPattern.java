package com.designpatterns.structural.adapter;

public class AdapterPattern {

	public static void main(String[] args) {
		final Movable movable = new Mahindra();
		final MovableAdapter adapter = new MovableAdapterImpl(movable);
		System.out.println(adapter.getSpeed());
	}

}

// Returns speed in MH
interface Movable {
	int getSpeed();
}

class Maruti implements Movable {
	@Override
	public int getSpeed() {
		return 80;
	}
}

class Tata implements Movable {
	@Override
	public int getSpeed() {
		return 90;
	}
}

class Mahindra implements Movable {
	@Override
	public int getSpeed() {
		return 95;
	}
}

interface MovableAdapter {
	int getSpeed();
}

class MovableAdapterImpl implements MovableAdapter {
	private final Movable movable;
	
	public MovableAdapterImpl(final Movable movable) {
		this.movable = movable;
	}

	@Override
	public int getSpeed() {
		return (int) (movable.getSpeed() * 1.62);
	}
}



