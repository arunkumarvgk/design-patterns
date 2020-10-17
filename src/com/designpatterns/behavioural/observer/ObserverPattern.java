package com.designpatterns.behavioural.observer;

import java.util.LinkedList;
import java.util.List;

public class ObserverPattern {

	public static void main(String[] args) {
		final Observer ob1 = new Observer1();
		final Observer ob2 = new Observer2();
		final Observer ob3 = new Observer3();

		final Subject publisher = new NumberPublisher();
		publisher.subscribe(ob1);
		publisher.subscribe(ob2);
		publisher.subscribe(ob3);

		// Event
		publisher.notifyEvent(10);

		publisher.unsubscribe(ob1);
		publisher.unsubscribe(ob2);
		publisher.unsubscribe(ob3);

		// Event will not be notified after unsubscribe.
		publisher.notifyEvent(20);
	}

}

interface Observer {
	void update(Integer num);
}

interface Subject {
	void subscribe(Observer o);

	void unsubscribe(Observer o);

	void notifyEvent(Integer num);
}

final class NumberPublisher implements Subject {
	private final List<Observer> observers = new LinkedList<>();

	@Override
	public void subscribe(Observer o) {
		observers.add(o);
	}

	@Override
	public void unsubscribe(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyEvent(final Integer num) {
		observers.stream().forEach(o -> o.update(num));
	}
}

final class Observer1 implements Observer {
	@Override
	public void update(final Integer num) {
		System.out.println("In Observer 1 got number " + num);
	}
}

final class Observer2 implements Observer {
	@Override
	public void update(final Integer num) {
		System.out.println("In Observer 2 got number " + num);
	}
}

final class Observer3 implements Observer {
	@Override
	public void update(final Integer num) {
		System.out.println("In Observer 3 got number " + num);
	}
}
