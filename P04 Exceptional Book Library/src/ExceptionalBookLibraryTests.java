//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P04 Exceptional Book Library
// Files: ExceptionalLibrary.java, ExceptionalBookLibraryTests.java
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
import java.text.ParseException;

/**
 * A class that contains multiple tests that test for the good functioning of different methods for
 * the classes of this file
 */
public class ExceptionalBookLibraryTests {

  /**
   * main method used to call the unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    // different tests using methods below, if any of the test fails, it will output error
    // statements
    if (testLibraryParsePinCode() != true) {
      System.out.println("Library Parse Card Pin Code test failed.");
    }
    if (testLibraryParseCardBarCode() != true) {
      System.out.println("Library Parse Card Bar Code test failed");
    }
    if (testParseRunLibrarianAddSubscriberCommand() != true) {
      System.out.println("Librarian Add Subscriber Command test failed");
    }
    if (testLibraryParseRunLibrarianCheckoutBookCommand() != true) {
      System.out.println("Library Parse Run Librarian Checkout Book Command test failed");
    }
    if (testLibraryParseRunSubscriberReturnBookCommand() != true) {
      System.out.println("Library Parse Run Subscriber Return Book Command test failed");
    }
  }

  /**
   * Checks whether parsePinCode method works properly. If Pin Code is in the range, it should be
   * successfully parsed into integer and error would be called when it is not in range
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLibraryParsePinCode() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    boolean error = false; // no error at first
    ExceptionalLibrary newLib = new ExceptionalLibrary("add", "user", "pass"); // create a new
                                                                               // library
    try {
      int y = newLib.parsePinCode("1111", 1); // parsing a good pin code
      // System.out.println(y);
      if (y != 1111) {
        testPassed = false;
      }
      newLib.parsePinCode("1abc1", 1); // parsing a bad pin code
    } catch (ParseException e) {
      error = true;
    }
    if (error != true) { // test to see if the bad pin code creates an error
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether parseCardBarCode method works properly. A card bar code is valid if it can be
   * parsed to an integer that passes Subscriber.checkCardBarCode() method.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLibraryParseCardBarCode() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    boolean error = false; // no error at first

    ExceptionalLibrary newLib = new ExceptionalLibrary("add", "user", "pass"); // create a new
                                                                               // library
    try {
      newLib.addSubscriber("mike", 1235, "address", "1111"); // add a new subscriber
    } catch (InstantiationException e) {
      System.out.println(e.getMessage());
    }
    try {
      newLib.parseCardBarCode("111", 1); // test with a wrong, random bar code
    } catch (ParseException e) {
      error = true;
    }
    if (error != true) { // test to see if the bad bar code creates an error
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Test to see if we can add subscriber successfully using the parseRunLibrarianAddSubscriber
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testParseRunLibrarianAddSubscriberCommand() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    boolean error = false; // no error at first

    ExceptionalLibrary newLib = new ExceptionalLibrary("add", "user", "pass");
    try {
      String[] testSub = new String[5]; // a good sample that has correct format for the information
      testSub[1] = "mike";
      testSub[2] = "1213";
      testSub[3] = "add";
      testSub[4] = "1234";
      String[] testSubBad = new String[5]; // a bad sample that has wrong format for one of the
                                           // information
      testSubBad[1] = "mike";
      testSubBad[2] = "12113";
      testSubBad[3] = "add";
      testSubBad[4] = "1234";
      try {
        newLib.parseRunLibrarianAddSubscriberCommand(testSub);
        newLib.parseRunLibrarianAddSubscriberCommand(testSubBad);
      } catch (InstantiationException e) {
        System.out.println(e.getMessage());
      }
      if (newLib.findSubscriber(2019000002) == null) { // new subscriber for the good sample should
                                                       // be created
        testPassed = false;
      }
      if (newLib.findSubscriber(2019000003) != null) { // new subscriber for the bad sample should
                                                       // not be created
        testPassed = false;
      }
    } catch (ParseException e) {
      error = true;
    }
    if (error != true) { // test to see if the bad pin code creates an error
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Test to see if we can parseRunLibrarianCheckoutBookCommand method works properly
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLibraryParseRunLibrarianCheckoutBookCommand() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    boolean error = false; // no error at first

    ExceptionalLibrary newLib = new ExceptionalLibrary("add", "user", "pass");
    try {
      newLib.addSubscriber("mike", 1111, "add", "1234"); // create new subscriber for test
      newLib.addBook("title1", "author1"); // add new book for test
      String[] commands = {"3", "2019000003", "1"}; // valid command
      String[] commandsBad = {"3", "acbd", "ac"}; // invalid command
      newLib.parseRunLibrarianCheckoutBookCommand(commands); // try
                                                             // parseRunLibrarianCheckoutBookCommand()
                                                             // using valid command
      newLib.parseRunLibrarianCheckoutBookCommand(commandsBad); // try
                                                                // parseRunLibrarianCheckoutBookCommand()
                                                                // using invalid command
    } catch (InstantiationException e) {
    } catch (ParseException e) {
      error = true;
    }
    if (error != true) { // test to see if the bad bar code creates an error
      testPassed = false;
    }
    return testPassed;
  }


  /**
   * Test to see if we can parseRunSubscriberReturnBookCommand method works properly
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLibraryParseRunSubscriberReturnBookCommand() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    boolean error = false; // no error at first

    ExceptionalLibrary newLib = new ExceptionalLibrary("add", "user", "pass");
    try {
      newLib.addBook("title2", "author2"); // add new book for test
      newLib.addBook("title3", "author3"); // add new book for test
      newLib.addSubscriber("mike", 1111, "add", "1234"); // create new subscriber for test   
      Subscriber sub4 = newLib.findSubscriber(2019000004);
      String[] commandsCheckout = {"3", "2019000004", "2"}; // valid command
      String[] commandsCheckout2 = {"3", "2019000004", "3"}; // valid command
      String[] commandsGoodReturn = {"4", "2019000004", "2"}; // valid return command
      String[] commandsBadReturn = {"4", "mike", "3"}; // invalid return command
      newLib.parseRunLibrarianCheckoutBookCommand(commandsCheckout); // try
      // parseRunLibrarianCheckoutBookCommand()
      // using valid command
      newLib.parseRunLibrarianCheckoutBookCommand(commandsCheckout2); // try
      // parseRunLibrarianCheckoutBookCommand()
      // using valid command
      newLib.parseRunSubscriberReturnBookCommand(commandsGoodReturn, sub4);
      newLib.parseRunSubscriberReturnBookCommand(commandsBadReturn, sub4);
    } catch (InstantiationException e) {
    } catch (ParseException e) {
      error = true;
      // System.out.println(e.getMessage());
    }
    if (error != true) {
      testPassed = false;
    }
    return testPassed;
  }
}

