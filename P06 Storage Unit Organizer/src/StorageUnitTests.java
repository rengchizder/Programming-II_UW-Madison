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
 * A class that contains multiple tests that test for the good functioning of different methods for
 * the classes of this file
 */
public class StorageUnitTests {

  /**
   * main method used to call the unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    // different tests using methods below, if any of the test fails, it will output error
    // statements
    if (testBoxEquals() != true) {
      System.out.println("Equals method failed to work.");
    }
    if (testBoxCompareTo() != true) {
      System.out.println("compareTo method failed to work.");
    }
    if (testLinkedBoxNodeImplementation() != true) {
      System.out.println("The linked box node implementation failed to work.");
    }
    if (testLinkedBoxListRemove() != true) {
      System.out.println("The remove() method failed to work.");
    }
    if (testLinkedBoxListBasicMethods() != true) {
      System.out.println("The basic methods and constructor for LinkedBoxList failed to work");
    }
    if (testLinkedBoxListRemainingMethod() != true) {
      System.out.println("The remaining methods of LinkedBoxList failed to work.");
    }
  }

  /**
   * Checks whether the behavior of equals method is correct
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testBoxEquals() {
    boolean correct = false; // initialize the boolean of test passed to false
    // create new boxes
    try {
      Box box = new Box(5, 31); // error should be thrown if parameter for weight is out of range
    } catch (IllegalArgumentException e) {
      correct = true;
    }
    Box box1 = new Box(5, 30);
    Box box2 = new Box(4, 28);
    Box box3 = new Box(5, 28);
    Box box4 = new Box(5, 30);
    if (box1.equals(box2) != false) { // box1 and box2 should not be equal
      correct = false;
    } else if (box1.equals(box3) != false) {
      correct = false;
    } else if (box1.equals(box4) != true) { // box1 and box4 should be equal since they have same
                                            // color and weight
      correct = false;
    }
    return correct;
  }

  /**
   * Checks whether the behavior of compareTo method is correctly implemented.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testBoxCompareTo() {
    boolean correct = true; // initialize the boolean of test passed to true
    // create new boxes
    Box box1 = new Box(5, 20);
    Box box2 = new Box(4, 10);
    Box box3 = new Box(5, 30);
    Box box4 = new Box(5, 20);
    if (box1.compareTo(box2) <= 0) { // box1 has larger weights than box2
      correct = false;
    } else if (box1.compareTo(box3) >= 0) { // box1 should have smaller weights than box3
      correct = false;
    } else if (box1.compareTo(box4) != 0) { // box1 should have equal weights compared to box4
      correct = false;
    }
    return correct;
  }

  /**
   * Checks if the linkedBoxNode class can be implemented correctly, and the methods work well.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLinkedBoxNodeImplementation() {
    boolean correct = true; // initialize the boolean of test passed to true
    Box box = new Box(12, 12); // new box to test getters method
    LinkedBoxNode link = new LinkedBoxNode(box);
    if (link.getBox() != box) {
      correct = false;
    } else if (link.getNext() != null) {
      correct = false;
    }

    // new boxes to test setters method
    Box box2 = new Box(12, 15);
    Box box3 = new Box(13, 16);
    // new link to test constructor method
    LinkedBoxNode testLink = new LinkedBoxNode(box2);
    testLink.setBox(box3);
    link.setNext(testLink);
    if (testLink.getBox() != box3) {
      correct = false;
    } else if (link.getNext() != testLink) {
      correct = false;
    }
    return correct;
  }

  /**
   * Checks whether remove method defined in your LinkedBoxList works correctly.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLinkedBoxListRemove() {
    boolean correct = true; // initialize the boolean of test passed to true
    LinkedBoxList list = new LinkedBoxList(20); // create a new LinkedBoxList with capacity of 2
    Box newBox = new Box(12, 12);
    Box newBox2 = new Box(12, 9);
    list.add(newBox);
    list.add(newBox2);
    list.remove(0); // remove first element
    if (list.get(0) != newBox2) {
      correct = false;
    }
    // test exception
    try {
      correct = false; // trigger switch to make sure exception is getting caught
      list.get(1);
    } catch (IndexOutOfBoundsException e) {
      correct = true;
    }
    Box newBox3 = new Box(13, 16);
    Box newBox4 = new Box(13, 18);
    Box newBox5 = new Box(13, 7);
    list.add(newBox3);
    list.add(newBox4);
    list.add(newBox5);
    // test to see if removing the first Box works properly
    list.remove(0);
    if (list.get(0) != newBox3) {
      correct = false;
    }
    // test if removing last Box works properly
    list.add(newBox4);
    list.remove(3);
    if (list.get(2) != newBox2) {
      correct = false;
    }

    // test if we have 2 boxes with same weights but different color, removing one of them works
    // properly
    Box newBox6 = new Box(15, 18);
    list.add(newBox6);
    list.remove(0);
    if (list.get(0) != newBox6) {
      correct = false;
    }
    return correct;
  }

  /**
   * Checks if the basic methods and constructors of the LinkedBoxList class works correctly. Basic
   * methods include isFull(), isEmpty(), expandCapacity(), contains() and constructor.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLinkedBoxListBasicMethods() {
    boolean correct = true; // initialize the boolean of test passed to true
    LinkedBoxList list = new LinkedBoxList(2); // create a new LinkedBoxList with capacity of 2
    // test constructor
    if (list.size() != 0 || list.getCapacity() != 2) {
      correct = false;
    }
    // test isEmpty() method
    if (list.isEmpty() != true) {
      correct = false;
    }
    // create new boxes to test isFull() method
    Box newBox = new Box(12, 12);
    Box newBox2 = new Box(12, 12);
    list.add(newBox);
    list.add(newBox2);
    if (list.isFull() != true) {
      correct = false;
    }
    // test expandCapacity() method
    list.expandCapacity(2);
    if (list.getCapacity() != 4 || list.size() != 2) { // also cross-checking if size is increased
      correct = false;
    }
    // test contains() method
    Box newBoxNotIn = new Box(13, 13);
    if (list.contains(newBox2) != true || list.contains(newBoxNotIn) != false) {
      correct = false;
    }
    // System.out.println(list.toString());
    return correct;
  }


  /**
   * Checks whether other methods of LinkedBoxList class works correctly. Methods tested include
   * clear(), get(),
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLinkedBoxListRemainingMethod() {
    boolean correct = true; // initialize the boolean of test passed to true
    LinkedBoxList list = new LinkedBoxList(2); // create a new LinkedBoxList with capacity of 2
    Box newBox = new Box(15, 12);
    Box newBox2 = new Box(12, 18);
    list.add(newBox);
    list.add(newBox2);
    list.clear();
    if (list.size() != 0 || list.getCapacity() != 2) {
      correct = false;
    }
    // test get() method
    try {
      correct = false; // to make sure the catch exception works well
      list.get(0);
    } catch (IndexOutOfBoundsException e) {
      correct = true;
    }
    try {
      correct = false; // to make sure the catch exception works well
      list.get(2);
    } catch (IndexOutOfBoundsException e) {
      correct = true;
    }
    list.add(newBox);
    list.add(newBox2);
    if (list.get(1) != newBox) { // newBox2 has heavier weight so at index 1
      correct = false;
    }
    // System.out.println(list.toString());
    // test add() method
    Box nullBox = null;
    try {
      correct = false;
      list.add(nullBox);
    } catch (IllegalArgumentException e) {
      correct = true;
    }
    // create boxes with different weights and see if the list works
    list.clear(); // reset the list
    list.expandCapacity(10); // expand the list to have more Boxes
    Box lightBox = new Box(12, 5);
    Box medBox = new Box(12, 10);
    Box heavyBox = new Box(12, 16);
    list.add(medBox);
    list.add(heavyBox);
    list.add(lightBox);
    if (list.get(0) != heavyBox || list.get(1) != medBox || list.get(2) != lightBox) {
      correct = false;
    }
    Box extraBox = new Box(13, 16); // test if the first and new Box are of same weight
    list.add(extraBox);
    if (list.get(0) != heavyBox) {
      correct = false;
    }
    Box extraBox2 = new Box(15, 10); // test the arrangement is correct
    list.add(extraBox2);
    if (list.get(2) != medBox) {
      correct = false;
    }
    Box extraBox3 = new Box(16, 10); // test the arrangement is correct
    list.add(extraBox3);
    if (list.get(4) != extraBox3) {
      correct = false;
    }
    return correct;
  }
}
