package pack_00;

import java.util.Arrays;

public class ColumnSwapper {

	public static void main(String[] args) {

		int[] original = { 1, 2, 3, 4, 5 };
		columSwap(original, 2, 4);

	}

	public static void columSwap(int[] sourceArray, int indexSource, int indexDestination) {

		int elementToMove = sourceArray[indexSource];
		int numberOfColumnsToMove = Math.abs(indexDestination - indexSource);
		int[] columToMove = new int[numberOfColumnsToMove];

		for (int i = 0; i < sourceArray.length; i++) {
			if (i == indexSource + 1) {
				int fillCounter = 0;
				for (int j = i; j <= indexDestination; j++) {
					columToMove[fillCounter] = sourceArray[j];
					fillCounter++;
				}
			}
		}
		System.out.println(Arrays.toString(columToMove) + " --> To move");

		for (int i = 0; i < sourceArray.length; i++) {
			if (i == indexSource) {
				int fillCounter = 0;
				for (int j = i; j <= indexDestination - 1; j++) {
					sourceArray[j] = columToMove[fillCounter];
					fillCounter++;
				}
			}

			if (i == indexDestination) {
				sourceArray[i] = elementToMove;
			}
		}
		System.out.println(Arrays.toString(sourceArray) + " --> Swapped");
	}
}
