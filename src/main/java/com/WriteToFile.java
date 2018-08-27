package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public void addWord(String word) throws IOException {

		BufferedWriter bufferWriter = null;

		PalindromeWord palindrome = new PalindromeWord();
		String filef = "userWords.txt";
		// File Location 
		File file = new File("userWords.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		try {
			FileWriter fw = new FileWriter(file, true);
			bufferWriter = new BufferedWriter(fw);
			bufferWriter.write("Word : " + word);
			bufferWriter.write("\n");
			bufferWriter.write("Reverse: " + palindrome.reverseWord(word));
			bufferWriter.write("\n");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bufferWriter != null)
					bufferWriter.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}
}
