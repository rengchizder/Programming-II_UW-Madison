//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Help Desk
// Files: SupportTicket.java, HelpDesk.java, HelpDeskTestSuite.java, HelpDeskInterface.java
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
 * This class contain implementation of a priority queue and implements HelpDeskInterface
 *
 */
public class HelpDesk implements HelpDeskInterface {
  // instance fields
  protected SupportTicket[] array; // zero-indexed max-heap
  protected int size; // the number of tickets in this array

  /**
   * Constructor a new HelpDesk with internal array capacity
   * 
   * @param capacity of the array
   */
  public HelpDesk(int capacity) {
    this.array = new SupportTicket[capacity]; // initialize a new array with capacity
    this.size = 0; // initialize the size at 0
  }

  /**
   * Creates and adds a new SupportTicket to this HelpDesk.
   * 
   * @param message names the client and describes their need for support.
   * @throws NullPointerException      when the String message argument is null.
   * @throws IndexOutOfBoundsException when called on HelpDesk with a full array
   */
  @Override
  public void createNewTicket(String message) {
    if (message == null) { // throw NullPointerException when string message argument is null
      throw new NullPointerException("The String message argument is null.");
    } else if (size == (this.array.length)) { // throw IndexOutOfBoundsException when called on
                                              // HelpDesk with full array
      throw new IndexOutOfBoundsException("HelpDesk array is full.");
    }
    SupportTicket ticket = new SupportTicket(message); // create new SupportTicket with string
                                                       // message
    array[size] = ticket; // assign the ticket to the end of the arrays of tickets
    propagateUp(this.size); // then propagateUp to make sure it follows max heap
    this.size++; // increase the number of tickets that this array has
  }

  /**
   * Returns the message within this HelpDesk that has the highest priority. This method does not
   * change the state of this HelpDesk.
   * 
   * @return the message within the highest priority SupportTicket.
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  @Override
  public String checkNextTicket() {
    if (this.size == 0) { // throw IllegalStateException HelpDesk with zero SupportTickets
      throw new IllegalStateException("HelpDesk with zero SupportTickets.");
    }
    int i = 0; // starting from the top of array
    while (i < array.length) { // loop through the array to find the first non-null element
      if (array[i] != null) { // we could have just called the first element/SupportTicket from the
                              // array but this helps with testing
        return array[i].toString();
      } else {
        i++;
      }
    }
    return array[0].toString(); // return the string message that has the highest priority
  }

  /**
   * Returns and removes the message within this HelpDesk that has the highest priority.
   * 
   * @return the message within the highest priority SupportTicket (prior to its removal).
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  @Override
  public String closeNextTicket() {
    if (this.size == 0) { // throw IllegalStateException when HelpDesk has 0 SupportTickets
      throw new IllegalStateException("HelpDesk with zero SupportTickets.");
    }
    String temp = array[0].toString(); // get the message of highest priority
    array[0] = array[size - 1]; // put the last message to the front of array
    array[size - 1] = null; // and setting the original place it had to be null
    this.size--; // reduce the number of SupportTickets by one
    propagateDown(0); // propagate down to make sure it follows Max Heap
    return temp; // return the message of highest priority
  }

  /**
   * Given an index into the heap array, this method returns that index's parent index.
   * 
   * @param index an index
   * @return the index's parent index
   */
  protected static int parentOf(int index) {
    if (index > 0) {
      return ((index - 1) / 2); // formula from lecture
    } else {
      return -1; // return -1 if the index called if the root
    }
  }

  /**
   * Given an index into the heap array, this method returns that index's left child index
   * 
   * @param index an index
   * @return that index's left child index
   */
  protected static int leftChildOf(int index) {
    return ((2 * index) + 1); // formula from lecture
  }

  /**
   * Given an index into the heap array, this method returns that index's right child index
   * 
   * @param index an index
   * @return that index's right child index
   */
  protected static int rightChildOf(int index) {
    return ((2 * index) + 2); // formula from lecture
  }

  /**
   * Given two indexes into the heap array, this method swaps the SupportTickets at those indexes
   * 
   * @param indexA first index
   * @param indexB second index
   */
  protected void swap(int indexA, int indexB) {
    SupportTicket temp = array[indexA]; // saving the SupportTicket A to temporary
    array[indexA] = array[indexB];
    array[indexB] = temp;
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets necessary
   * to enforce the heap's order property between this index and the heap's root
   * 
   * @param index the index
   */
  protected void propagateUp(int index) {
    // to enforce the heap's order property by swapping if needed and then recursively
    if (parentOf(index) != -1 && array[index].compareTo(array[parentOf(index)]) > 0) {
      swap(index, parentOf(index));
      propagateUp(parentOf(index));
    }
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets necessary
   * to enforce the heap's order property between this index and it's children
   * 
   * @param index the index
   */
  protected void propagateDown(int index) {
    int leftChild = leftChildOf(index); // left child of current Ticket
    int rightChild = rightChildOf(index); // right child of current Ticket
    int max = -1;
    if (leftChild < this.size && array[leftChild].compareTo(array[index]) > 0) {
      max = leftChild;
      if (rightChild < this.size && array[rightChild].compareTo(array[leftChild]) > 0) {
        max = rightChild;
      }
      // swapping current ticket with the maximum of left/right child
      // then propagate down recursively to enfore heap's order property
      swap(index, max);
      propagateDown(max);
    } else {
    }
  }
}
