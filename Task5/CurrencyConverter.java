package Internship;

import java.util.Scanner;

public class CurrencyConverter {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("=== Simple Currency Converter ===");
		System.out.println("Available Currencies: USD, INR, EUR");

		System.out.print("Enter Base Currency: ");
		String base = sc.next().toUpperCase();

		System.out.print("Enter Target Currency: ");
		String target = sc.next().toUpperCase();

		System.out.print("Enter Amount: ");
		double amount = sc.nextDouble();

		double rate = getRate(base, target);

		if (rate == 0) {
			System.out.println("Invalid currency selection!");
		} else {
			double result = amount * rate;
			System.out.println("Converted Amount: " + result + " " + target);
		}

		sc.close();
	}

	public static double getRate(String base, String target) {

		if (base.equals("USD") && target.equals("INR"))
			return 90;
		if (base.equals("INR") && target.equals("USD"))
			return 0.011;
		if (base.equals("USD") && target.equals("EUR"))
			return 0.92;
		if (base.equals("EUR") && target.equals("USD"))
			return 1.08;
		if (base.equals("INR") && target.equals("EUR"))
			return 0.010;
		if (base.equals("EUR") && target.equals("INR"))
			return 98;

		return 0; 
	}
}
