package assignment2;  

import java.util.Scanner;

public class Scanners {
	
	static Scanner sc = new Scanner(System.in);
	
	public static String scanLine() {
		String readLine = sc.nextLine();
		return readLine;
	}
	
	public static int scanInt() {
		int readInt = sc.nextInt();
		sc.nextLine();
		return readInt;
	}
	
	public static double scanDouble() {
		double readDouble = sc.nextDouble();
		sc.nextLine();
		return readDouble;
	}
	
}


