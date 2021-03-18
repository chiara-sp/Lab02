package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private Map<String,String> parole;
	
	public AlienDictionary() {
		parole = new HashMap<>();
	}
	
	public void addWord(String alienWord, String translation) {
		if(parole.containsKey(alienWord.toLowerCase())) {
			parole.replace(alienWord.toLowerCase(), translation.toLowerCase());
		}
		
		else {
			parole.put(alienWord.toLowerCase(), translation.toLowerCase());
		}
	}
	public String translateWord(String alien) {
		alien= alien.toLowerCase();
		if(parole.containsKey(alien)) {
			return parole.get(alien);
		}
		return null;
	}

}
