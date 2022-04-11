package com.gl.question1;
import java.util.Scanner;

public class MainClass {
	
	String findTarget(int[] arry, int target) {
		
		int count=0;
		
		for (int i = 0; i < arry.length; i++) {
			count += arry[i];
			if(count > target || count == target) {
				return "Target archieved after " + (i+1) + " transactions";
			}
		}
		
		return "Given target is not achieved";
	}

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		MainClass objClass = new MainClass();
		
		int[] transactionArry;
		int transactionsize, targetSize;
		
		System.out.println("Enter the size of transaction array");
		transactionsize = scanner.nextInt();
		
		transactionArry = new int[transactionsize];
		
		System.out.println("Enter the value of array");
		
		for (int i = 0; i < transactionsize; i++) {
			transactionArry[i] = scanner.nextInt();
		}
		
		
		System.out.println("Enter the total no of targets that needs to be achieved");
		targetSize = scanner.nextInt();
		
		for (int i = 0; i < targetSize; i++) {
			
			System.out.println("Enter the value of target");
			int target = scanner.nextInt();
			String result = objClass.findTarget(transactionArry, target);
			System.out.println(result + "\n");
			
		}
		
		scanner.close();

	}

}
