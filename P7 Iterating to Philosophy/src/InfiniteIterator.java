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
 * This class models an infinite iterator that implements Iterator<T>. It generates any sequence in
 * which the next term in the sequence can be calculated based on the previous term
 *
 */
public class InfiniteIterator<T> implements Iterator<T> {
  // instance fields 
  private T general; // argument of any data type
  private boolean start = false; // a boolean for starting and initialize to false
  private Function<T, T> fun; // function that generate the next value based on the previous

  /**
   * Creates a new InfiniteIterator with the parameters
   * 
   * @param general variable of any data type
   * @param fun     function that generate the next value based on the previous
   */
  public InfiniteIterator(T general, Function<T, T> fun) {
    this.general = general; // initialize argument
    this.fun = fun; // initialize function
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
   * If it is the first time called, return the argument. Else, return the next value based on the
   * function
   * 
   * @return the first argument if it is the first time called, else return the next value
   */
  @Override
  public T next() {
    if (start == false) {
      start = true;
      return this.general;
    } else {
      this.general = this.fun.apply(this.general);
      return this.general;
    }
  }
}
