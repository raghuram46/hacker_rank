package com.sprinttraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SprintTraining {
	public static int getMostVisited2(int max, List<Integer> sprints) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i < max + 1; i++) {
			map.putIfAbsent(i, 0);
		}

		for (int i = 0; i < sprints.size() - 1; i++) {

			int a = sprints.get(i);// sprints[i];
			int b = sprints.get(i + 1); // sprints[i + 1];
			if (a < b) {
				for (int j = a; j <= b; j++) {
					map.put(j, map.get(j) + 1);
				}
			} else {
				for (int j = b; j <= a; j++) {
					map.put(j, map.get(j) + 1);
				}
			}

		}
		int output = 0;
		int maxVisits = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			int key = entry.getKey();
			int value = entry.getValue();
			if (maxVisits < value) {
				output = key;
				maxVisits = value;

			} else if (maxVisits == value && output > key) {
				output = key;
			}

		}
		return output;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(data.readLine());
		int m = Integer.parseInt(data.readLine());
		List<Integer> sprints = new ArrayList<>();
		for (int index = 0; index < m; index++) {

			int a = Integer.parseInt(data.readLine());
			sprints.add(a);

		}

		System.out.println(getMostVisited2(n, sprints));
	}
}
