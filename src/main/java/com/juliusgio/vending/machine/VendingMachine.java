package com.juliusgio.vending.machine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
	private Map<SnackPrice, Long> stocks = new HashMap<>();

	public VendingMachine() {}

	public void addStock(SnackPrice snack, Long stock) {
		Long currentStock = 0l;
		if (this.stocks.containsKey(snack)) currentStock = this.stocks.get(snack);
		
		this.stocks.put(snack, currentStock+stock);
	}

	public void removeStock(SnackPrice snack) {
		Long currentStock = 0l;
		if (this.stocks.containsKey(snack)) currentStock = this.stocks.get(snack);
		
		this.stocks.put(snack, currentStock-1 > 0 ? currentStock-1 : 0);
	}
	
	public String getStock(SnackPrice snack) {
		return String.format("%s with price %d have %d left", snack.getName(), snack.getPrice(), this.stocks.get(snack));
	}
	
	public Boolean checkAvailableStock(SnackPrice snack) {
		return this.stocks.get(snack) > 0 ? true : false;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("VendingMachine Stocks: ");
		this.stocks.forEach((snack, stock) -> {
			result.append("\n - "+ snack.getName() + ", price " + snack.getPrice() + ", " + stock + " left.");
		});
		return result.toString();
	}
	

}
