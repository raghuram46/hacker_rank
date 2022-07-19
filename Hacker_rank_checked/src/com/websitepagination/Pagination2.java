package com.websitepagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Pagination2 {

	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
		List<Item> itemsList = new ArrayList<>();

		items.stream().forEach(p ->itemsList.add(new Item(p.get(sortParameter))));
		Collections.sort(itemsList,sortOrder == 0 ? new ItemsAscComparator() : new ItemsDescComparator());
		
		List<String> finalList = new ArrayList<>();
		List<String> returnList = new ArrayList<>();

		for(int i = itemsPerPage * pageNumber;
				i<Math.min((itemsPerPage*pageNumber)+itemsPerPage,items.size()); i++) {
			finalList.add(itemsList.get(i).getItemValue());

		}
		for(String var : finalList) {
			items.stream().forEach(p -> {
				if(p.get(sortParameter).equals(var)) {
					returnList.add(p.get(0));
				}
			});
		}
		return returnList;
	}

	static class ItemsAscComparator implements Comparator<Item> {
		public int compare(Item i1, Item i2) {

			if(org.apache.commons.lang3.StringUtils.isNumeric(i1.getItemValue())) {
				return Integer.parseInt(i1.getItemValue())-
						Integer.parseInt(i2.getItemValue());
			}
			return i1.getItemValue().compareTo(i2.getItemValue());
		}
	}
	
	static class ItemsDescComparator implements Comparator<Item> {
		public int compare(Item i1, Item i2) {

			if(org.apache.commons.lang3.StringUtils.isNumeric(i2.getItemValue())) {
				return Integer.parseInt(i2.getItemValue()) -
						Integer.parseInt(i1.getItemValue());
			}
			return i2.getItemValue().compareTo(i1.getItemValue());
		}
	}

	static class Item {
		private String value;

		public Item(String value) {
			this.value=value;
		}
		public String getItemValue() {
			return value;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of items");
		int numOfItems = scanner.nextInt();
		scanner.nextLine();

		List<List<String>> items = new ArrayList<>(); 
		List<String> innerList = new ArrayList<>();

		for (int i = 0; i < numOfItems; i++) {

			System.out.println("Enter Item" + (i + 1) + " Details");
			String[] item = scanner.nextLine().split(" ");
			
			innerList.add(item[0]);
	        innerList.add(item[1]);
	        innerList.add(item[2]);
	        
	        items.add(innerList);
		}

		System.out.println("Enter index position of the column of the item to sort on");
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
