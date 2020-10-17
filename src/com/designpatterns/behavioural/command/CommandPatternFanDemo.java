package com.designpatterns.behavioural.command;

// Invoker (Remote) and command interface are in CommandPatternLightDemo class
public class CommandPatternFanDemo {

	public static void main(String[] args) {
		final Fan livingRoomFan = new Fan(FanSpeedLevel.LOW);
		final Fan bedRoomFan = new Fan(FanSpeedLevel.LOW);

		final Remote remote = new Remote();

		remote.setCommand(new FanOnCommand(livingRoomFan));
		remote.pressButton();
		System.out.println("Living room fan is " + livingRoomFan.isOn());

		remote.setCommand(new FanSetSpeedLevelCommand(livingRoomFan, FanSpeedLevel.MEDUIM));
		remote.pressButton();
		System.out.println("Living room fan level is " + livingRoomFan.getCurrentFanLevel().name());

		remote.setCommand(new FanSetSpeedLevelCommand(livingRoomFan, FanSpeedLevel.HIGH));
		remote.pressButton();
		System.out.println("Living room fan level is " + livingRoomFan.getCurrentFanLevel().name());

		remote.setCommand(new FanOffCommand(livingRoomFan));
		remote.pressButton();
		System.out.println("Living room fan is " + livingRoomFan.isOn());

		System.out.println("=====================================================");

		remote.setCommand(new FanOnCommand(bedRoomFan));
		remote.pressButton();
		System.out.println("bed room fan is " + bedRoomFan.isOn());

		remote.setCommand(new FanSetSpeedLevelCommand(bedRoomFan, FanSpeedLevel.MEDUIM));
		remote.pressButton();
		System.out.println("bed room fan level is " + bedRoomFan.getCurrentFanLevel().name());

		remote.setCommand(new FanSetSpeedLevelCommand(bedRoomFan, FanSpeedLevel.HIGH));
		remote.pressButton();
		System.out.println("bed room fan level is " + bedRoomFan.getCurrentFanLevel().name());

		remote.setCommand(new FanOffCommand(bedRoomFan));
		remote.pressButton();
		System.out.println("bed room fan is " + bedRoomFan.isOn());
	}

}

enum FanSpeedLevel {
	LOW, MEDUIM, HIGH;
}

//Receiver who know what to perform
class Fan {
	private FanSpeedLevel currentLevel;
	private boolean isOn;

	public Fan(final FanSpeedLevel level) {
		super();
		this.currentLevel = level;
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

	public void setFanSpeed(final FanSpeedLevel level) {
		currentLevel = level;
	}

	public FanSpeedLevel getCurrentFanLevel() {
		return currentLevel;
	}
}

//Parameterized Commands that contains all the information to perform action
class FanOnCommand implements Command {

	private final Fan fan;

	public FanOnCommand(final Fan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		fan.turnOn();
	}
}

class FanOffCommand implements Command {

	private final Fan fan;

	public FanOffCommand(final Fan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		fan.turnOff();
	}
}

class FanSetSpeedLevelCommand implements Command {

	private final Fan fan;
	private final FanSpeedLevel level;

	public FanSetSpeedLevelCommand(final Fan fan, final FanSpeedLevel level) {
		this.fan = fan;
		this.level = level;
	}

	@Override
	public void execute() {
		fan.setFanSpeed(level);
	}
}
