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
 * Test class for the correct implementations of classes in this project.
 *
 */
public class DictionaryTests {

  /**
   * Main method to test
   * 
   * @param args
   */
  public static void main(String[] args) {
    // try all the five tests
    if (testDictionaryWordConstructor() == true) {
      System.out.println("Passed testDictionaryWordConstructor test");
    } else {
      System.out.println("Failed testDictionaryWordConstructor test");
    }
    if (testDictionaryWordGettersSetters() == true) {
      System.out.println("Passed testDictionaryWordGettersSetters test");
    } else {
      System.out.println("Failed testDictionaryWordGettersSetters test");
    }
    if (testDictionaryBSTAddWordMethod() == true) {
      System.out.println("Passed testDictionaryBSTAddWordMethod test");
    } else {
      System.out.println("Failed testDictionaryBSTAddWordMethod test");
    }
    if (testDictionaryBSTIsEmptyLookupSizeMethods() == true) {
      System.out.println("Passed testDictionaryBSTIsEmptyLookupSizeMethods test");
    } else {
      System.out.println("Failed testDictionaryBSTIsEmptyLookupSizeMethods test");
    }
    if (testDictionaryBSTNotOverwrittenMethods() == true) {
      System.out.println("Passed testDictionaryBSTNotOverwrittenMethods test");
    } else {
      System.out.println("Failed testDictionaryBSTNotOverwrittenMethods test");
    }
  }

  /**
   * Test to see if DictionaryWord constructor works well.
   * 
   * @return true if it is functioning well
   */
  public static boolean testDictionaryWordConstructor() {
    boolean correct = true; // create a boolean variable and initialize to true
    // the first four tests test if whethey any of the word or meaning is null or reference to empty
    // string
    try {
      DictionaryWord word1 = new DictionaryWord(null, "word"); // null word
    } catch (Exception e) {
      if (e.getMessage() != "null reference for word") {
        correct = false;
      }
    }
    try {
      DictionaryWord word2 = new DictionaryWord("word", null); // null meaning
    } catch (Exception e) {
      if (e.getMessage() != "null reference for meaning") {
        correct = false;
      }
    }
    try {
      DictionaryWord word3 = new DictionaryWord("", "meaning"); // empty word
    } catch (Exception e) {
      if (e.getMessage() != "word is a reference to an empty string") {
        correct = false;
      }
    }
    try {
      DictionaryWord word4 = new DictionaryWord("word", ""); // empty meaning
    } catch (Exception e) {
      if (e.getMessage() != "meaning is a reference to an empty string ") {
        correct = false;
      }
    }

    // test to see if word and meaning is correctly constructed with the new DictionaryWord
    DictionaryWord wordGood = new DictionaryWord("word", "meaning");
    if (wordGood.getWord() != "word") {
      correct = false;
    } else if (wordGood.getMeaning() != "meaning") {
      correct = false;
    }
    return correct;
  }

  /**
   * Test to see if DictionaryWord getters and setters work well.
   * 
   * @return true if it is functioning well
   */
  public static boolean testDictionaryWordGettersSetters() {
    boolean correct = true; // create a boolean variable and initialize to true
    DictionaryWord word = new DictionaryWord("word", "meaning hi");
    DictionaryWord rightChild = new DictionaryWord("Right child", "a baby");
    // test getter methods
    if (word.getWord() != "word") {
      correct = false;
    } else if (word.getMeaning() != "meaning hi") {
      correct = false;
    } else if (word.getLeftChild() != null) {
      correct = false;
    }
    word.setRightChild(rightChild); // setting word's right child to child
    // test setter methods
    if (word.getRightChild() != rightChild) {
      correct = false;
    }
    DictionaryWord leftChild = new DictionaryWord("Left child", "a baby");
    word.setLeftChild(leftChild);
    if (word.getLeftChild() != leftChild) {
      correct = false;
    }
    return correct;
  }

