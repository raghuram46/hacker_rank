package com.wholeminutedilema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WholeMinuteDilema {
	public static long playlist(List<Integer> songs) {
		
		Map<Integer,Integer> map = new HashMap<>();
		long count = 0;
		for(int t : songs) {
			int searchTime = 60 - t%60 == 60 ? 0 : 60 - t%60;
			if(map.containsKey((searchTime)%60)) {
				count += map.get(searchTime % 60);
			}
			map.put(t%60, map.getOrDefault(t%60, 0)+1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of an List");
		int n = scanner.nextInt();
		
		List<Integer> songs = new ArrayList<Integer>();
		
		System.out.println("Enter elements of an array");
		for (int i = 0; i < n; i++) {
			songs.add(scanner.nextInt());
		}
		scanner.close();
		System.out.println(playlist(songs));
	}

}
