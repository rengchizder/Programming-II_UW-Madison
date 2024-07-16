//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P09 Dictionary Using BST
// Files: Dictionary.java, DictionaryWord.java, DictionaryBST.java, DictionaryDriver.java,
//////////////////// DictionaryTests.java
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
 * The main driver class of this dictionary.
 *
 */
public class DictionaryDriver {

  /**
   * Displays the main menu
   */
  private static void displayMainMenu() {
    System.out.println("=========================== Dictionary ============================");
    System.out.println("Enter one of the following options:");
    System.out
        .println("[A <word> <meaning>] to add a new word and its definition in the dictionary");
    System.out.println("[L <word>] to search a word in the dictionary and display its definition");
    System.out.println("[G] to print all the words in the dictionary in sorted order");
    System.out.println("[S] to get the count of all words in the dictionary");
    System.out
        .println("[H] to get the height of this dictionary implemented as a binary search tree");
    System.out.println("[Q] to quit the program");
    System.out.println("======================================================================");
    System.out.println("");
  }

  /**
   * Main method that represents the driver for this application
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // create new scanner object read user inputs
    DictionaryBST newDictionary = new DictionaryBST(); // create new DictionaryBST object
    String promptCommandLine = "Please enter your command: ";
    displayMainMenu();
    System.out.print(promptCommandLine);
    String command = scanner.nextLine(); // read user command line
    String[] commands = command.trim().split(" "); // split user command
    while (!(commands[0].toUpperCase().equals("Q") && commands.length == 1)) { // "Q": Exit the
                                                                               // application
      switch (commands[0].toUpperCase()) {
        case "A": // "A": add new word and definition to dictionary
          if (commands.length >= 3) { // to make sure we have both word and meaning
            try {
              String[] parts = command.split(" ", 3); // this is so that the meaning part can have
                                                      // spaces
              if (newDictionary.addWord(commands[1], parts[2]) == true) { // return true is
                                                                          // successfully added word
              } else { // else, print error
                System.out.println("WARNING: failed to add duplicate word:" + commands[1] + ".");
              }
            } catch (Exception e) { // catch whatever error we may encounter, for safety
              System.out.println(e.getMessage()); // print error message
            }
            break;
          } else {
            System.out.println("WARNING: Syntax Error for [A <word> <meaning>] command line.");
          }
          break;
        case "L": // "L" look up a word
          if (commands.length == 2) { // make sure no extra input
            try {
              if (newDictionary.size() == 0) { // print error if dictionary is empty
                System.out.println("There are no definitions in this empty dictionary.");
              } else {
                System.out.println( // else print out the word and meaning
                    commands[1] + ":" + newDictionary.lookup(commands[1].toString().trim()));
              }
            } catch (Exception e) { // catch whatever error we may encounter, for safety
              System.out.println(e.getMessage()); // print error message
            }
            break;
          } else {
            System.out.println("WARNING: Syntax Error");
            break;
          }
        case "G": // "G" get all words in sorted order
          if (commands.length == 1) { // make sure no extra input
            try {
              if (newDictionary.getAllWords().isEmpty() == true) { // print warning if dictionary
                                                                   // empty
                System.out.println("Dictionary is empty.");
              } else {
                ArrayList<String> list = newDictionary.getAllWords(); // create new arrayList to get
                                                                      // all words
                for (int i = 0; i < list.size() - 1; i++) { // go through the list and print all
                                                            // words except last
                  System.out.print(newDictionary.getAllWords().get(i) + ", ");
                }
                System.out.println(newDictionary.getAllWords().get(list.size() - 1)); // last word
                                                                                      // printed
                                                                                      // without
                                                                                      // comma
                                                                                      // followed
              }
              break;
            } catch (Exception e) { // catch whatever error we may encounter, for safety
              System.out.println(e.getMessage()); // print error message
            }
            break;
          } else {
            System.out.println("WARNING: Syntax Error");
            break;
          }
        case "S": // "S" print size of dictionary
          if (commands.length == 1) { // make sure no extra input
            try {
              System.out.println(newDictionary.size());
            } catch (Exception e) { // catch whatever error we may encounter, for safety
              System.out.println(e.getMessage()); // print error message
            }
            break;
          } else {
            System.out.println("WARNING: Syntax Error");
            break;
          }
        case "H": // "H" print height of the tree
          if (commands.length == 1) { // make sure no extra input
            try {
              System.out.println(newDictionary.height());
            } catch (Exception e) { // catch whatever error we may encounter, for safety
              System.out.println(e.getMessage()); // print error message
            }
            break;
          } else {
            System.out.println("WARNING: Syntax Error");
            break;
          }
        default: // if no matching command, print warning
          System.out.println("WARNING: Unrecognized command.");
          break;
      }
      System.out.println("");
      displayMainMenu();
      System.out.print(promptCommandLine);
      command = scanner.nextLine(); // read user command line
      commands = command.trim().split(" "); // split user command line
    }

    System.out.println("============================== END ===================================");
    scanner.close();
  }
}
