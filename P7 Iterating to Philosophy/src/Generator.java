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
 * This class models an object that implements Iterable<T> and has ability to create iterators
 *
 */
public class Generator<T> implements Iterable<T> {
  // instance fields
  private T firstValue; // first value of type T
  private Function<T, T> generateNextFromLast; // a Function<T, T>
  private int length = -1; // length of calls for FiniteIterator and initialize to -1 for iterator()
                           // method

  /**
   * Create a new generator with the parameters
   * 
   * @param firstValue           first value of type T
   * @param generateNextFromLast a Function<T, T>
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast) {
    this.firstValue = firstValue; // initialize the firstValue
    this.generateNextFromLast = generateNextFromLast; // initialize the Function<T,T>
  }

  /**
   * Create a new generator with the parameters
   * 
   * @param firstValue           first value of type T
   * @param generateNextFromLast a Function<T, T>
   * @param length               length of calls for FiniteIterator
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast, int length) {
    this.firstValue = firstValue; // initialize the firstValue
    this.generateNextFromLast = generateNextFromLast; // initialize the Function<T,T>
    this.length = length; // initialize the length
  }

  /**
   * This method return a new InfiniteIterator or FiniteIterator depending on whether length is
   * passed as parameter to constructor
   * 
   * @return a new iterator
   */
  @Override
  public Iterator<T> iterator() {
    if (length == -1) { // when no length is input as parameter to constructor, create
                        // InfiniteIterator
      InfiniteIterator<T> newInf = new InfiniteIterator<>(firstValue, generateNextFromLast);
      return (newInf);
    } else { // else, create FiniteIterator
      InfiniteIterator<T> newInf = new InfiniteIterator<>(firstValue, generateNextFromLast);
      FiniteIterator<T> newFin = new FiniteIterator<>(newInf, length);
      return (newFin);
    }
  }
}
