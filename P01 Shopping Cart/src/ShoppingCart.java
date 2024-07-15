//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P01 - Shopping Cart
// Files: ShoppingCart.java, ShoppingCartTests.java
// Course: (course number, term, and year)
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
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

/**
 * This file contains the methods for good functioning of the shopping cart and also the driver
 * application
 * <p>
 * The program will prompt the user to enter different inputs for different purposes for the
 * shopping cart.
 */
public class ShoppingCart {
  // Define final parameters
  private static final int CART_CAPACITY = 20; // shopping cart max capacity
  private static final double TAX_RATE = 0.05; // sales tax

  // a perfect-size two-dimensional array that stores the available items in
  // the
  // market
  // MARKET_ITEMS[i][0] refers to a String that represents the description of
  // the
  // item
  // identified by index i
  // MARKET_ITEMS[i][1] refers to a String that represents the unit price of
  // the
  // item
  // identified by index i in dollars.
  public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},
      {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
      {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
      {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
      {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
      {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
      {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

  /**
   * Adds the item with the given identifier index at the end of the cart
   * 
   * @param index of the item within the marketItems array
   * @param cart  shopping cart
   * @param count number of items present within the cart before this add method is called
   * @return the number of items present in the cart after the item with identifier index is added
   */
  public static int add(int index, String[] cart, int count) {
    // We want to make sure that the a warning is printed and the count of the cart not changed when
    // the cart is full
    if (count >= cart.length) {
      System.out.println("WARNING: The cart is full. You cannot add any new item.");
    } else {
      cart[count] = MARKET_ITEMS[index][0];
      count++;
    }
    return (count);
  }

  /**
   * Returns how many occurrences of the item with index itemIndex are present in the shopping cart
   * 
   * @param itemIndex identifier of the item to count its occurrences in the cart
   * @param cart      shopping cart
   * @param count     number of items present within the cart
   * @return the number of occurrences of item in the cart
   */
  public static int occurrencesOf(int itemIndex, String[] cart, int count) {
    int occur = 0;
    for (int i = 0; i < count; i++) {
      if (cart[i] == getItemDescription(itemIndex)) {
        occur = occur + 1;
      }
    }
    return occur;
  }

  /**
   * Returns the item description of an item given its index
   * 
   * @param index the index of an item in the marketItems array
   * @return the item description of the given item
   */
  private static String getItemDescription(int index) {
    String description = MARKET_ITEMS[index][0];
    return description;
  }

  /**
   * Removes the first (only one) occurrence of itemToRemove if found and returns the number of
   * items in the cart after remove operation is completed either successfully or not
   * 
   * @param itemToRemove the name of item to be removed from the cart
   * @param cart         shopping cart
   * @param count        number of items present within the cart before this remove method is called
   * @return the number of items present in the cart after the item with identifier index is removed
   */
  public static int remove(String itemToRemove, String[] cart, int count) {
    // calls indexOf method, if the item is not in the cart, indexOf method would return -1
    if (indexOf(itemToRemove, cart, count) == -1) {
      System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
    } else {
      // System.out.println(indexOf(itemToRemove, cart, count)); //testing the resulting cart
      // if itemToRemove is found, move element at the end of array to this index and update count
      // this remove the item from this index and reduce the count of the cart
      cart[indexOf(itemToRemove, cart, count)] = cart[count - 1];
      cart[count - 1] = null;
      count--;
    }
    // System.out.println(Arrays.toString(cart)); //testing the resulting cart
    return count;
  }

  /**
   * Returns the index of an item within the shopping cart
   * 
   * @param item  description
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   * @return index of the item within the shopping cart, and -1 if the item does not exist in the
   *         cart
   */
  private static int indexOf(String item, String[] cart, int count) {
    int index = -1;
    int i = 0;
    while (i < count) {
      if (cart[i] == item) {
        index = i;
        break;
      }
      i++;
    }
    return index;
  }

  /**
   * Returns the total value (cost) of the cart without tax in $ (double)
   * 
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   * @return the double value of the total cost of the cart without tax
   */
  public static double getSubTotalPrice(String[] cart, int count) {
    double value = 0;
    // we go through each item in the cart and sum the total price
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < MARKET_ITEMS.length; j++) {
        if (cart[i] == MARKET_ITEMS[j][0]) {
          String subtring = (MARKET_ITEMS[j][1]).substring(1);
          value = value + Double.valueOf(subtring);
        }
      }
    }
    return value;
  }

  /**
   * Prints the Market Catalog (item identifiers, description, and unit prices)
   */
  public static void printMarketCatalog() {
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n" + "Item id" + "\t\t"
        + "Description" + "    \t " + "Price\n" + "+++++++++++++++++++++++++++++++++++++++++++++");
    for (int i = 0; i < MARKET_ITEMS.length; i++) {
      System.out.println(i + "\t\t" + MARKET_ITEMS[i][0] + "    \t " + MARKET_ITEMS[i][1]);
    }
  }

  /**
   * Displays the cart content (items separated by commas)
   * 
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   */
  public static void displayCartContent(String[] cart, int count) {
    System.out.print("Cart Content: ");
    for (int i = 0; i < count; i++) {
      System.out.print(cart[i] + ", ");
    }
    System.out.println();
  }

  /**
   * The driver application that display welcome message, thank you message, command prompts and the
   * overall functionality of the program
   * <p>
   * This program functions as a shopping cart that allows the user to add/ remove items from the
   * shopping cart. The user also can display the cart alongside different functions that the
   * shopping cart has.
   * 
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    // Prints the welcome message and initialize the cart and its count
    System.out.println("=============   Welcome to the Shopping Cart App   =============" + "\n");
    boolean quit = false;
    String[] cart = new String[CART_CAPACITY]; // shopping cart with cart capacity
    int count = 0;

    // Loop for the command prompts
    while (quit == false) {
      System.out.print("\nCOMMAND MENU:\n" + " [P] print the market catalog\n"
          + " [A <index>] add one occurrence of an item to the cart given its identifier\n"
          + " [C] checkout\n" + " [D] display the cart content\n"
          + " [O <index>] number of occurrences of an item in the cart given its identifier\n"
          + " [R <index>] remove one occurrence of an item from the cart given its identifier\n"
          + " [Q]uit the application\n" + "\n" + "ENTER COMMAND: ");
      char command;

      // Getting the input from the user and split it into string (converted to character) for the
      // command and integer for index, if present
      String raw = scnr.nextLine();
      String[] input = raw.split("\\s+");
      int index = 0;
      if (input.length > 1) { // this if-else prevent error caused when no integer was input
        command = (input[0].toUpperCase()).charAt(0);
        index = Integer.parseInt(input[1]);
      } else {
        command = (input[0].toUpperCase()).charAt(0);
      }

      // (input.length > 1) is required so that for example a0 would not has any effect to the cart
      if (command == 'A' && input.length > 1) {
        count = add(index, cart, count);
        // System.out.println(Arrays.toString(cart));
      } else if (command == 'C') {
        // subtotal cost, tax and total cost are rounded off to 2 decimal places as required
        double subtotalCost = getSubTotalPrice(cart, count);
        double TAX = subtotalCost * TAX_RATE;
        double totalCost = subtotalCost + TAX;
        System.out.println(
            "#items: " + count + " Subtotal: $" + String.format("%.2f", subtotalCost) + " Tax: $"
                + String.format("%.2f", TAX) + " TOTAL: $" + String.format("%.2f", totalCost));
      } else if (command == 'D') {
        displayCartContent(cart, count);
      } else if (command == 'O' && input.length > 1) {
        int occur = occurrencesOf(index, cart, count);
        System.out.println("The number of occurrences of " + MARKET_ITEMS[index][0] + " (id #"
            + index + ") is: " + occur);
      } else if (command == 'R' && input.length > 1) {
        count = remove(MARKET_ITEMS[index][0], cart, count);
      } else if (command == 'Q') {
        quit = true;
      }
    }
    System.out.print("=============  Thank you for using this App!!!!!  =============\n");
  }
}
