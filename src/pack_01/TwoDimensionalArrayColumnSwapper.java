package pack_01;

import java.util.Arrays;

public class TwoDimensionalArrayColumnSwapper {

	public static void main(String[] args) {
		int[][] original = { { 1, 2, 3, 4, 5 }, 
							 { 6, 7, 8, 9, 10 }, 
							 { 11, 12, 13, 14, 15 }, 
							 { 16, 17, 18, 19, 20 } };

		columnSwapper(original, 1, 4);
		for (int[] e : original) {
			System.out.println(Arrays.toString(e) + " ---> swapped");
		}

	}

	public static void columnSwapper(int[][] sourceArray, int indexSource, int indexDestination) {
		if (indexDestination - indexSource < 0) {
			int temp = indexDestination;
			indexDestination = indexSource;
			indexSource = temp;
		}
		int[] elementsToMove = new int[sourceArray.length];
		for (int i = 0; i < sourceArray.length; i++) {
			elementsToMove[i] = sourceArray[i][indexSource];
		}
		System.out.println(Arrays.toString(elementsToMove) + " ---> to copy");
		int numberOfColumnsToMove = Math.abs(indexDestination - indexSource);
		int[][] columnsToMove = new int[sourceArray.length][numberOfColumnsToMove];
		for (int i = 0; i < sourceArray.length; i++) {
			for (int j = 0; j < sourceArray[i].length; j++) {
				if (j == indexSource + 1) {
					int f = 0;
					for (int k = 0; k < columnsToMove.length; k++) {
						int c = indexSource + 1;
						for (int m = 0; m < columnsToMove[k].length; m++) {
							columnsToMove[k][m] = sourceArray[f][c];
							c++;
						}
						f++;
					}

				}

			}
		}

		for (int[] e : columnsToMove) {
			System.out.println(Arrays.toString(e) + " ---> elements saved ");
		}

		for (int i = 0; i < sourceArray.length; i++) {
			for (int j = 0; j < sourceArray[i].length; j++) {
				if (j == indexSource) {
					int f = 0;
					for (int k = 0; k < sourceArray.length; k++) {
						int c = 0;
						for (int m = j; m <= indexDestination - 1; m++) {
							sourceArray[k][m] = columnsToMove[f][c];
							c++;
						}
						f++;
					}

				}
				if (j == indexDestination) {
					sourceArray[i][j] = elementsToMove[i];
				}
			}

		}
	}

}
