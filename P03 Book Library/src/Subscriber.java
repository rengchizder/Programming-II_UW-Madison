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
 * This class models a public library subscriber. A subscriber is a card holder who can borrow
 * (checkout) and return library books
 */
import java.util.ArrayList;

public class Subscriber {

  // static fields
  private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked out
                                                       // one subscriber
  private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
                                                   // code of the next subscriber to be created
  // Instance fields
  private int pin; // 4-digits Personal Identification Number to verify the identity of this
                   // subscriber
  private final Integer CARD_BAR_CODE; // card bar code of this subscriber

  private String name; // name of this subscriber
  private String address; // address of this subscriber
  private String phoneNumber; // phone number of this subscriber

  private ArrayList<Book> booksCheckedOut = new ArrayList<Book>(); // list of books checked out by
                                                                   // this subscriber and not
  // yet
  // returned. A subscriber can have at most 10 checked out
  // books
  private ArrayList<Book> booksReturned = new ArrayList<Book>(); // list of the books returned by
                                                                 // this subscriber

  /**
   * Creates a new subscriber with given name, address, and phone number, and initializes its other
   * instance fields
   * 
   * @param name        name of this subscriber
   * @param pin         4-digits personal information number of this subscriber
   * @param address     address of this subscriber
   * @param phoneNumber phone number of this subscriber
   */
  public Subscriber(String name, int pin, String address, String phoneNumber) {
    this.name = name;
    this.pin = pin;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.booksCheckedOut = new ArrayList<Book>(); // initialize the array list of books checked out
                                                  // by this subscriber
    this.booksReturned = new ArrayList<Book>(); // initialize the array list of books returned by
                                                // this subscriber
    this.CARD_BAR_CODE = nextCardBarCode; // give this subscriber a card bar code
    nextCardBarCode++; // increase the card bar code for the next registered subscriber
  }

  /**
   * Returns this subscriber's address
   * 
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Updates this subscriber's address
   * 
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Returns this subscriber's phone number
   * 
   * @return the phoneNumber
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   * Updates this subscriber's phone number
   * 
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns this subscriber PIN (4-digits Personal Identification Number)
   * 
   * @return the pin
   */
  public int getPin() {
    return this.pin;
  }

  /**
   * Returns this subscriber's card bar code
   * 
   * @return the CARD_BAR_CODE
   */
  public Integer getCARD_BAR_CODE() {
    return this.CARD_BAR_CODE;
  }

  /**
   * Returns this subscriber's name
   * 
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Checks out an available book. The checkout operation fails if the maximum number of checked out
   * books by this subscriber is already reached
   * 
   * @param book reference to the book to return by this subscriber
   */
  public void checkoutBook(Book book) {
    if (booksCheckedOut.size() >= MAX_BOOKS_CHECKED_OUT) { // subscriber cannot have more than
                                                           // MAX_BOOKS_CHECKED_OUT books checked
                                                           // out
      System.out.println(
          "Checkout Failed: You cannot check out more than " + MAX_BOOKS_CHECKED_OUT + "books.");
    } else if (this.isBookInBooksCheckedOut(book) == true) { // subscriber cannot check out book
                                                             // that he has checked out
      System.out.println("You have already checked out " + book.getTitle() + " book.");
    } else if (book.isAvailable() == false) { // subscriber cannot check out a book which is not
                                              // available
      System.out.println("Sorry, " + book.getTitle() + " is not available.");
    } else {
      book.borrowBook(this.getCARD_BAR_CODE()); // check out the book with subscriber's card bar
                                                // code
      booksCheckedOut.add(book); // add this book to the list of subscriber's checked out books
    }
  }

  /**
   * Returns a library book
   * 
   * @param book reference to the book to return by this subscriber
   */
  public void returnBook(Book book) {
    booksReturned.add(book); // add this book to the list of subscriber's returned books
    book.returnBook(); // update the status of availability of this book
    booksCheckedOut.remove(book); // remove this book from the list of subscriber's checked out
                                  // books
  }

  /**
   * Checks if this subscriber booksCheckedOut list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksCheckedOut list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksReturned(Book book) {
    boolean returned = true; // initialize the boolean variable
    if (booksReturned.contains(book) == false) { // return false if this book is not on the returned
                                                 // list or true otherwise
      returned = false;
    }
    return returned;
  }

  /**
   * Checks if this subscriber booksCheckedOut list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksCheckedOut list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksCheckedOut(Book book) {
    boolean checkedOut = true;
    if (booksCheckedOut.contains(book) == false) {
      checkedOut = false;
    }
    return checkedOut;
  }

  /**
   * Displays the list of the books checked out and not yet returned
   */
  public void displayBooksCheckedOut() {
    if (booksCheckedOut.isEmpty()) // empty list
      System.out.println("No books checked out by this subscriber");
    else
      // Traverse the list of books checked out by this subscriber and display its content
      for (int i = 0; i < booksCheckedOut.size(); i++) {
        System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
      }
  }

  /**
   * Displays the history of the returned books by this subscriber
   */
  public void displayHistoryBooksReturned() {
    if (booksReturned.isEmpty()) // empty list
      System.out.println("No books returned by this subscriber");
    else
      // Traverse the list of borrowed books already returned by this subscriber and display its
      // content
      for (int i = 0; i < booksReturned.size(); i++) {
        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
        System.out.println("Author: " + booksReturned.get(i).getAuthor());
      }
  }

  /**
   * Displays this subscriber's personal information
   */
  public void displayPersonalInfo() {
    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
    System.out.println("  Name: " + name);
    System.out.println("  Address: " + address);
    System.out.println("  Phone number: " + phoneNumber);
  }
}
