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
 * This class models a dessert solver that solve different scenarios of dinner table
 *
 */
public class DessertSolvers {
  /**
   * This method solves the problem to get the last guest served
   * 
   * @param numberOfGuests number of guests in the table
   * @param guestsSkipped  how many guests are skipped each time
   * @return last guest served on the table
   */
  public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped) {
    // throw exception if number of guests input is non positive or number of guests skipped is
    // negative
    if (numberOfGuests <= 0 || guestsSkipped < 0) {
      throw new IllegalArgumentException("Bad inputs");
    }
    // creating a new Guest so that we can reset the nextGuest index for every dessert simulation
    Guest guest = new Guest();
    guest.resetNextGuestIndex();
    ServingQueue array = new ServingQueue(numberOfGuests); // creating new ServingQueue with
                                                           // capacity of all the guests
    for (int i = 0; i < numberOfGuests; i++) { // create as many guests as there are
      guest = new Guest();
      array.add(guest); // adding the guests into the ServingQueue
    }
    Guest last = array.remove(); // special case to remove first
    while (array.isEmpty() == false) { // skipping the number of guests to be skipped by removing
                                       // and adding them back to the array
      for (int i = 0; i < guestsSkipped; i++) {
        Guest temp = array.remove();
        array.add(temp);
      }
      last = array.remove(); // grabbing the last Guest to be removed/ or served
    }
    return last;
  }

  /**
   * This method solves the problem to get the first guest to be served dessert
   * 
   * @param numberOfGuests number of guests on the table
   * @param coursesServed  courses of dishes served
   * @return first guest to be served dessert
   */
  public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed) {
    // creating a new Guest so that we can reset the nextGuest index;
    // throw exceptions if number of guests or courses served is non positive
    if (numberOfGuests <= 0 || coursesServed <= 0) {
      throw new IllegalArgumentException("Bad inputs");
    }
    // creating a new Guest so that we can reset the nextGuest index for every dessert simulation
    Guest guest = new Guest();
    guest.resetNextGuestIndex();
    ServingQueue arrayCourse = new ServingQueue(numberOfGuests);// creating new ServingQueue with
                                                                // capacity of all the guests
    for (int i = 0; i < numberOfGuests; i++) { // create as many guests as they are and add them
      guest = new Guest();
      arrayCourse.add(guest);
    }
    Guest last = null; // initialize last guest served in each course
    Guest lastFirst = null; // initialize guest that is served last in the second to last course
    ServingQueue secondArray = new ServingQueue(numberOfGuests); // creating another ServingQueue to
                                                                 // keep track of the orders
    for (int i = 0; i < coursesServed; i++) {
      last = arrayCourse.remove(); // removing the first Guest served (special case)
      secondArray.add(last); // add the first removed Guest served to secondArray
      while (arrayCourse.isEmpty() == false) { // loop through the number of courses served
        Guest temp = arrayCourse.remove(); // remove and add one Guest for skipping
        arrayCourse.add(temp);
        last = arrayCourse.remove(); // remove the Guest served
        secondArray.add(last); // adding the Guest served into secondArray in order
      }
      lastFirst = secondArray.peek();
      arrayCourse = new ServingQueue(numberOfGuests); // refresh the main array for the next course
      arrayCourse.add(last); // rearranging the array so that the last served is the first to serve
                             // in next course
      for (int j = 0; j < numberOfGuests - 1; j++) {
        arrayCourse.add(secondArray.remove()); // reading the other Guests into the main array
      }
      secondArray = new ServingQueue(numberOfGuests); // resetting the secondArray for next course
    }
    return lastFirst;
  }
}
