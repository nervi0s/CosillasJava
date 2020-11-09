package pack_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

import pack_02.CensorWords;

public class FileCensor {

	public static void main(String[] args) {

		String[] censoredWords = fillWithCensoredWords("./resources/insultos.txt");

		System.out.println(censoredWords.length);
		censorFile("./resources/Quijote.txt", censoredWords);

	}

	public static String[] fillWithCensoredWords(String path) {
		String[] arr = null;
		File file = new File(path);
		try {
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader buffReader = new BufferedReader(streamReader);

			int i;
			String str = "";

			while ((i = buffReader.read()) != -1) {
				str += (char) i;
			}
			buffReader.close();

			arr = str.split("\r\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static String insertBlanks(StringBuilder strBuilder, ArrayList<Integer> index) {
		for (Integer i : index) {
			strBuilder.insert(i, " ");
		}

		String str = strBuilder.toString();
		return str;
	}

	public static void censorFile(String inputFilePath, String[] censoredWords) {

		File fileIn = new File(inputFilePath);
		File fileOut = new File(fileIn.getParent() + "/censuredText.txt");

		// ArrayList to store index of blanks in the text
		ArrayList<Integer> spacesIndex = new ArrayList<Integer>();

		try {
			// Used to read file
			FileInputStream inputStream = new FileInputStream(fileIn);
			InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader buffReader = new BufferedReader(streamReader);
			// Used to write file
			FileWriter writer = new FileWriter(fileOut, true);

			int index = -1; // Used to target the blanks index
			int character;
			StringBuilder strUncensored = new StringBuilder();
			StringBuilder strCensored = new StringBuilder();
			// String result = ""; // For debug

			while ((character = buffReader.read()) != -1) {
				index++;
				if ((char) character != ' ') {
					strUncensored.append((char) character);
					if ((char) character == '.') { // Split When char '.' appears
						strCensored.append(CensorWords.censor(strUncensored.toString(), censoredWords));
						writer.write(insertBlanks(strCensored, spacesIndex));
						// result += insertSpaceIntoString(censored, spacesIndex); // For debug
						strUncensored.setLength(0); // Reset
						strCensored.setLength(0); // Reset
						spacesIndex.clear(); // Reset
						index = -1; // Reset
					}
				} else {
					spacesIndex.add(index); // Add blanks index
				}

			}

			buffReader.close();
			writer.close();
			// System.out.println(result); // For debug

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
