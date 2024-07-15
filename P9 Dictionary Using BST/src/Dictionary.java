//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P09 Dictionary Using BST
// Files: Dictionary.java, DictionaryWord.java, DictionaryBST.java, DictionaryDriver.java,
//////////////////// DictionaryTests.java
// Course: CS300 Spring 2019
//
// Author: Reng Chiz Der
// Email: rder@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////
/**
 * This class model a Dictionary interface.
 *
 */
public interface Dictionary {

  /**
   * This method return true if dictionary is empty
   * 
   * @return true if dictionary is empty
   */
  public boolean isEmpty();

  /**
   * This method adds this word definition (word and the provided meaning) to the dictionary It
   * returns true if the word was successfully added to this dictionary, returns false if the word
   * was already in the dictionary It throws IllegalArgumentException if either word or meaning is
   * null or an empty string
   * 
   * @param word    string of word
   * @param meaning string of meaning of word
   * @return true if word was successfully added to this dictionary
   */
  public boolean addWord(String word, String meaning);

  /**
   * This method returns the meaning of the word s if it is present in this dictionary or throws a
   * NoSuchElementException if the word s was not found in this dictionary
   * 
   * @param s a string of word
   * @return meaning of word s if it is present in this dictionary
   */
  public String lookup(String s);

  /**
   * This method returns the number of words stored in this dictionary
   * 
   * @return number of words stored in this dictionary
   */
  public int size();
}

