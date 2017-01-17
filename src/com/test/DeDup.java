package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Class which has different kinds of implementations to return an array with
 * out duplications.
 * 
 * @author chandra07
 *
 */
public class DeDup {

	public static int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
			3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {

		DeDup duplicate = new DeDup();
		// First implementation to return an array , which doesnt have
		// duplicates

		System.out.println(Arrays.toString(duplicate.removeDulicates(randomIntegers)));
		System.out.println(Arrays.toString(duplicate.elimateDuplicates(randomIntegers)));
		System.out.println(Arrays.toString(duplicate.identifyUniqueElements(randomIntegers)));

	}

	/**
	 * 
	 * @param list
	 * @return returns integer array
	 */
	public int[] removeDulicates(int[] list) {
		// check length of array
		if (list.length == 0) {
			return null;
		}
		// verify more than one element
		if (list.length == 1) {
			return list;
		}
		// find and add originals to new array
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			if (!numbers.contains(list[i])) {
				numbers.add(list[i]);
			}
		}
		Iterator<Integer> valueIterator = numbers.iterator();
		int[] resultArray = new int[numbers.size()];
		int i = 0;
		while (valueIterator.hasNext()) {
			resultArray[i] = valueIterator.next();
			i++;
		}
		return resultArray;

	}

	/**
	 * 
	 * @param arr
	 * @return returns an array without duplicates
	 */
	public int[] elimateDuplicates(int[] arr) {
		// check length of array
		if (arr.length == 0) {
			return null;
		}
		// verify more than one element
		if (arr.length == 1) {
			return arr;
		}
		int end = arr.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {
					int shiftLeft = j;
					for (int k = j + 1; k < end; k++, shiftLeft++) {
						arr[shiftLeft] = arr[k];
					}
					end--;
					j--;
				}
			}
		}

		int[] whitelist = new int[end];
		for (int i = 0; i < end; i++) {
			whitelist[i] = arr[i];
		}
		return whitelist;
	}

	/**
	 * 
	 * @param arrayWithDuplicates
	 * @return returns an array without duplicates
	 */
	public int[] identifyUniqueElements(int[] arrayWithDuplicates) {
		// check length of array
		if (arrayWithDuplicates.length == 0) {
			return null;
		}
		// verify more than one element
		if (arrayWithDuplicates.length == 1) {
			return arrayWithDuplicates;
		}

		// Assuming all elements in input array are unique

		int noOfUniqueElements = arrayWithDuplicates.length;

		// Comparing each element with all other elements

		for (int i = 0; i < noOfUniqueElements; i++) {
			for (int j = i + 1; j < noOfUniqueElements; j++) {
				// If any two elements are found equal

				if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {
					// Replace duplicate element with last unique element

					arrayWithDuplicates[j] = arrayWithDuplicates[noOfUniqueElements - 1];

					// Decrementing noOfUniqueElements

					noOfUniqueElements--;

					// Decrementing j

					j--;
				}
			}
		}

		// Copying only unique elements of arrayWithDuplicates into
		// arrayWithoutDuplicates

		int[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, noOfUniqueElements);

		return arrayWithoutDuplicates;
	}

}