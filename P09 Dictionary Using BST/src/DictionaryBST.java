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
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class model a DictionaryBST which implements Dictionary
 *
 */
public class DictionaryBST implements Dictionary {
  // instance field
  private DictionaryWord root;

  /**
   * The constructor of this class, creates an empty dictionaryBST
   */
  public DictionaryBST() {
    this.root = null;
  }

  // Methods defined in the Dictionary interface
  /**
   * This method return true if dictionary is empty
   * 
   * @return true if dictionary is empty
   */
  @Override
  public boolean isEmpty() {
    if (this.root == null) {
      return true;
    } else {
      return false;
    }
  }

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
  @Override
  public boolean addWord(String word, String meaning) {
    DictionaryWord newWordNode = new DictionaryWord(word, meaning); // create a new word
    if (this.root == null) {
      this.root = newWordNode;
      return true; // if root is empty, simply add the word node to the root
    } else {
      return addWordHelper(newWordNode, this.root); // call helper method if root is not empty
    }
  }

  /**
   * This method returns the meaning of the word s if it is present in this dictionary or throws a
   * NoSuchElementException if the word s was not found in this dictionary
   * 
   * @param s a string of word
   * @return meaning of word s if it is present in this dictionary
   */
  @Override
  public String lookup(String s) {
    return lookupHelper(s, root); // call private helper method
  }

  /**
   * This method returns the number of words stored in this dictionary
   * 
   * @return number of words stored in this dictionary
   */
  @Override
  public int size() {
    return sizeHelper(this.root); // call private helper method
  }

  // Public methods not defined in the Dictionary interface
  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from root to the
   * deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
      return 1 + heightHelper(root);
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the ascendant
   *         order
   */
  public ArrayList<String> getAllWords() {
    if (this.root == null) { // if dictionaryBST is empty, return empty ArrayList
      return new ArrayList<String>();
    } else {
      ArrayList<String> list = new ArrayList<String>();
      list.addAll(getAllWordsHelper(this.root)); // else, call recursive private helper method, with
                                                 // root
      return list;
    }
  }

  // Recursive private helper methods
  // Each public method should make call to the recursive helper method with the
  // corresponding name
  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where newWord
   *                    will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
    boolean inserted = true; // create a boolean and set to true
    while (current != null) { // keep recursing and adding newWord to the subtree
      if (current.getWord().compareToIgnoreCase(newWordNode.getWord()) > 0) {
        if (current.getLeftChild() == null) {
          current.setLeftChild(newWordNode);
          break;
        } else {
          current = current.getLeftChild();
        }
      } else if (current.getWord().compareToIgnoreCase(newWordNode.getWord()) < 0) {
        if (current.getRightChild() == null) {
          current.setRightChild(newWordNode);
          break;
        } else {
          current = current.getRightChild();
        }
      } else if (current.getWord().compareToIgnoreCase(newWordNode.getWord()) == 0) {
        inserted = false;
        break;
      } else {
      }
    }
    return inserted;
  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {
    String rep = null; // create an empty string
    while (current != null) { // keep recursing to lookup a word in the subtree
      if (current.getWord().toLowerCase().equals(s.toLowerCase())) {
        rep = current.getMeaning();
        break;
      } else if (current.getWord().compareToIgnoreCase(s) > 0) {
        current = current.getLeftChild();
      } else if (current.getWord().compareToIgnoreCase(s) < 0) {
        current = current.getRightChild();
      }
    }
    if (rep == null) {
      throw new NoSuchElementException("No definition found for the word " + s);
    }
    return rep;
  }

  /**
   * Recursive helper method that returns the number of dictionary words stored in the subtree
   * rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    if (current == null) {
      return 0;
    }
    // return root at current and its children
    return 1 + sizeHelper(current.getLeftChild()) + sizeHelper(current.getRightChild());
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord nodes
   *         from the current node to the deepest leaf in the subtree rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    if (current == null) {
      return -1;
    }
    int leftHeight = heightHelper(current.getLeftChild()); // getting the height of subtree rooted
                                                           // at left child
    int rightHeight = heightHelper(current.getRightChild()); // getting the height of subtree rooted
                                                             // at right child
    return 1 + Math.max(leftHeight, rightHeight); // adding 1 to account to current (root)
  }



  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree rooted at
   * current
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    ArrayList<String> list = new ArrayList<String>(); // create new ArrayList
    if (current.getLeftChild() != null) { // add left child
      list.addAll(getAllWordsHelper(current.getLeftChild()));
    }
    list.add(current.getWord()); // add current node (root)
    if (current.getRightChild() != null) {
      list.addAll(getAllWordsHelper(current.getRightChild())); // add right child
    }
    return list;
  }
}

