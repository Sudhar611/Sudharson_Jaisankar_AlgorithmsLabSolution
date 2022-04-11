package com.gl.question2;
import java.util.Scanner;


public class MainClass {
	
	int[] result;
	int balance;
	
	void sortArry(int[] currencyArry) {
		
		for(int j=1; j < currencyArry.length ; j++) {
			
			int key = currencyArry[j];
			int k = j-1;
			
			while(k > -1 && currencyArry[k] < key) {
				currencyArry[k + 1] = currencyArry[k];
				 k--;
			}
			
			currencyArry[k + 1] = key;
		}
	}
	
	void findPaymentApproach(int[] arry, int amount) {
		this.result = new int[arry.length];
		
		int count = 0, total = 0;
		
		for (int i =  0; i < arry.length; i++) {
			
			count = 0;
			
			while(total <= amount) {
				total += arry[i];
				count += 1;
			}
			
			total -= arry[i];
			count --;
			
			if(total == amount) {
				result[i] = count;
				balance = 0;
				break;
			}
			
			result[i] = count;
		}
		
		if(total < amount) {
			balance = amount - total;
		}
	}
	
	void display(int[] currencyArry) {
		for (int i = 0; i < currencyArry.length; i++) {
			
			if(result[i] != 0) {
				System.out.println(currencyArry[i] + ":" + result[i]);
			}
			
		}
		
		if(balance != 0) {
			System.out.println("Balance to pay: "+ balance);
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		MainClass objClass = new MainClass();
		
		int[] currencyArry;
		int currencysize, amount;
		
		System.out.println("Enter the size of currency denominations");
		currencysize = scanner.nextInt();
		
		currencyArry = new int[currencysize];
		
		System.out.println("Enter the currency denominations value");
		
		for (int i = 0; i < currencysize; i++) {
			currencyArry[i] = scanner.nextInt();
		}
		
		System.out.println("Enter the amount you want to pay");
		amount = scanner.nextInt();
		
		objClass.sortArry(currencyArry);
		
		objClass.findPaymentApproach(currencyArry, amount);
		
		
		System.out.println("Your payment approach in order to give min no of notes will be");
		objClass.display(currencyArry);
		
		scanner.close();
		
	}

}
