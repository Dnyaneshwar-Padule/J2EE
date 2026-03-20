package com.tca.service;

public class CaesarCipherService {

	public String convertText(String msg, int shift) {
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
	
}
