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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class models a simple book library. The main method of this class implements the management
 * system for this library.
 */
public class Library {

  // instance fields
  private String address; // Street address of this library
  private Librarian librarian; // this library's librarian. This library must have only ONE
                               // librarian
  private ArrayList<Book> books; // list of the books in this library
  private ArrayList<Subscriber> subscribers; // list of this library's subscribers

  /**
   * Creates a new Library and initializes all its instance fields. Initially both books and
   * subscribers lists are empty.
   * 
   * @param address           Address of this Library
   * @param librarianUsername username of the librarian of this book library
   * @param librarianLogin    password of the librarian of this book library
   */
  Library(String address, String librarianUsername, String librarianLogin) {
    this.address = address;
    this.librarian = new Librarian(librarianUsername, librarianLogin); // create new librarian with
                                                                       // the parameters given
    this.books = new ArrayList<Book>(); // initialize the list of books in this library to empty
    this.subscribers = new ArrayList<Subscriber>(); // initialize the list of library's subscribers
                                                    // to empty
  }


  /**
   * Returns the librarian of this library
   * 
   * @return the librarian
   */
  public Librarian getLibrarian() {
    return this.librarian;
  }

  /**
   * Returns the address of this library
   * 
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Returns a Book given a book identifier if found, and null otherwise. If the book is not found,
   * this method displays the following message: "Error: this book identifier didn't match any of
   * our books identifiers."
   * 
   * @param bookId identifier of the book to find
   * @return reference to the Book if found and null otherwise
   */
  public Book findBook(int bookId) {
    Book bookFound = null; // initialize the Book Object which may be found
    // run through the list of books using for loop to see if any of the books have the same ID as
    // the parameter imputed
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getID() == bookId) {
        bookFound = books.get(i); // if the particular book is found in the list, we return a
                                  // reference to
                                  // the Book
      }
    }
    if (bookFound == null) { // if not found, we return null and print an error statement
      System.out.println("Error: this book identifier didn't match any of our books identifiers.");
    }
    return bookFound;
  }

  /**
   * Returns the list of books having a given title in this library. The comparison used by this
   * method is case insensitive
   * 
   * @param title title of the book(s) to find
   * @return ArrayList of the books having a given title in this library (0 or more books can be
   *         found)
   */
  public ArrayList<Book> findBookByTitle(String title) {
    ArrayList<Book> booksFound = new ArrayList<Book>(); // create a new empty list of Book object to
                                                        // get the books, if found
    // using a for loop, we add the references of the books to the list of booksFound that have the
    // same title as the parameter imputed
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getTitle().equalsIgnoreCase(title)) { // we ignore the case of the title
                                                             // imputed
        booksFound.add(books.get(i));
      }
    }
    return booksFound; // the returned list may contain zero book
  }

  /**
   * Returns the list of books having a given author. The comparison used by this method is case
   * insensitive
   * 
   * @param title title of the book(s) to find
   * @return ArrayList of the books having a given author (0 or more books can be found)
   */
  public ArrayList<Book> findBookByAuthor(String author) {
    ArrayList<Book> booksFound = new ArrayList<Book>(); // create a new empty list of Book object to
                                                        // get the books, if found
    // using a for loop, we add the references of the books to the list of booksFound that have the
    // same author as the parameter imputed
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getAuthor().equalsIgnoreCase(author)) { // we ignore the case of the author
                                                               // imputed
        booksFound.add(books.get(i));
      }
    }
    return booksFound; // the returned list may contain zero book
  }

  /**
   * Adds a new book to the library (to the books list). This method displays the following message:
   * "Book with Title " + title + " is successfully added to the library."
   * 
   * @param title  title of the new book
   * @param author author of the new book
   */
  public void addBook(String title, String author) {
    Book newBook = new Book(title, author); // create a new book with the parameters
    books.add(newBook); // add the new book to the list of books
    // System.out.println(newBook.getID());
    System.out.println("Book with Title " + title + " is successfully added to the library.");
  }

  /**
   * Removes a book given its identifier from the library (from books list)
   * 
   * @param bookId identifier of the book to remove
   * @return a reference to the removed book, and null if the book is not found in this library or
   *         if it is not available
   */
  public Book removeBook(int bookId) {
    Book removedBook = null; // initialize the removed book to null
    // using a for loop, search through the list of books to see if there are matching id with
    // bookId imputed
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getID() == bookId) {
        removedBook = books.get(i); // if it matches, the removed book is set to it
        books.remove(i); // remove the book from book lists
      }
    }
    return removedBook; // return reference to removed book, null if not removed successfully
  }

  /**
   * Adds a new subscriber to this library (to subscribers list). This method displays the following
   * message: "Library card with bar code " + card bar code + " is successfully issued to the new
   * subscriber " + name + "."
   * 
   * @param name        name of the new subscriber
   * @param pin         4-digit personal identifier number of the new subscriber
   * @param address     address of the new subscriber
   * @param phoneNumber phone number of the new subscriber
   */
  public void addSubscriber(String name, int pin, String address, String phoneNumber) {
    Subscriber newSub = new Subscriber(name, pin, address, phoneNumber); // create new subscriber
                                                                         // with the parameters
    subscribers.add(newSub); // add the new subscriber to the subscriber list
    int cardBarCode = newSub.getCARD_BAR_CODE(); // grab the card bar code of the subscriber to
                                                 // print the statement below
    System.out.println("Library card with bar code " + cardBarCode
        + " is successfully issued to the new subscriber " + name + ".");
  }

  /**
   * Finds a subscriber given its cardBarCode. This method displayed the following message: "Error:
   * this card bar code didn't match any of our records." and returns null if the provided
   * cardBarCode did not match with any of the subscribers' card bar codes
   * 
   * @param cardBarCode of the subscriber to find
   * @return a reference to the subscriber if found, otherwise null
   */
  public Subscriber findSubscriber(int cardBarCode) {
    Subscriber subscriberFound = null; // initialize the subscriber that may be found
    // using for loop to look through the list of subscribers, set the subscriber to the subscriber
    // found object if it has matching card bar code
    for (int i = 0; i < subscribers.size(); i++) {
      if (subscribers.get(i).getCARD_BAR_CODE() == cardBarCode) {
        subscriberFound = subscribers.get(i);
      }
    }
    if (subscriberFound == null) { // if no subscriber is found successfully, print an error
                                   // statement
      System.out.println("Error: this card bar code didn't match any of our records.");
    }
    return subscriberFound;
  }

  /**
   * Displays a list of books
   * 
   * @param books ArrayList of books
   */
  public static void displayBooks(ArrayList<Book> books) {
    // Traverse the list of books and display book id, title, author, and availability of each book
    for (int i = 0; i < books.size(); i++) {
      System.out.print("<Book ID>: " + books.get(i).getID() + " ");
      System.out.print("<Title>: " + books.get(i).getTitle() + " ");
      System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
      System.out.println("<Is Available>: " + books.get(i).isAvailable());
    }
  }

  /**
   * Reads and processes the user commands with respect to the menu of this application
   * 
   * @param scanner Scanner object used to read the user command lines
   */
  public void readProcessUserCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displayMainMenu(); // display the library management system main menu
    System.out.print(promptCommandLine);
    String command = scanner.nextLine(); // read user command line
    String[] commands = command.trim().split(" "); // split user command
    while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
      switch (commands[0].trim().charAt(0)) {
        case '1': // login as librarian commands[1]: password
          if (this.librarian.checkPassword(commands[1])) {
            // read and process librarian commands
            readProcessLibrarianCommand(scanner);
          } else { // error password
            System.out.println("Error: Password incorrect!");
          }
          break;
        case '2': // login as subscriber commands[1]: card bar code
          Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
          if (subscriber != null) {
            if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
              // read and process subscriber commands
              readProcessSubscriberCommand(subscriber, scanner);
            else
              System.out.println("Error: Incorrect PIN.");
          }
          break;
      }
      // read and split next user command line
      displayMainMenu(); // display the library management system main menu
      System.out.print(promptCommandLine);
      command = scanner.nextLine(); // read user command line
      commands = command.trim().split(" "); // split user command line
    }
  }

  /**
   * Displays the main menu for this book library application
   */
  private static void displayMainMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("     Welcome to our Book Library Management System");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <password>] Login as a librarian");
    System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
    System.out.println("[3] Exit"); // Exit the application
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for a Subscriber
   */
  private static void displaySubscriberMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Subscriber's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <book ID>] Check out a book");
    System.out.println("[2 <book ID>] Return a book");
    System.out.println("[3 <title>] Search a Book by title");
    System.out.println("[4 <author>] Search a Book by author");
    System.out.println("[5] Print list of books checked out");
    System.out.println("[6] Print history of returned books");
    System.out.println("[7 <address>] Update address");
    System.out.println("[8 <phone number>] Update phone number");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for the Librarian
   */
  private static void displayLibrarianMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Librarian's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <title> <author>] Add new Book");
    System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
    System.out.println("[3 <card bar code> <book ID>] Check out a Book");
    System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
    System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
    System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
    System.out.println("[7] Display All Books");
    System.out.println("[8 <book ID>] Remove a Book");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Display the Application GoodBye and logout message.
   */
  private static void displayGoodByeLogoutMessage() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("       Thanks for Using our Book Library App!!!!");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Reads and processes the librarian commands according to the librarian menu
   * 
   * @param scanner Scanner object used to read the librarian command lines
   */
  private void readProcessLibrarianCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displayLibrarianMenu();
    System.out.print(promptCommandLine);
    String librarianCommand = scanner.nextLine();
    String[] librarianCommands = librarianCommand.trim().split(" ");
    while (librarianCommands[0].trim().charAt(0) != '9') { // '3': Exit the application
      switch (librarianCommands[0].trim().charAt(0)) {
        case '1':
          addBook(librarianCommands[1], librarianCommands[2]); // if user imputed 1, add a new book
          break;
        case '2':
          // add a new subscriber with the parameters
          addSubscriber(librarianCommands[1], Integer.parseInt(librarianCommands[2]),
              librarianCommands[3], librarianCommands[4]);
          break;
        case '3':
          // check out a book
          Book bookCheckingOut = null; // initialize the book checking out to null
          // using for loop, find the book with the ID imputed, from the list of books
          for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == Integer.parseInt(librarianCommands[2])) {
              bookCheckingOut = books.get(i);
            }
          }
          // check out the book for the subscriber
          for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i).getCARD_BAR_CODE() == Integer.parseInt(librarianCommands[1])) {
              subscribers.get(i).checkoutBook(bookCheckingOut);
            }
          }
          break;
        case '4':
          // return a book for a subscriber
          Book bookReturning = null; // initialize the returning book to null
          // using for loop, find the book with the ID imputed, from the list of books
          for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == Integer.parseInt(librarianCommands[2])) {
              bookReturning = books.get(i);
            }
          }
          // return the book for the subscriber
          for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i).getCARD_BAR_CODE() == Integer.parseInt(librarianCommands[1])) {
              subscribers.get(i).returnBook(bookReturning);
            }
          }
          break;
        case '5':
          // display Personal Info of a Subscriber
          // using for loop to find the subscriber
          for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i).getCARD_BAR_CODE() == Integer.parseInt(librarianCommands[1])) {
              subscribers.get(i).displayPersonalInfo();
            }
          }
          break;
        case '6':
          // display Books Checked out by a Subscriber
          // using for loop to find the subscriber and run the method to display the list of books
          // checked out
          for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i).getCARD_BAR_CODE() == Integer.parseInt(librarianCommands[1])) {
              subscribers.get(i).displayBooksCheckedOut();
            }
          }
          break;
        case '7':
          // display All Books
          displayBooks(books);
          break;
        case '8':
          // remove a book
          removeBook(Integer.parseInt(librarianCommands[1]));
          break;
      }
      displayLibrarianMenu();
      System.out.print(promptCommandLine);
      librarianCommand = scanner.nextLine(); // to get command inputs from the user/ librarian
      librarianCommands = librarianCommand.trim().split(" "); // split the strings of inputs into
                                                              // readable parts
    }
  }

  /**
   * Reads and processes the subscriber commands according to the subscriber menu
   * 
   * @param subscriber Current logged in subscriber
   * @param scanner    Scanner object used to read the librarian command lines
   */
  private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displaySubscriberMenu();
    System.out.print(promptCommandLine);
    String subscriberCommand = scanner.nextLine();
    String[] subscriberCommands = subscriberCommand.trim().split(" ");
    while (subscriberCommands[0].trim().charAt(0) != '9') { // '3': Exit the application
      switch (subscriberCommands[0].trim().charAt(0)) {
        case '1':
          // check out a book
          Book bookCheckingOut = null; // initialize the book being checked out to null
          for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == Integer.parseInt(subscriberCommands[1])) {
              bookCheckingOut = books.get(i); // replace the book with reference to the book if it
                                              // is found in the list of books
            }
          }
          subscriber.checkoutBook(bookCheckingOut); // check out the book for the subscriber
          break;
        case '2':
          // return a book for a subscriber
          Book bookReturning = null; // initialize the book being checked out to null
          // using for loop to get the book
          for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == Integer.parseInt(subscriberCommands[1])) {
              bookReturning = books.get(i);
            }
          }
          subscriber.returnBook(bookReturning); // return the book for the subscriber
          break;
        case '3':
          // search a book by title
          // search for books with the same title
          if (findBookByTitle(subscriberCommands[1]).size() > 0) {
            ArrayList<Book> booksFound = findBookByTitle(subscriberCommands[1]);
            // print the books that are found
            for (int i = 0; i < booksFound.size(); i++) {
              System.out.println("<Book ID>: " + booksFound.get(i).getID() + " <Title>: "
                  + booksFound.get(i).getTitle() + " <Author>: " + booksFound.get(i).getAuthor()
                  + " <Is Available>: " + booksFound.get(i).isAvailable());
            }
          }
          break;
        case '4':
          // search for books by author
          // search for books with the same author
          if (findBookByAuthor(subscriberCommands[1]).size() > 0) {
            ArrayList<Book> booksFound = findBookByAuthor(subscriberCommands[1]);
            // print the books that are found
            for (int i = 0; i < booksFound.size(); i++) {
              System.out.println("<Book ID>: " + booksFound.get(i).getID() + " <Title>: "
                  + booksFound.get(i).getTitle() + " <Author>: " + booksFound.get(i).getAuthor()
                  + " <Is Available>: " + booksFound.get(i).isAvailable());
            }
          }
          break;
        case '5':
          // display books checked out by the subscriber
          subscriber.displayBooksCheckedOut();
          break;
        case '6':
          // display books that the subscriber returned
          subscriber.displayHistoryBooksReturned();
          break;
        case '7':
          // change the address of the subscriber
          subscriber.setAddress(subscriberCommands[1]);
          break;
        case '8':
          // change the phonNumber of the subscriber
          subscriber.setPhoneNumber(subscriberCommands[1]);
          break;
      }
      displaySubscriberMenu();
      System.out.print(promptCommandLine);
      subscriberCommand = scanner.nextLine(); // to grab input commands from the subscriber
      subscriberCommands = subscriberCommand.trim().split(" ");
    }
  }
  
  /**
   * Main method that represents the driver for this application
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
    // create a new library object
    Library madisonLibrary = new Library("Madison, WI", "april", "abc");
    // read and process user command lines
    madisonLibrary.readProcessUserCommand(scanner);
    displayGoodByeLogoutMessage(); // display good bye message
    scanner.close();// close this scanner
  }

}
