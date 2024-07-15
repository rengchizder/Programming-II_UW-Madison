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
 * This implements a test class for methods in HelpDesk and implements HelpDesk
 *
 */
public class HelpDeskTestSuite extends HelpDesk {
  // instance fields
  protected SupportTicket[] array; // zero-indexed max-heap
  protected int size; // number of SupportTicket

  /**
   * Construct a new HelpDeskTestSuite with size
   * 
   * @param size number of SupportTickets in HelpDeskTestSuite
   */
  public HelpDeskTestSuite(int size) {
    super(size); // from super class
  }

  /**
   * Test if the HelpDesk constructor works properly
   * 
   * @return true if passed the test
   */
  public static boolean testHelpDeskConstructor() {
    boolean correct = true;
    HelpDesk test1 = new HelpDesk(2);
    if (test1.size != 0) { // we expect there is no SupportTicket initially
      correct = false;
    } else if (test1.array.length != 2) { // expect the length to be the same as capacity input
      correct = false;
    }
    return correct;
  }

  /**
   * Test if the propagateUp method works properly
   * 
   * @return true if passed the test
   */
  public static boolean testPropogateUp() {
    boolean correct = true; // initialize the boolean to true
    // test propagateUp with only parent and leftChild
    HelpDesk test2 = new HelpDesk(5); // create a new HelpDesk
    // create new SupportTickets
    SupportTicket ticket1 = new SupportTicket("a");
    SupportTicket ticket2 = new SupportTicket("b");
    test2.array[0] = ticket1; // adding the tickets to array manually
    test2.array[1] = ticket2;
    test2.size = 2; // manually keeping track of the size (before propagation)
    test2.propagateUp(1); // propagate up
    if (test2.array[0] != ticket2 || test2.array[1] != ticket1) {
      correct = false;
    }
    // test propagateUp with parent, leftChild and rightChild
    SupportTicket ticket3 = new SupportTicket("c"); // create another SupportTicket
    test2.array[2] = ticket3; // adding the ticket to array manually
    test2.size = 3; // manually keeping track of the size (before propagation)
    test2.propagateUp(2); // propagate up
    if (test2.array[0] != ticket3 || test2.array[1] != ticket1 || test2.array[2] != ticket2) {
      correct = false;
    }
    // test no swapping is needed by running propagateUp again
    test2.propagateUp(2);
    if (test2.array[0] != ticket3 || test2.array[1] != ticket1 || test2.array[2] != ticket2) {
      correct = false;
    }
    // test case for no child / base case
    test2.propagateUp(1);
    test2 = new HelpDesk(5); // create new HelpDesk with empty array
    test2.size = 0; // manually keeping track of the size (before propagation)
    test2.array[0] = ticket1;
    test2.size = 1; // manually keeping track of the size (before propagation)
    try {
      test2.propagateUp(0);
    } catch (Exception e) {
      correct = false;
    }
    if (test2.array[0] != ticket1) {
      correct = false;
    }
    return correct;
  }

  /**
   * Test if the createNewTicket method works properly
   * 
   * @return true if passed the test
   */
  public static boolean testCreateNewTicket() {
    boolean correct = true; // initialize the boolean to true
    HelpDesk test3 = new HelpDesk(2); // create new HelpDesk
    // test null message error
    try {
      test3.createNewTicket(null);
      correct = false; // check if exception is thrown
    } catch (Exception e) {
      if (e.getMessage() != "The String message argument is null.") {
        correct = false;
      }
    }
    // test indexOutOfBoundException when array full, also testing if it successfully added new
    // ticket into array
    // create and add new tickets to the array
    test3.createNewTicket("first");
    test3.createNewTicket("second");
    if (test3.array[0].toString() != "second") { // because it is arranged accordingly, we have
                                                 // checked propagateUp()
      correct = false;
    } else if (test3.array[1].toString() != "first") {
      correct = false;
    }
    // it should throw exception when trying to add new ticket when the array is full
    try {
      test3.createNewTicket("error");
      correct = false; // check if exception is thrown
    } catch (Exception e) {
      if (e.getMessage() != "HelpDesk array is full.") {
        correct = false;
      }
    }
    return correct;
  }

