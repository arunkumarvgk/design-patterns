package com.designpatterns.behavioural.cor;

public class ChainOfResponsibilityPattern {

	public static void main(String[] args) {
		final ServiceRequest request = new ServiceRequest(ServiceType.EXPERT);
		final BasicService basicServiceHandler = new BasicService();
		final IntermidiateService intermidiateServiceHandler = new IntermidiateService();
		final ExpertService expertServiceHandler = new ExpertService();
		
		basicServiceHandler.setHandler(intermidiateServiceHandler);
		intermidiateServiceHandler.setHandler(expertServiceHandler);
		
		basicServiceHandler.handle(request);
		
		System.out.println(request.getConclusion());
	}

}

enum ServiceType {
	BASIC, INTERMIDIATE, EXPERT, INVALID
}

class ServiceRequest {
	private final ServiceType serviceType;
	private String conclusion;
	
	public ServiceRequest (final ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(final String conclusion) {
		this.conclusion = conclusion;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}
}

interface ServiceHandler {
	void handle(ServiceRequest request);
}

class BasicService implements ServiceHandler {

	private ServiceHandler handler;
	
	@Override
	public void handle(final ServiceRequest request) {
		if (request.getServiceType() == ServiceType.BASIC) {
			request.setConclusion("Solved at basic level");
		} else {
			System.out.println("Forwarding request from basic level");
			// Hand it to next level
			handler.handle(request);
		}
	}

	public ServiceHandler getHandler() {
		return handler;
	}

	public void setHandler(ServiceHandler handler) {
		this.handler = handler;
	}
}

class IntermidiateService implements ServiceHandler {

	private ServiceHandler handler;
	
	@Override
	public void handle(final ServiceRequest request) {
		if (request.getServiceType() == ServiceType.INTERMIDIATE) {
			request.setConclusion("Solved at intermidiate level");
		} else {
			System.out.println("Forwarding request from intermidiate level");
			// Hand it to next level
			handler.handle(request);
		}
	}

	public ServiceHandler getHandler() {
		return handler;
	}

	public void setHandler(ServiceHandler handler) {
		this.handler = handler;
	}
}

class ExpertService implements ServiceHandler {

	@Override
	public void handle(final ServiceRequest request) {
		if (request.getServiceType() == ServiceType.EXPERT) {
			request.setConclusion("Solved at expert level");
		} else {
			// No more handler
			request.setConclusion("Request cannpt be resolved");
		}
	}
}
