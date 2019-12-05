
package com.jj;

import java.util.Scanner;


/**
 * Tests for Calculator class.
 * 
 */
public class CalculatorTestV0 {

	/**
	 * Main program.
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Number 1: ");
		double num1 = sc.nextDouble();
		System.out.print("Number 2: ");
		double num2 = sc.nextDouble();
		sc.close();
		Calculator c = new Calculator();
		double r = c.add(num1, num2);
		System.out.println("Result: " + r);
	}

}