  /**
   * Test if the propagate down method works properly
   * 
   * @return true if passed the test
   */
  public static boolean testPropagateDown() {
    boolean correct = true; // initialize the boolean to true
    // test propagateUp with only parent and leftChild
    HelpDesk test4 = new HelpDesk(5); // create new HelpDesk
    SupportTicket ticket1 = new SupportTicket("a");
    SupportTicket ticket2 = new SupportTicket("b");
    test4.array[0] = ticket1; // adding SupportTickets to array manually
    test4.array[1] = ticket2;
    test4.size = 2; // manually keep track of size
    test4.propagateDown(0); // propagate down from the root
    if (test4.array[0] != ticket2 || test4.array[1] != ticket1) {
      correct = false;
    }
    // test when the indexing is faulty, whether exception is caught
    test4 = new HelpDesk(5); // create new HelpDesk
    SupportTicket ticket3 = new SupportTicket("c"); // create new Ticket
    test4.array[0] = ticket1; // adding the tickets to different indices
    test4.array[2] = ticket3;
    test4.size = 2; // manually keep track of the size and is important for propagation to work
    // it should throw exception because the indices does not follow max heap
    try {
      test4.propagateDown(0);
      correct = false; // Didn't catch exception
    } catch (Exception e) {
    }
    // test when rightChild is larger than leftChild but both are larger than the parent
    test4 = new HelpDesk(5); // create new HelpDesk
    test4.array[0] = ticket1;
    test4.array[1] = ticket2;
    test4.array[2] = ticket3;
    test4.size = 3; // manually keep track of the size and is important for propagation to work
    test4.propagateDown(0); // it should swap properly
    if (test4.array[0] != ticket3 || test4.array[1] != ticket2 || test4.array[2] != ticket1) {
      correct = false;
    }
    // test when no swap is needed
    test4 = new HelpDesk(5);
    test4.array[0] = ticket3;
    test4.array[1] = ticket1;
    test4.array[2] = ticket2;
    test4.size = 3;
    test4.propagateDown(0);
    if (test4.array[0] != ticket3 || test4.array[1] != ticket1 || test4.array[2] != ticket2) {
      correct = false;
    }
    // test when leftChild is larger than rightChild and both are larger than the parent
    test4 = new HelpDesk(5);
    test4.array[0] = ticket1;
    test4.array[1] = ticket3;
    test4.array[2] = ticket2;
    test4.size = 3;
    test4.propagateDown(0);
    if (test4.array[0] != ticket3 || test4.array[1] != ticket1 || test4.array[2] != ticket2) {
      correct = false;
    }
    return correct;
  }

  /**
   * Test if the closeNextTicket method works properly
   * 
   * @return true if passed the test
   */
  public static boolean testCloseNextTicket() {
    boolean correct = true; // initialize the boolean to true
    HelpDesk test5 = new HelpDesk(5); // create new HelpDesk
    // test if successfully catch the error when is called when help desk is empty
    try {
      test5.closeNextTicket();
      correct = false;
    } catch (Exception e) {
      if (e.getMessage() != "HelpDesk with zero SupportTickets.") {
        correct = false;
      }
    }
    // test if successfully get the highest priority when the array starts from zero
    SupportTicket ticket1 = new SupportTicket("a");
    SupportTicket ticket2 = new SupportTicket("bb");
    SupportTicket ticket3 = new SupportTicket("ccc");
    test5.array[0] = ticket1;
    test5.array[1] = ticket2;
    test5.array[2] = ticket3;
    test5.size = 3; // need to manually add the total size because it is not uploaded when
                    // createNextTicket is not called
    if (test5.closeNextTicket() != "a") {
      correct = false;
    }
    // case where max is at right
    // it should remove and reduce the size of array
    if (test5.array[0].toString() != "ccc" || test5.array[1].toString() != "bb") {
      correct = false;
    }
    // case where max is at left
    // using new empty array
    test5 = new HelpDesk(5);
    ticket1 = new SupportTicket("ccc");
    ticket2 = new SupportTicket("bb");
    ticket3 = new SupportTicket("a");
    test5.array[0] = ticket1;
    test5.array[1] = ticket2;
    test5.array[2] = ticket3;
    test5.size = 3; // need to manually add the total size because it is not uploaded when
                    // createNextTicket is not called
    if (test5.closeNextTicket() != "ccc") {
      correct = false;
    }
    // it should remove and reduce the size of array
    if (test5.array[0].toString() != "bb" || test5.array[1].toString() != "a") {
      correct = false;
    }
    // continue to test case where only left child is present
    test5.size = 2; // update the number of tickets
    if (test5.closeNextTicket() != "bb") {
      correct = false;
    }
    if (test5.array[0].toString() != "a" || test5.array[1] != null) {
      correct = false;
    }
    return correct;
  }

  /**
   * Test if parentOf, leftChildOf, rightChildOf methods work properly
   * 
   * @return true if passed the test
   */
  // parentOF, leftChildOf and rigthChildOf
  public static boolean testCorrectRelationshipIndex() {
    boolean correct = true;
    // we mainly check whether the numbers match without using the array
    // dealing with root(0), its leftChild(1) and rightChild(2)
    if (parentOf(1) != 0 || parentOf(2) != 0) { // testing parentOf
      correct = false;
    }
    if (leftChildOf(0) != 1 || rightChildOf(0) != 2) { // test leftChildOf and
                                                       // rightChildOf
      correct = false;
    }
    // moving the current index be 1, then leftChild = 3, rightChild = 4
    if (parentOf(3) != 1 || parentOf(4) != 1) { // testing parentOf
      correct = false;
    }
    if (leftChildOf(1) != 3 || rightChildOf(1) != 4) { // test leftChildOf and
                                                       // rightChildOf
      correct = false;
    }
    // moving the current index be 2, then leftChild = 5, rightChild = 6
    if (parentOf(5) != 2 || parentOf(6) != 2) { // testing parentOf
      correct = false;
    }
    if (leftChildOf(2) != 5 || rightChildOf(2) != 6) { // test leftChildOf and
                                                       // rightChildOf
      correct = false;
    }
    // since we have recurrent, it suffices to test the cases above
    return correct;
  }

