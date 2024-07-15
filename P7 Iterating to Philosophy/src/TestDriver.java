//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 Iterating to Philosophy
// Files: TestDriver.java, EvenNumbers.java, InfiniteIterator.java, FiniteIterator.java,
//////////////////// Generator.java, NextWikiLink.java
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
import java.util.Iterator;
import java.util.function.Function;

/**
 * This class models the test driver for this program
 * 
 */
public class TestDriver {

  /**
   * Main method used to call the tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    testEvenNumbers();
    testPowersOfTwo();
    testAddExtraSmile();
    testFiniteIterator();
    testGenerator();
  }

  /**
   * Test the functionality of even number iterator
   * 
   * @return true if it is functioning well
   */
  public static boolean testEvenNumbers() {
    EvenNumbers it = new EvenNumbers(44); // create new even number iterator
    if (it.next() != 44) {
      System.out.println("The first call of EvenNumbers.next() "
          + "did not return the value passed into its constructor.");
      return false;
    }
    if (it.next() != 46) {
      System.out.println(
          "The second call of EvenNumbers.next() " + "did not return the smallest even number, "
              + "that is larger than the previously returned number.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out.println("EvenNumbers.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }

  /**
   * Test the functionality of infinite iterator (powers of two)
   * 
   * @return true if it is functioning well
   */
  public static boolean testPowersOfTwo() {
    InfiniteIterator<Integer> it = new InfiniteIterator<>(8, new NextPowerOfTwo()); // create new
                                                                                    // infinite
                                                                                    // iterator
    if (it.next() != 8) {
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the number passed into its constructor.");
      return false;
    }
    if (it.next() != 16) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the smallest power of two number, "
          + "that is larger than the previously returned number.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }

  /**
   * Test the functionality of infinite iterator (extra smiles)
   * 
   * @return true if it is functioning well
   */
  public static boolean testAddExtraSmile() {
    InfiniteIterator<String> it = new InfiniteIterator<>("Hello", new AddExtraSmile()); // create
                                                                                        // new
                                                                                        // infinite
                                                                                        // iterator
    if (!it.next().equals("Hello")) {
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the string passed into its constructor.");
      return false;
    }
    if (!it.next().contains(" :)")) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the a string with one more :), "
          + "than the previously returned string.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }

  /**
   * Test the functionality of finite iterator
   * 
   * @return true if it is functioning well
   */
  public static boolean testFiniteIterator() {
    // create new infinite iterator to be used to create finite iterator
    InfiniteIterator<Integer> infinite = new InfiniteIterator<>(2, new NextPowerOfTwo());
    FiniteIterator<Integer> it = new FiniteIterator<>(infinite, 8); // create new finite iterator
    String s = "";
    while (it.hasNext())
      s += " " + it.next();
    if (!s.equals(" 2 4 8 16 32 64 128 256")) {
      System.out.println("Repeatedly called the next() method of a FiniteIterator,"
          + "and the incorrect valuese were returned:" + s);
      return false;
    }
    return true;
  }

  /**
   * Test the functionality of generator iterable
   * 
   * @return true if it is functioning well
   */
  public static boolean testGenerator() {
    boolean correct = true; // create a boolean variable and initialize to true
    int length = 5; // create a new length number that next() can be called
    Generator<Integer> testFinGen = new Generator<>(2, new NextPowerOfTwo(), length); // create new
                                                                                      // generator
                                                                                      // with the
                                                                                      // parameters
    Iterator<Integer> testIterator = testFinGen.iterator(); // call iterator() on the generator to
                                                            // create an iterator
    for (int testCheck : testFinGen) { // test to see if the finite iterator works well
      if (testIterator.next() != testCheck) {
        correct = false;
        System.out.println("Generator not functioning well");
      }
    }
    return correct;
  }
}


/**
 * This class model a function that generate powers of two and implements Function<Integer, Integer>
 *
 */
class NextPowerOfTwo implements Function<Integer, Integer> {

  /**
   * Method that multiple the previous integer by two
   * 
   * @return multiplied integer
   */
  @Override
  public Integer apply(Integer previous) {
    return 2 * previous;
  }
}


/**
 * This class model a function that adds an extra smile face to the end of a string and implements
 * Function<String, String>
 *
 */
class AddExtraSmile implements Function<String, String> {

  /**
   * Method that adds extra smile face to the end of a string
   * 
   * @return string with added smile face
   */
  @Override
  public String apply(String string) {
    return string + " :)";
  }
}
