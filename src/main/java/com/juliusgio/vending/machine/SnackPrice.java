package com.juliusgio.vending.machine;

public class SnackPrice {
	
	ListSnack name;
	long price;

	public SnackPrice(ListSnack name, long price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name.toString();
	}

	public void setName(ListSnack name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Snack [name=" + name.toString() + ", price=" + price + "]";
	}

}
