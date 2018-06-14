

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input2Huffman {

	public static int[] readIt2Huff(File file) {
		BufferedReader br = null;
		String fileString = "";

		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

		} catch (FileNotFoundException e) {
			System.out.println("No File Found");
		}

		// make a string of the file
		try {
			String str;
			String file2String = "";

			while ((str = br.readLine()) != null) {
				file2String += str;
			}
			fileString += file2String;
		} catch (IOException e) {
			System.out.println("Do I have permission? Maybe the stream closed..");
		}
		int[] charCountArray = countEm(fileString);

	}
	
	
	public static int[] countEm(String str) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
	}
}
