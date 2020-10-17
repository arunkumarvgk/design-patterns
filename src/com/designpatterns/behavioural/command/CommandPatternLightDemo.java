package com.designpatterns.behavioural.command;

public class CommandPatternLightDemo {

	public static void main(String[] args) {
		// Receivers
		final Light livingRoomLight = new Light(100);
		final Light bedRoomLight = new Light(80);

		final Remote remote = new Remote();

		// Turn on living room light
		remote.setCommand(new LightOnCommand(livingRoomLight));
		remote.pressButton();
		System.out.println("Living room light is :: " + livingRoomLight.isOn());

		// Increase bright in living room light by 5 pts
		remote.setCommand(new LightIncreseBrightnessCommand(livingRoomLight, 5));
		remote.pressButton();
		System.out.println("Current brightness level in living room " + livingRoomLight.getCurrentBrightness());

		// Decrease bright in living room light by 5 pts
		remote.setCommand(new LightDecreseBrightnessCommand(livingRoomLight, 5));
		remote.pressButton();
		System.out.println("Current brightness level in living room " + livingRoomLight.getCurrentBrightness());

		// Turn on living room light
		remote.setCommand(new LightOffCommand(livingRoomLight));
		remote.pressButton();
		System.out.println("Living room light is :: " + livingRoomLight.isOn());

		System.out.println("=========================================================");

		// Turn on bed room light
		remote.setCommand(new LightOnCommand(bedRoomLight));
		remote.pressButton();
		System.out.println("bed room light is :: " + bedRoomLight.isOn());

		// Increase bright in bed room light by 5 pts
		remote.setCommand(new LightIncreseBrightnessCommand(bedRoomLight, 5));
		remote.pressButton();
		System.out.println("Current brightness level in bed room " + bedRoomLight.getCurrentBrightness());

		// Decrease bright in bed room light by 5 pts
		remote.setCommand(new LightDecreseBrightnessCommand(bedRoomLight, 5));
		remote.pressButton();
		System.out.println("Current brightness level in bed room " + bedRoomLight.getCurrentBrightness());

		// Turn on bed room light
		remote.setCommand(new LightOffCommand(bedRoomLight));
		remote.pressButton();
		System.out.println("bed room light is :: " + bedRoomLight.isOn());
	}

}

// Receiver who know what to perform
class Light {
	private int brightness;
	private boolean isOn;

	public Light(final int brightness) {
		super();
		this.brightness = brightness;
		this.isOn = false;
	}

	public void turnOn() {
		if (!this.isOn) {
			this.isOn = true;
		}
	}

	public void turnOff() {
		if (this.isOn) {
			this.isOn = false;
		}
	}

	public boolean isOn() {
		return isOn;
	}

	public void increaseBrightness(final int value) {
		brightness += value;
	}

	public void decreaseBrightness(final int value) {
		brightness -= value;
	}

	public int getCurrentBrightness() {
		return brightness;
	}
}

// Interface for command
interface Command {
	void execute();
}

//Parameterized Commands that contains all the information to perform action
class LightOnCommand implements Command {

	private final Light light;

	public LightOnCommand(final Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
	}
}

class LightOffCommand implements Command {

	private final Light light;

	public LightOffCommand(final Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
	}
}

class LightIncreseBrightnessCommand implements Command {

	private final Light light;
	private final int increaseBrightnessBy;

	public LightIncreseBrightnessCommand(final Light light, final int increaseBrightnessBy) {
		this.light = light;
		this.increaseBrightnessBy = increaseBrightnessBy;
	}

	@Override
	public void execute() {
		light.increaseBrightness(increaseBrightnessBy);
	}
}

class LightDecreseBrightnessCommand implements Command {

	private final Light light;
	private final int decreaseBrightnessBy;

	public LightDecreseBrightnessCommand(final Light light, final int decreaseBrightnessBy) {
		this.light = light;
		this.decreaseBrightnessBy = decreaseBrightnessBy;
	}

	@Override
	public void execute() {
		light.decreaseBrightness(decreaseBrightnessBy);
	}
}

// Invoker which sets the commands and invokes operation
// but has no idea about the operation
final class Remote {
	private Command cmd;

	public void setCommand(final Command cmd) {
		this.cmd = cmd;
	}

	public void pressButton() {
		this.cmd.execute();
	}
}
