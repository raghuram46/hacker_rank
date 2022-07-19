package com.maximumratingsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRatings {
	public static long maximumSum(List<Integer> arr) {
		int size = arr.size();
		long max_so_far = Integer.MIN_VALUE, max_ending_here=0;
		for(int i=0; i< size; i++){
			max_ending_here = max_ending_here + arr.get(i);
			if(max_so_far < max_ending_here){
				max_so_far = max_ending_here;
			}
			if(max_ending_here < 0){
				max_ending_here = 0;
			}
		}
		return max_so_far;
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of array");
		int n = scanner.nextInt();
		
		List<Integer> numbers = new ArrayList<Integer>();

		System.out.println("Enter array elements line by line");
		for (int i = 0; i < n; i++) {
			numbers.add(scanner.nextInt());
		}
		scanner.close();
		
		System.out.println(maximumSum(numbers));
	}
}
