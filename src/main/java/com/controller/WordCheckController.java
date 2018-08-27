package com.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PalindromeWord;
import com.ReadUsersInput;
import com.WriteToFile;
import com.XMLReader;

@Controller
public class WordCheckController {
	private static final Logger logger = LogManager.getLogger(WordCheckController.class);

	@RequestMapping("/index")
	public String index() {
		logger.error(" +++++++++++++++++++Index++++++++++++++++++++++++++++++");
		System.out.println(" ++++++ index ");
		return "index";
	}

	@PostMapping(value = "/detail")
	public String wordCheck(@RequestParam("word") String word, Model model) throws IOException {
		
		try {
			WriteToFile write = new WriteToFile();
			write.addWord(word);
			// Merriam-Webster’s Developer URL with Key
			URL url = new URL("https://www.dictionaryapi.com/api/v1/references/collegiate/xml/" + word
					+ "?key=c7c29533-018f-4253-93ed-defd08d0bee7");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// con.setRequestMethod("GET");
			XMLReader xmlReader = new XMLReader();
			PalindromeWord palindrome = new PalindromeWord();
			Map<String, String> results = xmlReader.read(con.getInputStream(), word);
			if (results.get(word) != null) {
				System.out.println(" id : " + results.get(word));
				model.addAttribute("word", results.get(word));
				model.addAttribute("id", word);

				boolean isPalindrome = palindrome.checkPalindrome(word);
				String str;
				if (isPalindrome) {
					str = " is a ";
				} else {
					str = " is not ";
				}

				model.addAttribute("palindrome", str);

			}

		} catch (UnknownHostException unk) {
			logger.error(
					" +++++++++++++++++++Unknown Host Excepetion : Check internet Connection ++++++++++++++++++++++++++++++"
							+ unk.getStackTrace());

		}
		return "detail";
		
	}
	
	@RequestMapping("/userWords")
	public String userWords(Model model) {
		logger.error(" +++++++++++++++++++Index++++++++++++++++++++++++++++++");
		System.out.println(" ++++++ index ");

		ReadUsersInput readInput = new ReadUsersInput();
		ArrayList list = readInput.readFile();
		model.addAttribute("list", list.toString());
		return "userWords";
	}
	
	
}