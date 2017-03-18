package it.polito.tdp.alien;

public class Word {
	private String alienWord; 
	private String translation;
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}
	
	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public String compare(String alienWord){
		if(this.getAlienWord().compareTo(alienWord.toLowerCase())==0){
		return alienWord;
		}
		else
		   return null;
	}
}
