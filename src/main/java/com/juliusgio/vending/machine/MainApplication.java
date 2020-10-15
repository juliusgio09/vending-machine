package com.juliusgio.vending.machine;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		/**
		 * Define Price list Snacks
		 */
		SnackPrice biscuit = new SnackPrice(ListSnack.biscuit, 6000);
		SnackPrice chips = new SnackPrice(ListSnack.chips, 8000);
		SnackPrice oreo = new SnackPrice(ListSnack.oreo, 10000);
		SnackPrice tango = new SnackPrice(ListSnack.tango, 12000);
		SnackPrice chocolate = new SnackPrice(ListSnack.chocolate, 15000);
		
		/**
		 * Initialize Stock to Vending Machine
		 */
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.addStock(biscuit, 5l);
		vendingMachine.addStock(chips, 10l);
		vendingMachine.addStock(oreo, 10l);
		vendingMachine.addStock(tango, 15l);
		vendingMachine.addStock(chocolate, 2l);
		
		try {
			System.out.println("Welcome to Vending Machine");
			Scanner nominalScanner = new Scanner(System.in);
			System.out.println("Please Insert money with nominal [2000, 5000, 10000, 20000, 50000]: ");
			long nominalMoney = nominalScanner.nextLong();
			
			if (!checkNominalWhitelisted(nominalMoney)) throw new Exception(String.format("Nominal %d not included in whitelist", nominalMoney));
			
			String continueOrder;
			do {
				System.out.println(vendingMachine.toString());
				SnackPrice snackOrder = null;
				Scanner snackScanner = new Scanner(System.in);
				System.out.println("Please Choose Snack do you want:");
				String snackChoosen = snackScanner.nextLine().toLowerCase();
				switch (snackChoosen) {
					case "biscuit":
						snackOrder = biscuit;
						break;
					case "chips":
						snackOrder = chips;
						break;
					case "oreo":
						snackOrder = oreo;
						break;
					case "tango":
						snackOrder = tango;
						break;
					case "chocolate":
						snackOrder = chocolate;
						break;
					default:
						throw new Exception(String.format("Snack %s not found", snackChoosen));
				}
				if (vendingMachine.checkAvailableStock(snackOrder) && nominalMoney >= snackOrder.getPrice()) {
					vendingMachine.removeStock(snackOrder);
					nominalMoney -= snackOrder.getPrice();
					
					System.out.println(String.format("Thank you for your orders, your balance left: %d", nominalMoney));
				} else {
					System.out.println("Sorry you can't proceed your order");
					System.out.println(String.format("Your balance left: %d", nominalMoney));
					System.out.println(vendingMachine.getStock(snackOrder));
				}
				
				System.out.println("Do you still want try another order? (y/n)");
				Scanner loopScanner = new Scanner(System.in);
				continueOrder = loopScanner.next();
			}
			while(continueOrder.equalsIgnoreCase("y"));
			System.out.println("Thank you, enjoy your snacks");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static boolean checkNominalWhitelisted(long money) {
		final List<Long> nominalWhiteLists = Arrays.asList(2000l, 5000l, 10000l, 20000l, 50000l);
		
		return nominalWhiteLists.contains(money);
	}

}
