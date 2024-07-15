//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P06 Storage Unit Organizer
// Files: Box.java, StorageUnitTests.java, LinkedBoxList.java, StorageUnitOrganizer.java
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
 * This class models a dynamic list to store box objects sorted in a descendant order with respect
 * to their weights.
 */
public class LinkedBoxList {

  // instance fields
  private LinkedBoxNode head; // head of this LinkedBoxList (refers to the element
                              // stored at index 0 within this list)
  private int size; // number of boxes already stored in this list
  private int capacity; // capacity of this LinkedBoxList
                        // maximum number of box elements that this LinkedBoxList
                        // can store

  /**
   * Creates an empty LinkedBoxList with a given initial capacity.
   * 
   * @param capacity capacity of this LinkedBoxList
   */
  public LinkedBoxList(int capacity) {
    // initialize instance fields
    this.head = null;
    this.size = 0;
    this.capacity = capacity;
  }

  /**
   * Returns the size of this list
   * 
   * @return the size of this list
   */
  public int size() {
    return this.size;
  }

  /**
   * Return the capacity of this list.
   * 
   * @return the capacity of this list
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Expands the capacity of this LinkedBoxList with the specified number a of additional elements.
   * 
   * @param a specified number a of additional elements
   */
  public void expandCapacity(int a) {
    this.capacity = capacity + a;
  }

  /**
   * Checks whether this LinkedBoxList is empty, returns true if this LinkedBoxList is empty, false
   * otherwise.
   * 
   * @return true if LinkedBoxList is empty
   */
  public boolean isEmpty() {
    if (this.head == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks whether this LinkedBoxList is full. Returns true if this list is full, false otherwise
   * 
   * @return true if LinkedBoxList is full
   */
  public boolean isFull() {
    if (this.size == this.capacity) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Adds a new box into this sorted list. Throws IllegalArgumentException if newBox is null. Throws
   * IllegalStateException if this list is full
   * 
   * @param newBox a new box
   * @throws IllegalArgumentException throws if newBox is null
   * @throws IllegalStateException    throws if this list is full
   */
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
    if (newBox == null) {
      throw new IllegalArgumentException("WARNING: Create a Box First!");
    }
    if (this.isFull() == true) {
      throw new IllegalStateException("WARNING: Storage List Full!");
    }
    if (this.head == null) { // if head is null, we need to initialize the head
      this.head = new LinkedBoxNode(null);
      this.head.setBox(newBox); // then set the Box for head to be newBox
    } else { // else if head is not null
      LinkedBoxNode newNode = new LinkedBoxNode(newBox, null); // create temporary node
      LinkedBoxNode currentNode = this.head; // create temporary node to keep track of current node
      if (size == 1) { // special case so we don't run into nullPointerException
        if (newNode.getBox().compareTo(currentNode.getBox()) > 0) { // if new Box is heavier, new
                                                                    // Box will be at the head
          currentNode.setNext(newNode.getNext());
          newNode.setNext(currentNode);
          this.head = newNode;
        } else {
          newNode.setNext(currentNode.getNext());
          currentNode.setNext(newNode);
        }
      } else { // else when size is larger than 1
        boolean replace = false; // initialize a boolean
        while (currentNode.getNext() != null) { // loop through until the desired node
          if (newNode.getBox().compareTo(currentNode.getNext().getBox()) <= 0) {
            currentNode = currentNode.getNext(); // if weight is smaller that existing one, keep
                                                 // looping
          } else if (newNode.getBox().compareTo(currentNode.getNext().getBox()) > 0
              && newNode.getBox().compareTo(this.head.getBox()) < 0) {
            break; // break so we can add new Box at desired place
          } else if (newNode.getBox().compareTo(this.head.getBox()) > 0) {
            this.head = newNode; // special case for the head, we need to change the head to
                                 // accomodate new Box
            newNode.setNext(currentNode);
            replace = true; // switch triggered
            break;
          } else if (newNode.getBox().compareTo(this.head.getBox()) == 0) {
            replace = true;
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            break;
          }
        }
        if (replace == false) { // if switch not triggered, do not have to replace the head
          newNode.setNext(currentNode.getNext());
          currentNode.setNext(newNode);
        } else {
        }
      }
    }
    this.size++;
  }

  /**
   * Checks if this list contains a box that matches with (equals) a specific box object Returns
   * true if this list contains findBox, false otherwise
   * 
   * @param findBox a box that we want to test if is in the list
   * @return true if this list contains findBox
   */
  public boolean contains(Box findBox) {
    boolean isInList = false;
    for (int i = 0; i < this.size(); i++) {
      if (this.get(i).equals(findBox)) {
        isInList = true;
      }
    }
    return isInList;
  }

  /**
   * Returns a box stored in this list given its index, Throws IndexOutOfBoundsException if index is
   * out of the range 0..size-1.
   * 
   * @param index index of the box
   * @return the box with the index
   * @throws IndexOutOfBoundsException throws when the index input is not in proper range
   */
  public Box get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > (this.size - 1)) {
      throw new IndexOutOfBoundsException("Not in proper range");
    }
    LinkedBoxNode currentNode = this.head; // initialize new temporary node
    int place = 0; // initialize new count indicator
    while (place < index) { // keep running the loop until we are at the node we want
      currentNode = currentNode.getNext();
      place++;
    }
    Box boxStored = currentNode.getBox(); // grab the box at the index in the list
    return boxStored;
  }

  /**
   * Removes a returns the box stored at index from this LinkedBoxList. Throws
   * IndexOutOfBoundsException if index is out of bounds. index should be in the range of [0..
   * size()-1]
   * 
   * @param index index of the Box in list
   * @return the Box to be removed
   * @throws IndexOutOfBoundsException if index is out of bounds
   */
  public Box remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > (this.size - 1)) { // throw exception if index is out of the range
      throw new IndexOutOfBoundsException("Not in proper range");
    }
    LinkedBoxNode currentNode = this.head; // initialize temporary node
    LinkedBoxNode prevNode = null; // initialize temporary node to grab the previous node
    int initial = 0; // initialize counter variable
    Box boxStored; // initialize the Box to be returned
    if (this.size == 1) { // if there is only 1 Box, removing the boxStored is equivalent to clear
                          // the List
      boxStored = currentNode.getBox();
      this.head = null;
    } else {
      if (index == 0) { // special case to remove the first Box
        boxStored = this.head.getBox();
        LinkedBoxNode tempNode = this.head.getNext();
        this.head = tempNode; // replace the head with the second node in order
      } else {
        while (initial < index) {
          prevNode = currentNode;
          currentNode = currentNode.getNext(); // loop until we reach the desired Box 
          initial++;
        }
        boxStored = currentNode.getBox(); // get the current Box
        prevNode.setNext(currentNode.getNext()); // remove the node containing boxStored 
      }
    }
    size--;
    return boxStored;
  }

  /**
   * Removes all the boxes from this list
   */
  public void clear() {
    this.size = 0;
    this.head = null;
  }

  /**
   * Returns a String representation for this LinkedBoxList
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();
  }
}
