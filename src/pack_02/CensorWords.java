package pack_02;

import java.util.ArrayList;
import java.util.Arrays;

public class CensorWords {

	public static void main(String[] args) {

		String[] words = { "comepiñas", "feo", "loco", "test" };
		String str = "hola amigo loco, cómo estás?";

		System.out.println(censor(str, words));
	}

	public static String censor(String stringRaw, String[] censoredWords) {

		ArrayList<int[]> matches = new ArrayList<int[]>();
		// Call to method that saves in the ArrayList index and length of each censored
		// word in raw string. This method is called for each word stored in censored
		// words array
		for (int i = 0; i < censoredWords.length; i++) {
			matches.addAll(indexAndLengthOfMatches(stringRaw, censoredWords[i]));
		}

		// Print data found (Only for debug)
		for (int[] arr : matches) {
			System.out.println(Arrays.toString(arr));
		}
		
		// Change each character of the censored word in raw string with 'x'
		for (int i = 0; i < matches.size(); i++) {
			StringBuilder strBuilder = new StringBuilder(stringRaw);
			for (int j = matches.get(i)[0]; j < matches.get(i)[0] + matches.get(i)[1]; j++) {
				// System.out.println(j);
				strBuilder.setCharAt(j, 'x');
			}
			stringRaw = strBuilder.toString();
		}

		return stringRaw;

	}

	/*
	 * Return an ArrayList of int[] which store index and length of censored word
	 * presents in the target string
	 */
	public static ArrayList<int[]> indexAndLengthOfMatches(String str, String strTofind) {
		ArrayList<int[]> matches = new ArrayList<int[]>();
		String acumulator = "";
		boolean allowFill = false; // Used to allow or not fill the String accumulator
		boolean allowModifyIndex = true;
		int index = 0;

		for (int i = 0; i < str.length(); i++) {
			String addedLetter = String.valueOf(str.charAt(i));
			acumulator = allowFill ? acumulator += addedLetter : addedLetter;

			if (isSubstring(acumulator, strTofind)) {
				allowFill = true;
				if (allowModifyIndex) {
					index = i;
				}
				allowModifyIndex = false;
			} else {
				if (allowFill) {
					i = i - 1;
				}
				allowFill = false;
				allowModifyIndex = true;
			}

			// Allows add the pair data found to the ArrayList
			if (strTofind.length() == acumulator.length() && allowFill) {
				int[] data = { index, strTofind.length() }; // Store pair data
				matches.add(data); // Add pair data
				System.out.print(strTofind + ": ");
				// System.out.println("Empieza en el índice: " + index + " Con longitud: " + strTofind.length());
				allowFill = false; // Reset
				allowModifyIndex = true; // Reset
			}
		}
		return matches;
	}
	
	// Check if a letter or a word is substring of other word, from left to right
	public static boolean isSubstring(String source, String toFind) {

		if (source.length() > toFind.length()) { // Check if length is greater
			return false;
		}

		String[] toFindSplitted = toFind.split("");
		boolean isOk = false;

		for (int i = 0; i < source.length(); i++) {
			String letter = String.valueOf(source.charAt(i));
			if (letter.equalsIgnoreCase(toFindSplitted[i])) {
				isOk = true;
			} else {
				return false; // If one character doesn't match with the checking, exit returned false
			}
		}
		return isOk;
	}

}
