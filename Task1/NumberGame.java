package Internship;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		boolean status=true;
		
		while(status) {
			Random r=new Random();
			int n=r.nextInt(10)+1;
			System.out.println("Random number is :"+n);
			int attempt=1;
			System.out.println("You have only 3 chances to guess the number");
			
			while(attempt<=3) {
				System.out.println("Enter a number :");
				int  num=sc.nextInt();
				if(num==n) {
					System.out.println("Congratulations");
					break;
				}else if(num<n) {
					System.out.println("Number is Low");
				}else if(num>n) {
					System.out.println("Number is High");
				}
				attempt++;
			}
			System.out.println("Do you want to play again(Yes/No)");
			String s=sc.next();
			if(s.equalsIgnoreCase("No")) {
				status=false;
				System.out.println("Thank you for Participating");
			}else {
				status=true;
			}
		}
		sc.close();

	}

}
