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
 * This class models a Guest at a dinner party.
 *
 */
public class Guest {
  // Instance and static fields
  private Integer thisIndex = 1; // index of order of arrival for this guest
  private String dietaryRestriction; // dietary restriction for this guest
  private static Integer nextIndex = 1; // to keep track of the index of next guest

  /**
   * Resets the counting of newly constructed guest indexes, so that the next new Guest that is
   * created will be associated with the guest index of one.
   * 
   * Note: that this will be helpful when running several tests, or solving solving several dessert
   * simulation problems. And that this should never be called from ServingQueue.java
   */
  public static void resetNextGuestIndex() {
    nextIndex = 1; // so that the next new Guest that is created will be associated with guest index
                   // of one.
  }

  /**
   * Constructs a new guest with no dietary restrictions. This guest should be associated with an
   * index that is one larger than the previously constructed guest (or 1, if no prior guest, or if
   * resetNextGuestIndex() was called more recently).
   */
  public Guest() {
    this.thisIndex = nextIndex; // initialize the new guest
    nextIndex++; // increase the index for next guest
  }

  /**
   * Constructs a new guest with the specified dietary restrictions. This guest should be associated
   * with an index that is one larger than the previously constructed guest (or 1, if no prior
   * guest, or if resetNextGuestIndex() was called more recently).
   * 
   * @param dietaryRestriction describes requirements for what this guest can and cannot eat
   */
  public Guest(String dietaryRestriction) {
    this.dietaryRestriction = dietaryRestriction; // initialize the new guest with dietary
                                                  // restriction
    this.thisIndex = nextIndex;
    nextIndex++; // increase the index for next guest
  }

  /**
   * Access whether this guest has any dietary restrictions or not
   * 
   * @return true for guests constructed using new Guest(String), false otherwise
   */
  public boolean hasDietaryRestriction() {
    if (this.dietaryRestriction != null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * The string representation of a Guest should be formatted as, for examples: #3(no dairy) for a
   * guest with a guest index of 3 and the dietary restriction of "no dairy", or: #4 for a guest
   * with a guest index of 4 and no dietary restriction
   * 
   * @return string representing the guest index and any dietary restriction they might have
   * @see java.lang.Object#toString()
   */
  public String toString() {
    String rep; // a instance variable to get the string output
    if (this.hasDietaryRestriction() == true) { // adding the dietary restriction 
      rep = ("#" + this.thisIndex + "(" + this.dietaryRestriction + ")");
    } else {
      rep = ("#" + this.thisIndex);
    }
    return rep;
  }
}
