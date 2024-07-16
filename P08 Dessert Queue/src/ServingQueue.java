//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 Dessert Queue
// Files: QueueTests.java, Guest.java, ServingQueue.java, DessertSolvers.java
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
 * This class implements a queue of Guest objects using an array with circular indexing.
 *
 */
public class ServingQueue {
  // instance and static methods
  private Guest[] array; // array for a queue of Guest objects
  private int size = 0; // current number of guest in the queue
  private final int seatsAtTable; // total seats at table, not growing or changing
  private int enqueueTo = 0; // index to add new Guest object at

  /**
   * Creates a new array based queue with a capacity of "seatsAtTable" guests. This queue should be
   * initialized to be empty.
   * 
   * @param seatsAtTable the size of the array holding this queue data
   */
  public ServingQueue(int seatsAtTable) {
    this.array = new Guest[seatsAtTable]; // initializing the new array
    this.seatsAtTable = seatsAtTable;
  }

  /**
   * Checks whether there are any guests in this serving queue.
   * 
   * @return true when this queue contains zero guests, and false otherwise.
   */
  public boolean isEmpty() {
    if (size == 0) { // return true if there is no guest in the array
      return true;
    } else {
      return false;
    }
  }

  /**
   * Adds a single new guest to this queue (to be served after the others that were previously added
   * to the queue).
   * 
   * @param newGuest is the guest that is being added to this queue.
   * @throws IllegalStateException when called on a ServingQueue with an array that is full
   */
  public void add(Guest newGuest) {
    if (size == seatsAtTable) { // if the array is full, throw exception
      throw new IllegalStateException("Array is full.");
    }
    this.array[enqueueTo] = newGuest;
    size++; // increase the number of Guest in the array
    enqueueTo = (enqueueTo + 1) % seatsAtTable; // update the index for the next Guest, algo from
                                                // class
  }

  /**
   * Accessor for the guest that has been in this queue for the longest. This method does not add or
   * remove any guests.
   * 
   * @return a reference to the guest that has been in this queue the longest.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest peek() {
    if (this.size == 0) { // throw new error if tried to call on empty array
      throw new IllegalStateException("Array is empty.");
    }
    int head = -1;
    if (size > enqueueTo) { // this if-else statement helps us to get the index of the head of the
                            // array, i.e. guest that has been in for longest
      head = enqueueTo + seatsAtTable - size;
    } else {
      head = enqueueTo - size;
    }
    return array[head];
  }

  /**
   * Removes the guest that has been in this queue for the longest.
   * 
   * @return a reference to the specific guest that is being removed.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest remove() {
    if (this.size == 0) { // throw error if no guest is present
      throw new IllegalStateException("Array is empty.");
    }
    int head = -1;
    if (size > enqueueTo) { // getting the head of the array
      head = enqueueTo + seatsAtTable - size;
    } else {
      head = enqueueTo - size;
    }
    Guest removed = array[head]; // grab the Guest that has been in this queue for the longest
    array[head] = null; // remove the Guest from the array
    size--; // reduce the number of Guests in the array
    return removed;
  }

  /**
   * The string representation of the guests in this queue should display each of the guests in this
   * queue (using their toString() implementation), and should display them in a comma separated
   * list that is surrounded by a set of square brackets. (this is similar to the formatting of
   * java.util.ArrayList.toString()). The order that these guests are presented in should be (from
   * left to right) the guest that has been in this queue the longest, to the guest that has been in
   * this queue the shortest. When called on an empty ServingQueue, returns "[]".
   * 
   * @return string representation of the ordered guests in this queue
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    String rep = ""; // initializing the string
    if (this.size == 0) { // when called on empty ServingQueue
      rep = "[]";
    } else {
      int start = -1;
      // to get the head of the array
      if (size > enqueueTo) {
        start = enqueueTo + seatsAtTable - size;
      } else {
        start = enqueueTo - size;
      }
      rep = rep + "[";
      for (int i = 0; i < size; i++) { // loop through the array to the the toString() from each
                                       // Guest
        rep = rep + array[start].toString() + ", ";
        start = (start + 1) % seatsAtTable; // algorithm provided in class
      }
      rep = rep.substring(0, rep.length() - 2) + "]"; // removing excessive parts to meet the
                                                      // ArrayList.toString() method
    }
    return rep;
  }
}
