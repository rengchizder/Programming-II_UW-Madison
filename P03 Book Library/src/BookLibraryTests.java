//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Book Library
// Files: Book.java, BookLibraryTests.java, Subscriber.java, Librarian.java, Library.java
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
public class BookLibraryTests {

  /**
   * main method used to call the unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    // different tests using methods below, if any of the test fails, it will output error
    // statements
    if (testBookConstructorGetters() == false) {
      System.out.println("The book constructor getters failed to work correctly");
    }
    if (testBookReturnBook() == false) {
      System.out.println("The book return book function failed to work correctly");
    }
    if (testSubscriberCheckoutBook() == false) {
      System.out.println("The subscriber checkout book function failed to work correctly");
    }
    if (testSubscriberConstructorGetters() == false) {
      System.out.println("The subscriber constructor getters failed to work correctly");
    }
    if (testLibraryConstructor() == false) {
      System.out.println("The library constructor functions failed to work correctly");
    }
    if (testLibraryFindBookByAuthor() == false) {
      System.out.println("The library find book by author function failed to work correctly");
    }
  }

  /**
   * Checks whether the constructor of your Book class initializes correctly the new Book instance
   * fields: title, author, borrowerCardBarCode, ID, and increments nextID static field.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testBookConstructorGetters() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    Book bookOne = new Book("titleOne", "authorOne"); // create new book
    Book bookTwo = new Book("titleTwo", "authorTwo"); // create another new book

    // test whether the constructor initializes the books correctly
    if (bookOne.getAuthor() != "authorOne") {
      testPassed = false;
    } else if (bookOne.getTitle() != "titleOne") {
      testPassed = false;
    } else if (bookOne.getBorrowerCardBarCode() != null) {
      testPassed = false;
    } else if (bookOne.getID() != 1) { // checks if the different identifiers of the books created
                                       // are set correctly
      testPassed = false;
    } else if (bookTwo.getID() != 2) {
      testPassed = false;
    }

    // check whether the books are initially available works correctly
    if (bookOne.isAvailable() == true) {
      bookOne.borrowBook(1111);
    }
    if (bookTwo.isAvailable() == true) {
      bookTwo.borrowBook(2222);
    }

    // test if the borrowBook() method works successfully
    if (bookOne.getBorrowerCardBarCode() != 1111) {
      testPassed = false;
    } else if (bookTwo.getBorrowerCardBarCode() != 2222) {
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether returnBook() method defined within your Book class sets correctly the instance
   * field borrowerCardBarCode. A Book must be available after this instance method is called.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testBookReturnBook() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    Book bookOne = new Book("titleOne", "authorOne"); // create a new book
    bookOne.returnBook(); // return the book
    if (bookOne.getBorrowerCardBarCode() != null) { // checks whether a book
                                                    // is available after this returnBook() method
                                                    // is called.
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether the checkoutBook() method defined within the Subscriber class works correctly.
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testSubscriberCheckoutBook() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    // we create ten books to make sure to check that the subscriber cannot have more than
    // <MAX_BOOKS_CHECKED_OUT> books checked out and not yet returned
    Book bookTest = new Book("bookTest", "titleTest");
    Book bookTestTwo = new Book("bookTest", "titleTest");
    Book bookTestThree = new Book("bookTest", "titleTest");
    Book bookTestFour = new Book("bookTest", "titleTest");
    Book bookTestFive = new Book("bookTest", "titleTest");
    Book bookTestSix = new Book("bookTest", "titleTest");
    Book bookTestSeven = new Book("bookTest", "titleTest");
    Book bookTestEight = new Book("bookTest", "titleTest");
    Book bookTestNine = new Book("bookTest", "titleTest");
    Book bookTestTen = new Book("bookTest", "titleTest");
    Book bookTestEleven = new Book("bookTest", "titleTest");

    Subscriber subOne = new Subscriber("subOne", 9999, "add", "123"); // create a new subscriber
    subOne.checkoutBook(bookTest); // check out the first book
    if (subOne.isBookInBooksCheckedOut(bookTest) != true) { // check if checked out book is added to
                                                            // the subscriber’s <booksCheckedOut>
                                                            // list if it is available
      testPassed = false;
    }

    if (bookTest.getBorrowerCardBarCode() != 2019000001) { // check if the book’s
                                                           // <borrowerCardBarCode> is correctly set
                                                           // if the book is successfully checked
                                                           // out by the subscriber
      testPassed = false;
    }

    if (subOne.isBookInBooksCheckedOut(bookTestEleven) != false) { // check if the
                                                                   // isBookInBooksCheckedOut()
                                                                   // method
                                                                   // works
      testPassed = false;
    }
    // check out the books for the subscriber
    subOne.checkoutBook(bookTestTwo);
    subOne.checkoutBook(bookTestThree);
    subOne.checkoutBook(bookTestFour);
    subOne.checkoutBook(bookTestFive);
    subOne.checkoutBook(bookTestSix);
    subOne.checkoutBook(bookTestSeven);
    subOne.checkoutBook(bookTestEight);
    subOne.checkoutBook(bookTestNine);
    subOne.checkoutBook(bookTestTen);
    subOne.checkoutBook(bookTestEleven); // test if checking out more books than allowed will pop up
                                         // the error message
    if (subOne.isBookInBooksCheckedOut(bookTestEleven) != false) { // test if the extra book is not
                                                                   // wrongly added to the book
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Check the good functioning of the subscriber class, constructor and getters can work
   * successfully
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testSubscriberConstructorGetters() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    Subscriber subTwo = new Subscriber("subTwo", 9999, "add", "123"); // create another new
                                                                      // subscriber
    if (subTwo.getPhoneNumber() != "123") { // check if the getter for phone number works
      testPassed = false;
    }
    if (subTwo.getAddress() != "add") { // check if the getter for address works
      testPassed = false;
    }
    if (subTwo.getName() != "subTwo") { // check if the getter for name works
      testPassed = false;
    }
    if (subTwo.getPin() != 9999) { // check if the getter for pin works
      testPassed = false;
    }
    if (subTwo.getCARD_BAR_CODE() != 2019000002) { // check if the getter for pin works and the card
                                                   // bar code is correctly numbered
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks the good functioning of the library constructors and getters
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLibraryConstructor() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    Library newLib = new Library("add", "mike", "1234"); // create a new library
    if (newLib.getAddress() != "add") { // test if the getter for library address works
      testPassed = false;
    }
    Librarian librarian = newLib.getLibrarian(); // get the librarian of the library
    if (librarian.getUsername() != "mike") { // test if the getter for the librarian's username
                                             // works
      testPassed = false;
    }
    if (librarian.checkPassword("1234") != true) { // test if it can check the librarian's password
                                                   // successfully
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks the good functioning of findBookByAuthor(String) method defined in the Library class
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testLibraryFindBookByAuthor() {
    boolean testPassed = true; // initialize the boolean of test passed to true
    Library newLib = new Library("add", "mike", "1234"); // create a new library
    newLib.addBook("titleOne", "authorOne"); // add a book to the library
    if (newLib.findBookByAuthor("authorOne").size() != 1) { // test if we can find the book, which
                                                            // has only 1 of them in the book list
      testPassed = false;
    }
    if (newLib.findBookByAuthor("unknown").size() != 0) { // test if finding book for a random
                                                          // author returns null
      testPassed = false;
    }
    return testPassed;
  }
}
