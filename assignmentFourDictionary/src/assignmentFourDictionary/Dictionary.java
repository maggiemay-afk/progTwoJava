/*********************************************************************************************************************
 * Name: Maggie Herms
 * Contact: mkherms@uwm.edu
 * Created: 4/12/2022, Last Updated: 4/25/2022
 * About: this program reads in a txt file of words and creates a dictionary. Allows users to add words, remove words, 
 * 		spell check words and files, find words, suggest correct spelling, and save the dictionary to a txt file
 *********************************************************************************************************************/
package assignmentFourDictionary;
import javax.swing.*;
import java.util.*;
import java.io.*;

/** @author Maggie Herms
 */
public class Dictionary {
	private int capacity; //capacity of the dictionary, how many words it can hold
	private String [] words; //dictionary array of strings
	private int numWordsInDictionary = 0; //number of words currently in dictionary, different than capacity
	
	/** default constructor, creates a new string array of length two
	 */
	public Dictionary () {
		this.capacity = 2;
		this.words = new String[capacity];
	}
	
	/** this constructor creates a string array of length equal to the integer passed in as argument
	 * 
	 * @param capacity integer value to set initial length of array
	 */
	public Dictionary (int capacity) {
		this.capacity = capacity;
		this.words = new String[capacity];
	}
	
	/**When the number of words in the dictionary equals the capacity -1, we call the double the size method to double current capacity. 
	 * Creates temporary array of length double that of current words length. Loops through each word in words array and saves it to 
	 * the same index of our temporary array to create a deep copy of words array. 
	 * Sets words array equal to our temporary array and updates the capacity to new words array length
	 */
	private void doubleTheSize () {
		String [] newWordsArray = new String [(words.length * 2)];
		
		for (int i = 0; i < words.length; i++) {
			newWordsArray[i] = words[i];
		}
		words = newWordsArray;
		capacity = words.length;
	}
	
	/**checks two word strings at the index of each character of the string to see if the two words are similar. 
	 * Similar is defined as having at least three consecutive characters of the same value at the same indexes
	 * 
	 * @param wordOne string 
	 * @param wordTwo string 
	 * @return true or false
	 */
	private boolean matched (String wordOne, String wordTwo) {
		int count = 0;
		
		for (int i = 0; i < wordOne.length() && i < wordTwo.length(); i++) {
			if (wordOne.toLowerCase().charAt(i) == wordTwo.toLowerCase().charAt(i)) {
				count++;
			}
		}
		
		if (count >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	/**checks the current words array to see if the argument word equals any word currently in the dictionary
	 * 
	 * @param word - word that we attempt to find in dictionary
	 * @return array index of the found word or -1 if not found
	 */
	public int findWord (String word) {
		for (int i = 0; i < numWordsInDictionary; i++) {
			if (words[i].toLowerCase().equals(word.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	
	/**Adds the argument/parameter word to the dictionary. If number of words in the dictionary is equal to the capacity -1, we call 
	 * the double the size method to double the dictionary capacity, then add the new word and increment our number of words by 1
	 * 
	 * @param word - word to be added to the dictionary
	 */
	public void addWord (String word) {
		if (numWordsInDictionary >= (capacity - 1)) {
			doubleTheSize();
		}
		words[numWordsInDictionary] = word;
		numWordsInDictionary++;
	}
	
	/**Attempts to remove the argument/parameter word from the dictionary. First, check if the argument word is in the dictionary by 
	 * calling the find word method. If the word is in the dictionary, we remove the word by setting it to null and shift our words 
	 * in the words array down to the lower indexes and decrementing our numWordsInDictionary count. 
	 * If the word is not in the dictionary, we do nothing
	 * 
	 * @param word - word to be removed from dictionary
	 */
	public void removeWord (String word) {
		int checkWord = findWord(word);
		
		if (checkWord == -1) {
			return;
		} else {
			words[checkWord] = null;
			for (int i = checkWord; i < numWordsInDictionary; i++) {
				words[i] = words[i+1];
			}
			numWordsInDictionary--;
		}
	}
	
	/** calls the matched method and passes in our argument/parameter word and each word in our dictionary. If the two words are similar
	 * we add the similar word from the dictionary to a string, in all upper case, and return the string of similar words to the user. 
	 * If no words in our dictionary are similar to the parameter word, an empty string is returned
	 * 
	 * @param userWord String, word we attempt to suggest similar words for
	 * @return returns String of similar words, or empty string if no similar words are found
	 */
	public String suggest (String userWord) {
		String matchedWords = "";
		
		for (int i = 0; i < numWordsInDictionary; i++) {
			Boolean matchedResult = matched(userWord, words[i]);
			
			if (matchedResult == true) {
				matchedWords += (words[i].toUpperCase() + " ");
			}
		}
		return matchedWords;
	}
	
	/** creates a new Scanner in file and calls the add word method to load each word of the txt file into our "dictionary" words array
	 * 
	 * @param dictionaryFile location of txt file that we use to load in words to our dictionary from
	 * @throws FileNotFoundException
	 */
	public void loadDictionary (String dictionaryFile) throws FileNotFoundException {
		Scanner inFile = new Scanner (new FileReader(dictionaryFile));
		
		while (inFile.hasNextLine()) {
			String currentWord = inFile.nextLine();
			addWord(currentWord);
		}
		inFile.close();
	}
	
	/** creates a new File out File and new Print Writer. Writes each word of our words array to a new line of the txt file 
	 * in all upper case letters
	 * 
	 * @param dictionaryFile location of new txt file to create, where we save our updated "dictionary"
	 * @throws FileNotFoundException
	 */
	public void saveDictionary (String dictionaryFile) throws FileNotFoundException {
		File outFile = new File (dictionaryFile);
		PrintWriter out = new PrintWriter(outFile);
		
		for (int i = 0; i < numWordsInDictionary; i++) {
			out.println(words[i].toUpperCase()); 
		}
		out.flush();
		out.close();
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
	    	   String fileName = JOptionPane.showInputDialog("Please enter the name of the dictionary file to load"); 
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
