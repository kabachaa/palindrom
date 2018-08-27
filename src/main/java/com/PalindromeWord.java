package com;

public class PalindromeWord {

	public boolean checkPalindrome(String word) {
		char[] inputStr = word.toCharArray();
		int start = 0;
		int end = inputStr.length - 1;
		char tempVal;

		while (end > start) {
			tempVal = inputStr[start];
			inputStr[start] = inputStr[end];
			inputStr[end] = tempVal;
			end--;
			start++;
		}
		return new String(inputStr).equalsIgnoreCase(word);
	}
	
	public String reverseWord(String word) {
		char[] inputStr = word.toCharArray();
		int start = 0;
		int end = inputStr.length - 1;
		char tempVal;

		while (end > start) {
			tempVal = inputStr[start];
			inputStr[start] = inputStr[end];
			inputStr[end] = tempVal;
			end--;
			start++;
		}
		String str = new String(inputStr);
		return str;
	}

}
