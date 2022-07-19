package com.teamformation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Skills {
	public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
		if (skills.size() != 0) {
			
			List<Integer> filteredSkills = skills.stream().filter(rating -> (rating >= minLevel && rating <= maxLevel)).collect(Collectors.toList());
			
			if (filteredSkills.size() > minPlayers) {
				int count = 1;
				for (int i = minPlayers; i < filteredSkills.size(); i++) {
					BigInteger n = fact(i);
					BigInteger n_r = fact(filteredSkills.size()-i);
					BigInteger value = fact(filteredSkills.size()).divide(n.multiply(n_r));
					count += value.intValue();
				}
				return count;
			}
			return filteredSkills.size() == minPlayers ? 1 : 0;
		} else {
			return 0;
		}

	}

	static BigInteger fact(int n) {
			BigInteger factorial = BigInteger.ONE;
			for(int i=n; i>0; i--) {
				factorial = factorial.multiply(BigInteger.valueOf(i));
			}
			return factorial;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of an List");
		int n = scanner.nextInt();

		List<Integer> skills = new ArrayList<Integer>();

		System.out.println("Enter array elements line by line");
		for (int i = 0; i < n; i++) {
			skills.add(scanner.nextInt());
		}
		
		System.out.println("Enter min no of players");
		int minPlayers = scanner.nextInt();
		
		System.out.println("Enter min level");
		int minLevel = scanner.nextInt();
		
		System.out.println("Enter max level");
		int maxLevel = scanner.nextInt();
		scanner.close();
		
		System.out.println(countTeams(skills, minPlayers, minLevel, maxLevel));
	}
}
