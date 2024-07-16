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
 * This class models a finite iterator that implements Iterator<T>. It retrieves a fixed number of
 * elements from any InfiniteIterator
 *
 */
public class FiniteIterator<T> implements Iterator<T> {
  // instance fields 
  private InfiniteIterator<T> general; // a generic InfiniteIterator
  private int num; // number of calls of next() method that can be made
  private int count = 0; // a count of number of calls of next() method made

  /**
   * Create a new FiniteIterator that takes the parameters in
   * 
   * @param general a generic InfiniteIterator
   * @param num     number of calls of next() method that can be made
   */
  public FiniteIterator(InfiniteIterator<T> general, int num) {
    this.general = general; // initialize the InfiniteIterator
    this.num = num; // initialize the number
  }

  /**
   * This method begins returning false after the first “length” calls of the FiniteIterator’s
   * next() method have been made
   * 
   * @return true if next() method can still be called
   */
  @Override
  public boolean hasNext() {
    // return true if next() method can still be called
    if (count >= num) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Return the value returned from a call to the provided InfiniteIterator’s next() method if
   * hasNext() is still true, else return null
   * 
   * @return the value returned from a call or null otherwise
   */
  @Override
  public T next() {
    if (hasNext() == true) {
      count++; // update the count
      return (this.general.next());
    } else {
      return null;
    }
  }
}