  /**
   * Test if the checkNextTicket method works properly
   * 
   * @return true if passed the test
   */
  public static boolean testCheckNextTicket() {
    boolean correct = true; // initialize boolean to true
    HelpDesk test7 = new HelpDesk(5); // create new HelpDesk
    // test if successfully catch the error when is called when help desk is empty
    try {
      test7.checkNextTicket();
      correct = false;
    } catch (Exception e) {
      if (e.getMessage() != "HelpDesk with zero SupportTickets.") {
        correct = false;
      }
    }
    // test if successfully get the highest priority when the array starts from zero
    SupportTicket ticket1 = new SupportTicket("one");
    SupportTicket ticket2 = new SupportTicket("two");
    SupportTicket ticket3 = new SupportTicket("three");
    test7.array[0] = ticket1;
    test7.array[1] = ticket2;
    test7.array[2] = ticket3;
    test7.size = 3; // need to manually add the total size because it is not uploaded when
                    // createNextTicket is not called
    if (test7.checkNextTicket() != "one") {
      correct = false;
    }
    // test if successfully get highest priority when array doesn't start from zero (although
    // impossible by setup)
    test7.array[0] = null;
    if (test7.checkNextTicket() != "two") {
      correct = false;
    }
    // another test of tickets not at adjacent index
    test7.array[1] = null;
    test7.array[4] = ticket1;
    if (test7.checkNextTicket() != "three") {
      correct = false;
    }
    return correct;
  }

  /**
   * Test if the swap method works properly
   * 
   * @return true if passed the test
   */
  public static boolean testSwapMethod() {
    boolean correct = true; // initialize boolean to true
    HelpDesk test8 = new HelpDesk(10); // create new HelpDesk
    SupportTicket ticket1 = new SupportTicket("one");
    SupportTicket ticket2 = new SupportTicket("two");
    SupportTicket ticket3 = new SupportTicket("three");
    test8.array[0] = ticket1;
    test8.array[5] = ticket2;
    // try index out of array's capacity, it should throw exception
    try {
      test8.swap(0, 11);
      correct = false;
    } catch (ArrayIndexOutOfBoundsException e) {
      if (e.getMessage().contains("11") != true) {
        correct = false;
      }
    }
    test8.array[9] = ticket3;
    // try swapping
    test8.swap(0, 5);
    if (test8.array[0] != ticket2) {
      correct = false;
    } else if (test8.array[5] != ticket1) {
      correct = false;
    }
    // try swapping with empty ticket (null), should work properly
    test8.swap(9, 7);
    if (test8.array[9] != null) {
      correct = false;
    } else if (test8.array[7] != ticket3) {
      correct = false;
    }
    return correct;
  }

  /**
   * Main method used to call the tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Calling different tests
    // test if the constructor for HelpDesk is working properly
    if (testHelpDeskConstructor() == true) {
      System.out.println("testHelpDeskConstructor passed");
    } else {
      System.out.println("testHelpDeskConstructor failed");
    }
    // test if propagateUp method works properly
    if (testPropogateUp() == true) {
      System.out.println("testPropogateUp passed");
    } else {
      System.out.println("testPropogateUp failed");
    }
    // test if createNewTicket method works properly
    if (testCreateNewTicket() == true) {
      System.out.println("testCreateNewTicket passed");
    } else {
      System.out.println("testCreateNewTicket failed");
    }
    // test if propagateDown method works properly
    if (testPropagateDown() == true) {
      System.out.println("testPropagateDown passed");
    } else {
      System.out.println("testPropagateDown failed");
    }
    // test if closeNextTicket method works properly
    if (testCloseNextTicket() == true) {
      System.out.println("testCloseNextTicket passed");
    } else {
      System.out.println("testCloseNextTicket failed");
    }
    // test if parentOf, leftChildOf, rightChildOf methods works properly
    if (testCorrectRelationshipIndex() == true) {
      System.out.println("testCorrectRelationshipIndex passed");
    } else {
      System.out.println("testCorrectRelationshipIndex failed");
    }
    // test if checkNextTicket method works properly
    if (testCheckNextTicket() == true) {
      System.out.println("testCheckNextTicket passed");
    } else {
      System.out.println("testCheckNextTicket failed");
    }
    // test if swap method works properly
    if (testSwapMethod() == true) {
      System.out.println("testSwapMethod passed");
    } else {
      System.out.println("testSwapMethod failed");
    }
  }
}
