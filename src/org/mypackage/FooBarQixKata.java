package org.mypackage;


public class FooBarQixKata {
	static StringBuilder output;
	static final String FOO = "Foo";
	static final String BAR = "Bar";
	static final String QIX = "Qix";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =1; i<150; i++) {
			System.out.println(i + " = " + computeFooBarQixIfIntegerIsDivisibleOrContainsThreeOrFiveOrSeven(i));
		}
	}
	
	public static String computeFooBarQixIfIntegerIsDivisibleOrContainsThreeOrFiveOrSeven(int n) {
		output = new StringBuilder();
		String[] digits = String.valueOf(n).split("");
		
		checkIfIntegerIsDivisibleByInteger(n);
		checkIfIntegerContainsDigit(digits);
		
		appendNIfEmpty(n);
		
		return output.toString();
	}

	private static void checkIfIntegerIsDivisibleByInteger(int n) {
			if (n%3 == 0) {
				output.append(FOO);
			}
			if (n%5 == 0) {
			output.append(BAR);
			}
			if (n%7 == 0) {
			output.append(QIX);
			}
	}

	private static void checkIfIntegerContainsDigit(String[] digits) {
		for (String d : digits) {
			if (d.equals("3")) {
				output.append(FOO);
			}
			if (d.equals("5")) {
				output.append(BAR);
			}
			if (d.equals("7")) {
				output.append(QIX);
			}
		}
	}
	
	private static void appendNIfEmpty(int n) {
		if (output.length() == 0) {
			output.append(n);
		}
	}

}
