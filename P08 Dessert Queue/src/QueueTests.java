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
 * Test class for queue methods, also including a test for the functionality of the Guest class
 *
 */
public class QueueTests {

  /**
   * Main method used to call the tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Calling different tests
    if (testGuest() == false) {
      System.out.println("Guest class failed to work properly.");
    } else {
      System.out.println("Passed Guest class test.");
    }
    if (testServingQueuePeekToStringAndIsEmptyMethods() == false) {
      System.out.println(
          "One or more of the ServingQueue peek, toString, isEmpty methods failed to work properly");
    } else {
      System.out.println("Passed ServingQueue peek, toString, isEmpty methods test.");
    }
    if (testServingQueueAddMethod() == false) {
      System.out.println("ServingQueue's add method failed to work properly.");
    } else {
      System.out.println("Passed ServingQueue's add method test.");
    }
    if (testServingQueueRemoveMethod() == false) {
      System.out.println("ServingQueue's remove method failed to work properly.");
    } else {
      System.out.println("Passed ServingQueue's remove method test.");
    }
  }

  /**
   * Test the functionality of the Guest class by testing constructor, resetNextGuestIndex, and
   * hasDietaryRestriction methods in particular
   * 
   * @return true if it is functioning well
   */
  public static boolean testGuest() {
    boolean correct = true; // create a boolean variable and initialize to true
    // test whether resetNextGuestIndex() and constructor methods work well
    Guest test1 = new Guest();
    Guest test2 = new Guest();
    test2.resetNextGuestIndex();
    Guest test3 = new Guest();
    if (!test3.toString().equals("#1")) {
      correct = false;
    }

    // test whether the constructor for guest with dietary restriction works properly
    Guest testDietary = new Guest("Dairy");
    if (!testDietary.toString().equals("#2(Dairy)")) {
      correct = false;
    }
    Guest testDietary2 = new Guest("no dairy");
    if (!testDietary2.toString().equals("#3(no dairy)")) {
      correct = false;
    }

    // test whether the hasDietaryRestriction method works properly
    if (testDietary2.hasDietaryRestriction() != true || test3.hasDietaryRestriction() != false) {
      correct = false;
    }
    testDietary2.resetNextGuestIndex(); // resetting the nextIndex for the next test method
    return correct;
  }

  /**
   * Test the functionality of the ServingQueue class, tests include isEmpty, peek, toString method
   * tests
   * 
   * @return true if it is functioning well
   */
  public static boolean testServingQueuePeekToStringAndIsEmptyMethods() {
    boolean correct = true; // create a boolean variable and initialize to false
    ServingQueue array = new ServingQueue(8);
    // Check if peek() method works correctly on empty array
    try {
      array.peek();
    } catch (Exception e) {
      if (e.getMessage() != "Array is empty.") {
        correct = false;
      }
    }

    // Check whether isEmpty() method works properly
    if (array.isEmpty() != true) {
      correct = false;
    }

    // Check if peek() method works correctly
    Guest test1 = new Guest();
    array.add(test1);
    if (array.peek() != test1) {
      correct = false;
    }

    // Check whether isEmpty() method works properly when it is not empty
    if (array.isEmpty() == true) {
      correct = false;
    }

    // Check whether toString() method works properly for the array
    Guest test2 = new Guest();
    Guest test3 = new Guest("no dairy");
    Guest test4 = new Guest();
    array.add(test2); // adding new Guests
    array.add(test3);
    array.add(test4);
    if (!array.toString().equals("[#1, #2, #3(no dairy), #4]")) {
      correct = false;
    }
    test4.resetNextGuestIndex(); // resetting the nextGuest index for the next test
    return correct;
  }

  /**
   * Test the functionality of the ServingQueue class's add method
   * 
   * @return true if it is functioning well
   */
  public static boolean testServingQueueAddMethod() {
    boolean correct = true;
    // test if add() method works properly for the array
    ServingQueue smallArray = new ServingQueue(2);
    Guest test1 = new Guest();
    Guest test2 = new Guest();
    Guest test3 = new Guest();
    smallArray.add(test1);
    smallArray.add(test2);
    try {
      smallArray.add(test3); // trying to add more Guest than the capacity of the array has
    } catch (Exception e) {
      if (!e.getMessage().equals("Array is full.")) {
        correct = false;
      }
    }

    // test if the correct index is added to the right place in the array
    Guest test4 = new Guest();
    smallArray.remove();
    smallArray.add(test4);
    if (!smallArray.toString().equals("[#2, #4]")) {
      correct = false;
    }
    test4.resetNextGuestIndex(); // resetting the nextIndex for the next test method
    return correct;
  }

  /**
   * Test the functionality of the ServingQueue class's remove method
   * 
   * @return true if it is functioning well
   */
  public static boolean testServingQueueRemoveMethod() {
    boolean correct = true;
    // test if remove method works properly for the array
    ServingQueue emptyArray = new ServingQueue(2);
    try {
      emptyArray.remove();
    } catch (Exception e) { // test to remove when array is empty
      if (!e.getMessage().equals("Array is empty.")) {
        correct = false;
      }
    }
    ServingQueue smallArray = new ServingQueue(2);
    Guest test1 = new Guest();
    smallArray.add(test1);
    if (smallArray.remove() != test1) { // test to remove when array is not empty
      correct = false;
    }
    test1.resetNextGuestIndex(); // resetting the nextIndex for the next test method
    return correct;
  }
}
