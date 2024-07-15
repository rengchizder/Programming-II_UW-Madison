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
 * A class that models a book within our book library. It contains constructor, getters and
 * different methods for the book.
 */
public class Book {

  // class/static fields
  private static int nextId = 1; // class variable that represents the identifier of the next
                                 // book
  // Instance fields
  private final int ID; // unique identifier of this book
  private String author; // name of the author of this book
  private String title; // title of this book
  private Integer borrowerCardBarCode; // card bar code of the borrower of this book
                                       // When borrowerCardBarCode == null, the book is available
                                       // (no one has the book)

  /**
   * The constructor for the class of book It constructs a new Book object and initialize its
   * instance fields
   * 
   * @param title  title of this book
   * @param author author of this book
   */
  public Book(String title, String author) {
    // initializes its instance fields
    this.title = title;
    this.author = author;
    this.ID = nextId;
    this.borrowerCardBarCode = null; // new book that is created should be available
    nextId++; // to make sure that different books have different IDs
  }

  /**
   * Return the author of this book
   * 
   * @return the author
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Return the title of this book
   * 
   * @return the title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Return the the borrower's card bar code of this book if the book has been checked out or null
   * if not
   * 
   * @return the borrowerCardBarCode
   */
  public Integer getBorrowerCardBarCode() {
    // if this book is available, then there is no current borrower
    if (this.isAvailable() == true) {
      this.borrowerCardBarCode = null;
    }
    return this.borrowerCardBarCode;
  }

  /**
   * Returns the ID of this Book object
   * 
   * @return the ID of this Book object
   */
  public int getID() {
    return this.ID;
  }

  /**
   * Records the borrower's card bar code of this book if the book is available. If this book is not
   * available, this method does nothing.
   * 
   * @param borrowerCardBarCode the borrowerCardBarCode to set
   */
  public void borrowBook(Integer borrowerCardBarCode) {
    if (this.isAvailable() == true) { // the subscriber can only borrow a book when it is available
      this.borrowerCardBarCode = borrowerCardBarCode;
    }
  }

  /**
   * Sets this book to be available. When the borrowerCardBarCode is set to null, no one is
   * borrowing it
   */
  public void returnBook() {
    this.borrowerCardBarCode = null;
  }

  /**
   * Checks if this book is available
   * 
   * @return true if no one is borrowing this book, false otherwise
   */
  public boolean isAvailable() {
    boolean avail = false; // initialize the boolean variable
    if (this.borrowerCardBarCode == null) { // if no one is borrowing, return true
      avail = true;
    }
    return avail;
  }
}
