package com.virtusa.convert;

import java.util.Scanner;

public class NumberToWordConverter {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int n = sc.nextInt();
			System.out.println(new NumberToWordConverter().convertNumberToBritishEnglish(n));
		}catch(Exception e) {
			System.out.println("Exception occurred while converting from Number to Words");
		}
	}
	
	String convertNumberToBritishEnglish(int n) {
		String numberInWords = "";
		String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven","eight",
				"nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		
		String[] tens = {"zero","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		
		if(n == 0) {
			return "zero";
		}
		if(n/1000000 > 0) {
			numberInWords = numberInWords + convertNumberToBritishEnglish(n/1000000)+" million ";
			n = n % 1000000;
		}
		if(n/1000 > 0) {
			numberInWords = numberInWords + convertNumberToBritishEnglish(n/1000)+" thousand ";
			n = n % 1000;
		}
		if(n/100 > 0) {
			numberInWords = numberInWords + convertNumberToBritishEnglish(n/100)+" hundred and ";
			n = n % 100;
		}
		if(n > 0) {
			if(n < 20) {
				numberInWords = numberInWords + " "+ones[n];
			}else {
				numberInWords = numberInWords + " "+tens[n/10];
				if(n % 10 > 0){
					numberInWords = numberInWords + " "+ones[n % 10];
				}
			}
		}
		return numberInWords;
	}
}
