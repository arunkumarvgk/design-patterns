package com.designpatterns.behavioural.strategy;

public class StrategyPattern {

	public static void main(String[] args) {
		final Navigator navigator = new Navigator(new TwoWheelerRouteStrategy());
		navigator.navigate("Bengaluru", "Chittoor");
		
		new Navigator(new FourWheelerRouteStrategy()).navigate("Chennai", "Nellore");
		new Navigator(new PublicTransportRouteStrategy()).navigate("Mysore", "Delhi");
		new Navigator(new CycleRouteStrategy()).navigate("Mumbai", "Pune");
		new Navigator(new RoadRouteStrategy()).navigate("Kochi", "Patna");
		new Navigator(new WalkRouteStrategy()).navigate("Badrinath", "Kedarnath");
	}

}

interface RouteStrategy {
	void buildRoute(String src, String dest);
}

class Navigator {
	private final RouteStrategy routeStrategy;
	
	public Navigator(final RouteStrategy routeStrategy) {
		this.routeStrategy = routeStrategy;
	}
	
	public void navigate(final String src, final String dest) {
		this.routeStrategy.buildRoute(src, dest);
	}
}

class RoadRouteStrategy implements RouteStrategy {
	@Override
	public void buildRoute(String src, String dest) {
		System.out.println("Travel to "+src+" to "+dest+" via Road");
	}
}

class WalkRouteStrategy implements RouteStrategy {
	@Override
	public void buildRoute(String src, String dest) {
		System.out.println("Travel to "+src+" to "+dest+" Walking");
	}
}

class CycleRouteStrategy implements RouteStrategy {
	@Override
	public void buildRoute(String src, String dest) {
		System.out.println("Travel to "+src+" to "+dest+" Cycling");
	}
}

class TwoWheelerRouteStrategy implements RouteStrategy {
	@Override
	public void buildRoute(String src, String dest) {
		System.out.println("Travel to "+src+" to "+dest+" in Two Wheeler");
	}
}

class FourWheelerRouteStrategy implements RouteStrategy {
	@Override
	public void buildRoute(String src, String dest) {
		System.out.println("Travel to "+src+" to "+dest+" in Four Wheeler");
	}
}

class PublicTransportRouteStrategy implements RouteStrategy {
	@Override
	public void buildRoute(String src, String dest) {
		System.out.println("Travel to "+src+" to "+dest+" via Public transport");
	}
}