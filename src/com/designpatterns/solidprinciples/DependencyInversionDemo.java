package com.designpatterns.solidprinciples;

public class DependencyInversionDemo {

	public static void main(String[] args) {
		// Before
		final ElectricSwitch es = new ElectricSwitch(new LightBulb());
		System.out.println("LightBulb is ON : "+es.isOn());
		es.press();
		System.out.println("LightBulb is ON : "+es.isOn());
		
		//After
		final Switchable buldSwitchable = new Bulb();
		final Switch bulbSwitch = new ElectricSwitchNew(buldSwitchable);
		System.out.println("\n\nBulb is ON : "+bulbSwitch.isOn());
		bulbSwitch.press();
		System.out.println("Bulb is ON : "+bulbSwitch.isOn());
		
		//After
		final Switchable fanSwitchable = new Bulb();
		final Switch fanSwitch = new ElectricSwitchNew(fanSwitchable);
		System.out.println("\n\nFan is ON : "+fanSwitch.isOn());
		fanSwitch.press();
		System.out.println("Fan is ON : "+fanSwitch.isOn());
	}
}

class LightBulb {
	public void turnOn() {}

	public void turnOff() {}
}

/*
 * ElectricSwitch (High level module) is completely dependent on LightBulb(Low
 * Level Module) Instead both should depend on Abstraction
 */
class ElectricSwitch {
	private boolean isOn;
	private LightBulb lightBulb;

	public ElectricSwitch(LightBulb lightBulb) {
		this.lightBulb = lightBulb;
	}

	public boolean isOn() {
		return this.isOn;
	}

	public void press() {
		if (isOn) {
			lightBulb.turnOff();
		} else {
			lightBulb.turnOn();
		}
		isOn = !isOn;
	}
}

/* Solution is creating abstraction */

interface Switchable {
	void turnOn();

	void turnOff();
}

interface Switch {
	boolean isOn();

	void press();
}

class Bulb implements Switchable {
	@Override
	public void turnOn() {}
	@Override
	public void turnOff() {}
}

class Fan implements Switchable {
	@Override
	public void turnOn() {}
	@Override
	public void turnOff() {}
}

class ElectricSwitchNew implements Switch {

	private boolean isOn;
	private final Switchable switchable;

	public ElectricSwitchNew(final Switchable switchable) {
		this.switchable = switchable;
		this.isOn = false;
	}

	@Override
	public boolean isOn() {
		return isOn;
	}

	@Override
	public void press() {
		if (isOn) {
			switchable.turnOff();
		} else {
			switchable.turnOn();
		}

		isOn = !isOn;
	}
}