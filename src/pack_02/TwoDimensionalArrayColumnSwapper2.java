package pack_02;

import java.util.Arrays;

public class TwoDimensionalArrayColumnSwapper2 {

	public static void main(String[] args) {

		// Swapping in one dimensional array
		int[] arr = { 1, 2, 3, 4, 5 };

		columnSwapper(arr, 0, 4);
		System.out.println(Arrays.toString(arr) + " --> One dimensinal array swapped");

		// Swapping in two dimensional array
		int[][] original = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };

		// For used to move columns in 2 dimensions array
		for (int i = 0; i < original.length; i++) {
			columnSwapper(original[i], 1, 2);
		}
		
		for (int[] e : original) {
			System.out.println(Arrays.toString(e) + " --> Two dimensinal array swapped");
		}

	}

	public static void columnSwapper(int[] arr, int start, int destination) {

		if (!(start < 0 || start >= arr.length || destination < 0 || destination >= arr.length)) {
			int numbersOfElementsToCopy = Math.abs(destination - start);

			if (numbersOfElementsToCopy < 0) {
				int aux = destination;
				destination = start;
				start = aux;
			}

			int elementToCopy = arr[start];
			int[] elementsToMove = new int[numbersOfElementsToCopy];
			int pointer = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i >= start + 1 && i <= destination) {
					elementsToMove[pointer] = arr[i];
					pointer++;
				}
				if (i == destination) {
					arr[i] = elementToCopy;
				}
			}
			pointer = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i >= start && i <= destination - 1) {
					arr[i] = elementsToMove[pointer];
					pointer++;
				}
			}
		} else {
			System.out.println("Fuera de límites");
		}
		// System.out.println(Arrays.toString(arr));
	}

}
