package com.tca.service;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipherService {

	public String convertToCipherText(String msg, int shift) {
		StringBuilder result = new StringBuilder();
		shift = shift % 26;
		
		if(shift == 0 || msg == null || msg.isBlank())
			return msg;
		
		for(char ch: msg.toCharArray()) {
			if( (ch >= 'a' && ch <= 'z'))
				ch = (char)(((ch - 'a' + shift) % 26) + 'a');
			else if ((ch >= 'A' && ch <= 'Z') )
				ch = (char)(((ch - 'A' + shift) % 26) + 'A');
			result.append(ch);
		}
		
		return result.toString();
	}

	public List<String> convertToPlainText(String msg){
		List<String> possibilities = new ArrayList<String>();
		String plainText;
		for(int i = 1; i < 26; i++) {
			plainText = convertToCipherText(msg, i);
			if(plainText != null && ! plainText.isBlank())
				possibilities.add(plainText);
		}
		return possibilities;
	}
	
}