  /**
   * Test to see if DictionaryBST's addWord method working properly.
   * 
   * @return true if it is functioning well
   */
  public static boolean testDictionaryBSTAddWordMethod() {
    boolean correct = true; // create a boolean variable and initialize to true
    DictionaryBST dictionary = new DictionaryBST();
    if (dictionary.addWord("word", "meaning") != true) {
      correct = false;
    } else if (dictionary.addWord("word", "same meaning") != false) { // test try to add duplicate
                                                                      // words
      correct = false;
    }
    // test to see if errors are thrown correctly
    try {
      dictionary.addWord("", "meaning");
    } catch (Exception e) {
      if (!e.getMessage().equals("word is a reference to an empty string")) {
        correct = false;
      }
    }
    try {
      dictionary.addWord(null, "meaning");
    } catch (Exception e) {
      if (!e.getMessage().equals("null reference for word")) {
        correct = false;
      }
    }
    try {
      dictionary.addWord("word", "");
    } catch (Exception e) {
      if (!e.getMessage().equals("meaning is a reference to an empty string ")) {
        correct = false;
      }
    }
    try {
      dictionary.addWord("word", null);
    } catch (Exception e) {
      if (!e.getMessage().equals("null reference for meaning")) {
        correct = false;
      }
    }
    return correct;
  }

  /**
   * Test to see if DictionaryBST's methods from Dictionary interface other than addWord method
   * working properly The methods are isEmpty, lookup and size methods
   * 
   * @return true if it is functioning well
   */
  public static boolean testDictionaryBSTIsEmptyLookupSizeMethods() {
    boolean correct = true; // create a boolean variable and initialize to true
    DictionaryBST dictionary = new DictionaryBST();
    // when dictionary empty
    if (dictionary.isEmpty() != true) { // testing isEmpty() method
      correct = false;
    }
    if (dictionary.size() != 0) { // testing size() method
      correct = false;
    }
    try {
      dictionary.lookup("hello"); // testing lookup() method
    } catch (Exception e) {
      if (!e.getMessage().equals("No definition found for the word hello")) {
        correct = false;
      }
    }
    // when dictionary not empty
    dictionary.addWord("a", "meaning");
    if (dictionary.isEmpty() != false) { // testing isEmpty() method
      correct = false;
    }
    if (dictionary.size() != 1) { // testing size() method
      correct = false;
    }
    dictionary.addWord("b", "meaning");
    if (dictionary.size() != 2) {
      correct = false;
    }
    if (dictionary.lookup("a") != "meaning") { // testing lookup method
      correct = false;
    }
    try {
      dictionary.lookup("c"); // testing lookup method when dictionary not empty, and word not in
                              // dic
    } catch (Exception e) {
      if (!e.getMessage().equals("No definition found for the word c")) {
        correct = false;
      }
    }
    return correct;
  }

  /**
   * Test to see if DictionaryBST's not overwritten methods are working properly, namely height()
   * and getAllWords() method
   * 
   * @return true if it is functioning well
   */
  public static boolean testDictionaryBSTNotOverwrittenMethods() {
    boolean correct = true; // create a boolean variable and initialize to true
    DictionaryBST dictionary = new DictionaryBST();
    // test getAllWords when dictionary is empty
    if (!dictionary.getAllWords().isEmpty()) {
      correct = false;
    }
    // test height when dictionary is empty
    if (dictionary.height() != 0) {
      correct = false;
    }
    // test height when dictionary has 1 node
    dictionary.addWord("hello", "meaning");
    if (dictionary.height() != 1) {
      correct = false;
    }

    // test getAllWords when dictionary not empty
    if (dictionary.getAllWords().get(0) != "hello") {
      correct = false;
    }
    // test height when dictionary has 3 nodes, and height is three
    dictionary.addWord("a", "meaning");
    dictionary.addWord("c", "meaning");

    if (dictionary.height() != 3) {
      correct = false;
    }
    // test if getAllWords() arrange the terms properly
    if (dictionary.getAllWords().get(0) != "a" || dictionary.getAllWords().get(1) != "c"
        || dictionary.getAllWords().get(2) != "hello") {
      correct = false;
    }
    return correct;
  }
}
