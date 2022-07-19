package com.doubleonmatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DoubleOnMatch {
	public static long doubleSize(List<Integer> arr, long num) {
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == num) {
				num = num*2;
			}
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of an array");
		int n = scanner.nextInt();
		
		List<Integer> numbers = new ArrayList<Integer>();

		System.out.println("Enter array elements line by line");
		for (int i = 0; i < n; i++) {
			numbers.add(scanner.nextInt());
		}
		
		System.out.println("Enter value of num to double");
		int num = scanner.nextInt();
		
		scanner.close();
		doubleSize(numbers, num);
	}
}
