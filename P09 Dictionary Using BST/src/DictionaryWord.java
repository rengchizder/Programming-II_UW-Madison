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
 * This class model a Dictionary Word.
 *
 */
public class DictionaryWord {
  // instance fields
  private final String word; // Word that represents the search key for this dictionary word
  private final String meaning; // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild; // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

  /**
   * Constructor for this class. Creates a new dictionary word with the provided word and its
   * meaning pair. Throws IllegalArgumentException when the word or meaning are either references to
   * an empty string or null references. The thrown exception should include a significant error
   * message describing which of these problems was encountred.
   * 
   * @param word    the dictionary word
   * @param meaning the meaning of the dictionary word
   */
  public DictionaryWord(String word, String meaning) {
    if (word == null) {
      throw new IllegalArgumentException("null reference for word");
    } else if (word == "") {
      throw new IllegalArgumentException("word is a reference to an empty string");
    } else if (meaning == null) {
      throw new IllegalArgumentException("null reference for meaning");
    } else if (meaning == "") {
      throw new IllegalArgumentException("meaning is a reference to an empty string ");
    }
    this.word = word;
    this.meaning = meaning;
  }

  /**
   * Getter for the left child of this dictionary word
   * 
   * @return the left child of this dictionary word
   */
  public DictionaryWord getLeftChild() {
    return this.leftChild;
  }

  /**
   * Setter for the left child of this dictionary word
   * 
   * @param leftChild word to be set as left child
   */
  public void setLeftChild(DictionaryWord leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * Getter for the right child of this dictionary word
   * 
   * @return the right child of this dictionary word
   */
  public DictionaryWord getRightChild() {
    return this.rightChild;
  }

  /**
   * Getter for the right child of this dictionary word
   * 
   * @param rightChild word to be set as right child
   */
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild;
  }

  /**
   * Getter for the word of this dictionary word
   * 
   * @return the string of this dictionary word
   */
  public String getWord() {
    return this.word;
  }

  /**
   * Getter for the meaning of the word of this dictionary word
   * 
   * @return the meaning of the word of this dictionary word
   */
  public String getMeaning() {
    return this.meaning;
  }

  /**
   * This method returns a String representation of this DictionaryWord.
   * 
   * @return String representation of this DictionaryWord.
   */
  public String toString() {
    String rep; // create a getter string
    rep = this.word + ": " + this.meaning; // format required by the write-up
    return rep;
  }
}
