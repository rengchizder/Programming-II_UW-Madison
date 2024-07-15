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

/**
 * This class implements Iterator<Integer> and generates a sequence of even numbers started a
 * specified starting point
 *
 */
public class EvenNumbers implements Iterator<Integer> {
  // instance fields 
  private Integer evenNum; // the even number
  private boolean start = false; // a boolean and initialize to false

  /**
   * Create a new EvenNumbers and initialize the even number
   * 
   * @param evenNum even number
   */
  public EvenNumbers(Integer evenNum) {
    this.evenNum = evenNum; // initialize the even number
  }

  /**
   * This always return true so that next() method can continue for as many times as it is called
   * 
   * @return always return true
   */
  @Override
  public boolean hasNext() {
    return true;
  }

  /**
   * If it is the first time called, return original integer. Else, return the smallest even number that is larger
   * than the previously returned one
   * 
   * @return the smallest even number that is larger than the previously returned one
   */
  @Override
  public Integer next() {
    if (start == false) { // if it is the first time called, then we return the first value and set
                          // boolean to true
      start = true;
      return this.evenNum;
    } else { // else return the smallest even number that is larger than the previously returned one
      this.evenNum = this.evenNum + 2;
      return this.evenNum;
    }
  }
}
