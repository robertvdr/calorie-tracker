package com.robvdr;

import java.util.Scanner;

public class BMRCalculator {

	public void calculateBMR() {
		Scanner input = new Scanner(System.in);
		System.out.println("");
		System.out.println("Enter sex: ");
		String userSex = input.nextLine();
		System.out.println("Enter weight: ");
		String userWeightString = input.nextLine();
		double userWeightDouble = Double.parseDouble(userWeightString);
		System.out.println("Enter height feet: ");
		String userHeightFeetString = input.nextLine();
		double userHeightFeetDouble = Double.parseDouble(userHeightFeetString);
		System.out.println("Enter height inches: ");
		String userHeightInchesString = input.nextLine();
		double userHeightInchesDouble = Double.parseDouble(userHeightInchesString);
		System.out.println("Enter age: ");
		String userAgeString = input.nextLine();
		double userAgeDouble = Double.parseDouble(userAgeString);

		double bmr;

		double userHeightDouble = (userHeightFeetDouble * 12) + userHeightInchesDouble;

		if (userSex.equals("female")) {
			bmr = ((4.536 * userWeightDouble) + (15.88 * userHeightDouble) - (5 * userAgeDouble) - 161);
		} else {
			bmr = ((4.536 * userWeightDouble) + (15.88 * userHeightDouble) - (5 * userAgeDouble) + 5);
		}
		System.out.println("BMR: " + bmr + "\n");
	}

}
