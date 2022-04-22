package assignmentFourDictionary;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Dictionary {
	
	private int capacity;
	private String [] words;
	private int numWordsInDictionary = 0;
	
	public Dictionary () {
		this.capacity = 2;
		this.words = new String[capacity];
	}
	
	public Dictionary (int capacity) {
		this.capacity = capacity;
		this.words = new String[capacity];
	}
	
	private void doubleTheSize () {
		String [] newWordsArray = new String [(words.length * 2)];
		
		for (int i = 0; i < words.length; i++) {
			newWordsArray[i] = words[i];
		}
		words = newWordsArray;
		capacity = words.length;
	}
	
	private boolean matched (String wordOne, String wordTwo) {
		int count = 0;
		
		for (int i = 0; i < wordOne.length(); i++) {
			if (wordOne.charAt(i) == wordTwo.charAt(i)) {
				count++;
			}
		}
		
		if (count >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public int findWord (String word) {
		for (int i = 0; i < numWordsInDictionary; i++) {
			if (words[i].toLowerCase().equals(word)) {
				return i;
			}
		}
		return -1;
	}
	
	public void addWord (String word) {
		if ((words.length - 1) >= capacity) {
			doubleTheSize();
		}
		words[numWordsInDictionary] = word;
		numWordsInDictionary++;
	}
	
	public void removeWord (String word) {
		int checkWord = findWord(word);
		
		if (checkWord == -1) {
			return;
		} else {
			words[checkWord] = null;
			for (int i = 0; i < numWordsInDictionary; i++) {
				//start here
			}
		}
		numWordsInDictionary--;
	}
	
	public String suggest (String word) {
		matched("fix", "this");
		return "hello";
	}
	
	public void loadDictionary (String dictionaryFile) throws FileNotFoundException {
		Scanner inFile = new Scanner (new FileReader(dictionaryFile));
		
		while (inFile.hasNextLine()) {
			String currentWord = inFile.nextLine();
			if (numWordsInDictionary > capacity) {
				doubleTheSize();
			}
			
			words[numWordsInDictionary] = currentWord;
			numWordsInDictionary++;
		}

		//System.out.println(Arrays.toString(words));
		inFile.close();
	}
	
	public void saveDictionary (String dictionaryFile) {
		File outFile = new File (dictionaryFile);
	}


	public static void main(String[] args) throws FileNotFoundException {
		Dictionary d = new Dictionary();
	    final int LOAD = 1, SAVE = 2, CHECK_FILE = 3, CHECK_WORD = 4, ADD_WORD = 5, REMOVE_WORD = 6, SUGGEST_WORD = 7, QUIT = 8;

	    JOptionPane.showMessageDialog(null, "This program implements an interactive dictionary. "
	    		+ "It would allow you to add new words to a dictinary,\n" +
	    		"remove words from the dictionary. Spell check a word with the dictgionary, or suggest correct spelling for\n" +
	    		"a word. In addition, you can load a dictionary of words,save the current dictionary to a file and spell\n" +
	    		"check a given file.\n\n");
	    
	    int userSelection = Integer.parseInt(
	    		JOptionPane.showInputDialog("What would you like to do?  Please eneter the number next to your selection\n" +
	    		       "1: Load Dictionary from File\n" +
	    		       "2: Save Dictionary to file\n" +
	    		       "3: Spell check the file\n" +
	    		       "4: Spell check a word\n" +
	    		       "5: Add a word to dictionary\n" +
	    		       "6: Remove a word from dictionary\n" +
	    		       "7: Suggest correct spelling for a wrod\n" +
	    		       "8: Quit\n")
	    );

	    while (userSelection != QUIT){
	       switch(userSelection){
	       case LOAD:
	    	   String fileName = JOptionPane.showInputDialog("Please enter the name of the dictionary file to load"); //"/users/w1082952/temp/Dict.txt" on my system
	    	   d.loadDictionary(fileName);
	    	   break;
	       case SAVE:
	    	   fileName = JOptionPane.showInputDialog("Please enter the name of the dictionary file to save");//"/users/w1082952/temp/Dict-saved.txt" on my system
	    	   d.saveDictionary(fileName);
	    	   break;
	       case CHECK_FILE:
	    	   fileName = JOptionPane.showInputDialog("Please enter the name of the file you want to spell check");//"/users/w1082952/temp/SPFile.txt" on my system
	    	   Scanner inFile = new Scanner (new FileReader(fileName));      	      //read one word at a time and add it to he dictionary
	    	   String misspelledWords = null;
	    	   String nextWordToSpellCheck;
	    	   while (inFile.hasNext())
	    	       if (d.findWord(nextWordToSpellCheck = inFile.next()) < 0 )
	    	    	   if(misspelledWords != null)
	    	    		   misspelledWords += " " + nextWordToSpellCheck;
	    	    	   else
	    	    		   misspelledWords = nextWordToSpellCheck;
	    	   if (misspelledWords != null)
	    		   JOptionPane.showMessageDialog(null, "Missspelled Words Are: " + misspelledWords);
	    	   else
	    		   JOptionPane.showMessageDialog(null, "No spelling errors were found");

	    	   inFile.close();  	   
	    	   break;
	       case CHECK_WORD:
	    	   String wordToSpellCheck = JOptionPane.showInputDialog("Please enter the word you want to spell check");
	    	   if(d.findWord(wordToSpellCheck) < 0)
	    		   JOptionPane.showMessageDialog(null, "The word you entered is missspelled: ");
	    	   else
	    		   JOptionPane.showMessageDialog(null, "Word is spelled correctly");
	    	   break;
	       case ADD_WORD:
	    	   String wordToAddtoDictionary = JOptionPane.showInputDialog("Please enter the word you want to add to dictionary");
	    	   d.addWord(wordToAddtoDictionary);
	    	   break;
	       case REMOVE_WORD:
	    	   String wordToRemoveFromDictionary = JOptionPane.showInputDialog("Please enter the word you want to remove from dictionary");
	    	   d.removeWord(wordToRemoveFromDictionary);    	   
	    	   break;
	       case SUGGEST_WORD:
	    	   String suggestCorrectWordsFor = JOptionPane.showInputDialog("Please enter the word you want to get correct spelling for");
	    	   JOptionPane.showMessageDialog(null, d.suggest(suggestCorrectWordsFor));    	   
	    	   break;
	       case QUIT:
	    	   JOptionPane.showMessageDialog(null, "Have a nice day");
	    	   System.exit(0);
	    	   break;
	       default:
	    	   JOptionPane.showMessageDialog(null, "Invalid Input");
	       }
	       
	       userSelection = Integer.parseInt(
	    		   JOptionPane.showInputDialog("What would you like to do next?  Please eneter the number next to your selection\n" +
	    		   "1: Load Dictionary from File\n" +
	               "2: Save Dictionary to file\n" +
	               "3: Spell check the file\n" +
	               "4: Spell check a word\n" +
	               "5: Add a word to dictionary\n" +
	               "6: Remove a word from dictionary\n" +
	               "7: Suggest correct spelling for a wrod\n" +
	               "8: Quit\n")
	    	);

	    } //end while loop

	} //end main method
	
} //end class 
