package com.designpatterns.behavioural.command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediatorPattern {

	public static void main(String[] args) {
		final IChat mediator = new ChatRoom();
		final User karna = new ChatUser(mediator, "Karna", "1");
		final User dharmaraja = new ChatUser(mediator, "Dharmaraja", "2");
		final User arjun = new ChatUser(mediator, "Arjun", "3");
		final User bheema = new ChatUser(mediator, "Bheema", "4");
		final User nakula = new ChatUser(mediator, "Nakula", "5");
		final User sahadeva = new ChatUser(mediator, "Sahadeva", "6");
		
		mediator.addUsers(Arrays.asList(karna, dharmaraja, arjun, bheema, nakula, sahadeva));
		karna.sendMessage("Hello ", arjun);
	}

}

abstract class User {
	private final IChat chatRoom;
	private final String name;
	private final String id;

	public User(IChat chatRoom, String name, String id) {
		super();
		this.chatRoom = chatRoom;
		this.name = name;
		this.id = id;
	}
	
	abstract void sendMessage(String message, User user);
	abstract void receive(String msg);

	public IChat getChatRoom() {
		return chatRoom;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}	
}

interface IChat {
	void sendMessage(String message, User user);
	void addUser(User user);
	void addUsers(List<User> users);
}

class ChatRoom implements IChat {

	private static Map<String, User> usersMap = new HashMap<>();
	
	@Override
	public void sendMessage(String message, User user) {
		usersMap.get(user.getId()).receive(message);
	}

	@Override
	public void addUser(User user) {
		usersMap.put(user.getId(), user);
	}

	@Override
	public void addUsers(List<User> users) {
		users.stream().forEach(user -> usersMap.put(user.getId(), user));
	}
}

class ChatUser extends User {

	public ChatUser(final IChat chatRoom, final String name, final String id) {
		super(chatRoom, name, id);
	}

	@Override
	void sendMessage(final String message, final User user) {
		System.out.println(getName() +" sent message "+ message);
		this.getChatRoom().sendMessage(message, user);
	}

	@Override
	void receive(final String msg) {
		System.out.println(this.getName() +" got message "+msg);
	}
}
