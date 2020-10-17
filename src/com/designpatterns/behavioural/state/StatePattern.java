package com.designpatterns.behavioural.state;

public class StatePattern {

	public static void main(String[] args) {
		final DeliveryContext ctx = new DeliveryContext("Some Package");
		ctx.update();
		ctx.update();
		ctx.update();
		ctx.update();
		ctx.update();
		ctx.update();
		ctx.update();
	}

}

interface PackageState {
	void nextState(DeliveryContext ctx);
}

class DeliveryContext {
	private PackageState state;
	private String id;

	public DeliveryContext(final String id) {
		super();
		this.state = OrderPlaced.getInstance();
		this.id = id;
		System.out.println("The Order is Placed");
	}

	public void update() {
		state.nextState(this);
	}
	
	public PackageState getState() {
		return state;
	}

	public void setState(final PackageState state) {
		if (state == null) {
			System.out.println("Order has been completed, Thank you");
			return;
		}
		System.out.println("The Order is "+state.getClass().getSimpleName());
		this.state = state;
	}

	public String getId() {
		return id;
	}
}

class OrderPlaced implements PackageState {
	private static final OrderPlaced INSTANCE = new OrderPlaced();

	private OrderPlaced() {
	}

	public static OrderPlaced getInstance() {
		return INSTANCE;
	}

	@Override
	public void nextState(final DeliveryContext ctx) {
		ctx.setState(Shipped.getInstance());
	}
}

class Shipped implements PackageState {
	private static final Shipped INSTANCE = new Shipped();

	private Shipped() {
	}

	public static Shipped getInstance() {
		return INSTANCE;
	}

	@Override
	public void nextState(final DeliveryContext ctx) {
		ctx.setState(InTransition.getInstance());
	}
}

class InTransition implements PackageState {
	private static final InTransition INSTANCE = new InTransition();

	private InTransition() {
	}

	public static InTransition getInstance() {
		return INSTANCE;
	}

	@Override
	public void nextState(final DeliveryContext ctx) {
		ctx.setState(OutForDelivery.getInstance());
	}
}

class OutForDelivery implements PackageState {
	private static final OutForDelivery INSTANCE = new OutForDelivery();

	private OutForDelivery() {
	}

	public static OutForDelivery getInstance() {
		return INSTANCE;
	}

	@Override
	public void nextState(final DeliveryContext ctx) {
		ctx.setState(Delivered.getInstance());
	}
}

class Delivered implements PackageState {
	private static final Delivered INSTANCE = new Delivered();

	private Delivered() {
	}

	public static Delivered getInstance() {
		return INSTANCE;
	}

	@Override
	public void nextState(final DeliveryContext ctx) {
		ctx.setState(null);
	}
}