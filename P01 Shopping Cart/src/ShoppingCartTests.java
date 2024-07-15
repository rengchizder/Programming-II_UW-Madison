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
/////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////

/**
 * A class that contains multiple tests that test for the good functioning of different methods for
 * the main program and functionality of implementations.
 */
public class ShoppingCartTests {
  /**
   * Checks whether the total number of items within the cart is incremented after adding one item
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
    boolean testPassed = true; // boolean local variable evaluated to true
                               // if this test passed,
                               // false otherwise
    String[] cart = new String[20]; // shopping cart
    int count = 0; // number of items present in the cart (initially the
                   // cart is empty)

    // Add an item to the cart
    count = ShoppingCart.add(3, cart, count); // add an item of index 3 to
                                              // the cart
    // Check that count was incremented
    if (count != 1) {
      System.out.println("Problem detected: After adding only one item to the cart, "
          + "the cart count should be incremented. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether add and OccurrencesOf return the correct output when only one item is added to
   * the cart
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
    boolean testPassed = true; // evaluated to true if test passed without
                               // problems, false otherwise
    // define the shopping cart as an oversize array of elements of type
    // String
    // we can set an arbitrary capacity for the cart - for instance 10
    String[] cart = new String[10]; // shopping cart
    int count = 0; // number of items present in the cart (initially the
                   // cart is empty)

    // check that OccurrencesOf returns 0 when called with an empty cart
    if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
      System.out.println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
          + "empty. The result should be 0. But, it was not.");
      testPassed = false;
    }

    // add one item to the cart
    count = ShoppingCart.add(0, cart, count); // add an item of index 0 to
                                              // the cart

    // check that OccurrencesOf("Apples", cart, count) returns 1 after
    // adding the
    // item with key 0
    if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
      System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
          + "OccurrencesOf to count how many of that item the cart contains should return 1. "
          + "But, it was not the case.");
      testPassed = false;
    }

    return testPassed;
  }

  /**
   * Checks that items can be added more than one time and are found
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddOccurrencesOfDuplicateItems() {
    boolean testPassed = true;
    String[] cart = new String[20];
    int count = 0;

    // Add 3 duplicate items to the cart
    count = ShoppingCart.add(3, cart, count);
    count = ShoppingCart.add(3, cart, count);
    count = ShoppingCart.add(3, cart, count);

    // Check that count was incremented
    if (count != 3) {
      System.out.println("Problem detected: After adding three duplicate items to the cart, "
          + "the cart count should be incremented by 3. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks that the correct output is returned when the user tries to add too much items to the
   * cart exceeding its capacity the cart. It should also print a warning message to the user.
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddingTooMuchItems() {
    boolean testPassed = true;
    String[] cart = new String[2]; // Fixing the capacity of the cart to be small for testing
    int count = 0;

    // Add items to the cart
    count = ShoppingCart.add(3, cart, count);
    count = ShoppingCart.add(4, cart, count);
    count = ShoppingCart.add(5, cart, count);

    // Check that count was not incremented and a warning is printed to console
    if (count != 2) {
      System.out.println(
          "Problem detected: The cart count should not be incremented after reaching the capacity. "
              + "But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks that when only one attempt to remove an item present in the cart is made, only one
   * occurrence of that item is removed from the cart.
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testRemoveOnlyOneOccurrenceOfItem() {
    boolean testPassed = true;
    String[] cart = new String[10];
    int count = 0;

    count = ShoppingCart.add(1, cart, count);
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(3, cart, count);
    // Remove an instance of Apple from the cart
    count = ShoppingCart.remove("Apple", cart, count);

    // Check that count was reduced
    if (count != 2) {
      System.out.println("Problem detected: After removing one item from the cart, "
          + "the cart count should be decreased. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks removing an item that has multiple occurrences in the cart would result in removing the
   * first of the item present from the cart, and only one of them is removed from the cart.
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testRemoveFromMultipleOccurrencesOfItem() {
    boolean testPassed = true;
    String[] cart = new String[10];

    // Add duplicate items to the cart
    int count = 0;
    count = ShoppingCart.add(1, cart, count);
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(0, cart, count);

    // Remove an item that has multiple occurrences in the cart
    count = ShoppingCart.remove("Apple", cart, count);

    // Check that count was reduced
    if (count != 3) {
      System.out.println("Problem detected: After removing one item from the cart, "
          + "the cart count should be decreased. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks that remove returns false when the user tries to remove an item not present within the
   * cart
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testRemoveItemNotFoundInCart() {
    boolean testPassed = true;
    String[] cart = new String[10];
    int count = 0;

    // Add duplicate items to the cart
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(0, cart, count);

    // Try to remove item not in the cart from it. The count should not decrease since nothing is
    // removed. It should also print a warning when the item is not present in the cart
    count = ShoppingCart.remove("Avocado", cart, count);

    // Check that count was not reduced
    if (count != 3) {
      System.out.println("Problem detected: After removing one item not found in the cart, "
          + "the cart count should not be decreased. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks if removing an item from an empty cart would not reduce or changing the number of item
   * in the cart, which is zero.
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testRemoveItemFromEmptyCart() {
    boolean testPassed = true;
    String[] cart = new String[10];
    int count = 0;

    // Test to remove a random item from empty cart the count should remain zero since no item was
    // removed. It should also print a warning
    count = ShoppingCart.remove("Avocado", cart, count);

    // Check that count was not reduced
    if (count != 0) {
      System.out.println("Problem detected: After removing item from empty cart, "
          + "the cart count should remain zero. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks if the subtotal price value of the cart is reasonably close to the expected true value
   * of the cart for a cart with different items.
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testSubTotalPrice() {
    boolean testPassed = true;
    String[] cart = new String[20];
    int count = 0;

    // Add items to the cart
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(1, cart, count);
    count = ShoppingCart.add(2, cart, count);
    double value = ShoppingCart.getSubTotalPrice(cart, count);
    if (Math.abs(value - 2.67) > 0.01) { // We check the closeness of the value as compared to the
                                         // truth and not the exact equality. We set an epsilon of
                                         // $0.01 for the difference and $2.67 is hand calculated
                                         // expected true value
      System.out.println("Problem detected: The subtotal value of the cart is wrong");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks if the subtotal price value of the cart is reasonably close to the expected true value
   * of the cart for empty cart.
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testSubTotalPriceForEmptyCart() {
    boolean testPassed = true;
    String[] cart = new String[20];
    int count = 0;

    // Getting the subtotal price for the cart
    double value = ShoppingCart.getSubTotalPrice(cart, count);
    if (Math.abs(value - 0) > 0.01) { // We check the closeness of the value as compared to the
                                      // truth and not the exact equality. We set an epsilon of
                                      // $0.01 for the difference
      System.out.println("Problem detected: The subtotal value of the cart is wrong");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testCountIncrementedAfterAddingOnlyOneItem(): "
        + testCountIncrementedAfterAddingOnlyOneItem());
    System.out.println(
        "testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
    System.out
        .println("testAddOccurrencesOfDuplicateItems(): " + testAddOccurrencesOfDuplicateItems());
    System.out.println("testAddingTooMuchItems(): " + testAddingTooMuchItems());
    System.out
        .println("testRemoveOnlyOneOccurrenceOfItem(): " + testRemoveOnlyOneOccurrenceOfItem());
    System.out.println(
        "testRemoveFromMultipleOccurrencesOfItem(): " + testRemoveFromMultipleOccurrencesOfItem());
    System.out.println("testRemoveItemNotFoundInCart(): " + testRemoveItemNotFoundInCart());
    System.out.println("testRemoveItemFromEmptyCart(): " + testRemoveItemFromEmptyCart());
    System.out.println("testSubTotalPrice(): " + testSubTotalPrice());
    System.out.println("testSubTotalPriceForEmptyCart(): " + testSubTotalPriceForEmptyCart());
  }
}
