package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadUsersInput {

	private static final String FILENAME = "userWords.txt";

	public ArrayList readFile() {

		BufferedReader br = null;
		FileReader fr = null;
		ArrayList lineList = new ArrayList<String>();
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				lineList.add(sCurrentLine);
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return lineList;

	}
}
