package com.juliusgio.vending.machine;

public enum ListSnack {

	biscuit("Biscuit"),
	chips("Chips"),
	oreo("Oreo"),
	tango("Tango"),
	chocolate("Chocolate");
	
	private final String type;
	
	private ListSnack(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
