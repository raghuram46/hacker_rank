package com.websitepagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pagination1 {

	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder,
			int itemsPerPage, int pageNumber) {
		
		if (sortParameter > 0) {

			if (sortOrder == 0) {
				Collections.sort(items, (a, b) -> Integer.compare(Integer.parseInt(a.get(sortParameter)),
						Integer.parseInt(b.get(sortParameter))));
			} else {
				Collections.sort(items, (a, b) -> Integer.compare(Integer.parseInt(b.get(sortParameter)),
						Integer.parseInt(a.get(sortParameter))));
			}
			
		} else {

			if (sortOrder == 0) {
				Collections.sort(items, (a, b) -> a.get(sortParameter).compareTo(b.get(sortParameter)));
			} else {
				Collections.sort(items, (a, b) -> b.get(sortParameter).compareTo(a.get(sortParameter)));
			}

		}
		
		List<String> tempList = new ArrayList<>();
		
		int itemsInLastPage = items.size()% itemsPerPage;
		int lastPageNo;
		if(itemsInLastPage !=0) {
			lastPageNo = items.size()/itemsPerPage;
		}else {
			lastPageNo = (items.size()/itemsPerPage) - 1;
		}
		
		
		if(pageNumber == lastPageNo && itemsInLastPage != 0) {
			for(int i=0; i<itemsInLastPage; i++) {
				tempList.add(items.get(itemsPerPage*pageNumber + i).get(0));
			}
		}else if(pageNumber != lastPageNo ||(pageNumber == lastPageNo && itemsInLastPage == 0)) {
			for(int i=0; i<itemsPerPage; i++) {
				tempList.add(items.get(itemsPerPage*pageNumber + i).get(0));
			}
		}
		
		return tempList;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of items");
		int numOfItems = scanner.nextInt();
		scanner.nextLine();

		List<List<String>> items = new ArrayList<>(); 

		for (int i = 0; i < numOfItems; i++) {
			List<String> innerList = new ArrayList<>();
			System.out.println("Enter Item" + (i + 1) + " Details");
			String[] item = scanner.nextLine().split(" ");
			
			innerList.add(item[0]);
	        innerList.add(item[1]);
	        innerList.add(item[2]);
	        
	        items.add(innerList);
		}

		System.out.println("Enter index position of the column of the item to sort on(sort parameter)");
		int sortParameter = scanner.nextInt();

		System.out.println("Enter sort order");
		int sortOrder = scanner.nextInt();

		System.out.println("Enter items per page");
		int itemsPerPage = scanner.nextInt();

		System.out.println("Enter page number which starts from '0'");
		int pageNumber = scanner.nextInt();

		List<String> pageItems = null;
		try {
			pageItems = fetchItemsToDisplay(items, sortParameter, sortOrder, itemsPerPage, pageNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String string : pageItems) {
			System.out.println(string);
		}

		scanner.close();
	}

}
