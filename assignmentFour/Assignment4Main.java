import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * <p>Title: Assignment 4</p>
 * <p>Description: Interactive dictionary demonstrating file processing</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: UWRF</p>
 * @author Hossein L Najafi
 * @version 3.0
 */


public class Assignment4Main{

  public static void main(String[] args) throws FileNotFoundException{
    Dictionary d = new Dictionary();
    final int LOAD = 1, SAVE = 2, CHECK_FILE = 3, CHECK_WORD = 4, ADD_WORD = 5, REMOVE_WORD = 6, SUGGEST_WORD = 7, QUIT = 8;


    JOptionPane.showMessageDialog(null, "This program implements an interactive dictionary. It would allow you to add new words to a dictinary,\n" +
    		                            "remove words from the dictionary.  Spell check a word with the dictgionary, or suggest correct speccing for\n" +
    		                            "a word.  In addition, you can load a dictionary of words,save the current dictionary to a file and spell\n" +
    		                            "check a given file.\n\n");
    int userSelection = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do?  Please eneter the number next to your selection\n" +
    		                                        "1: Load Dictionary from File\n" +
    		                                        "2: Save Dictionary to file\n" +
    		                                        "3: Spell check the a file\n" +
    		                                        "4: Spell check a word\n" +
    		                                        "5: Add a word to dictionary\n" +
    		                                        "6: Remove a word from dictionary\n" +
    		                                        "7: Suggest correct spelling for a wrod\n" +
    		                                        "8: Quit\n"));

    while (userSelection !=QUIT){
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
    		   JOptionPane.showMessageDialog(null, "Missspelled Words Are: "+misspelledWords);
    	   else
    		   JOptionPane.showMessageDialog(null, "No spelling errors were found");

    	   inFile.close();  	   
    	   break;
       case CHECK_WORD:
    	   String wordToSpellCheck = JOptionPane.showInputDialog("Please enter the word you want to spell check");
    	   if(d.findWord(wordToSpellCheck) <0)
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
       userSelection = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do next?  Please eneter the number next to your selection\n" +
    		   "1: Load Dictionary from File\n" +
               "2: Save Dictionary to file\n" +
               "3: Spell check the a file\n" +
               "4: Spell check a word\n" +
               "5: Add a word to dictionary\n" +
               "6: Remove a word from dictionary\n" +
               "7: Suggest correct spelling for a wrod\n" +
               "8: Quit\n"));
    }
  }
}
