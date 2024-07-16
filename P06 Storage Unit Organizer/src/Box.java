//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P06 Storage Unit Organizer
// Files: Box.java, StorageUnitTests.java, LinkedBoxList.java, StorageUnitOrganizer.java
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
import java.util.Random;

/**
 * This class models a box to be stored in a Storage Unit using our StorageUnitOrganizer
 * application.
 */
public class Box implements Comparable<Box> {
  // instance and static fields
  private static Random randGen = new Random(); // generator of random numbers
  private int color; // color of this box
  private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

  /**
   * Creates a new Box and initializes its instance fields color and weight to random values.
   */
  public Box() {
    this.color = randGen.nextInt(); // random color
    this.weight = randGen.nextInt((30 - 1) + 1) + 1; // weight must be between 1 inclusive and 31
                                                 // exclusive
  }

  /**
   * Creates a new Box and initializes its instance fields color and weight to the specified values.
   * Throws IllegalArgumentException if the provided weight value is out of the range of [1..30].
   * 
   * @param color  color of the box
   * @param weight weight of the box
   */
  public Box(int color, int weight) {
    this.color = color; // initialize color of box
    if (weight >= 1 && weight <= 30) { // test to see if the entered value is within the range, if
                                       // not throw exception
      this.weight = weight;
    } else {
      throw new IllegalArgumentException("Weight out of range.");
    }
  }

  /**
   * Equals method defined in Object class. Returns true if the specified other object is a Box and
   * this box and other have the same color and same weight. Otherwise, it returns false.
   * 
   * @param other other object, which should be a Box
   * @return true if the boxes have same color and same weight
   */
  @Override
  public boolean equals(Object other) {
    boolean isBoxAndSame = true; // initialize boolean to true
    if (other.getClass().equals(this.getClass()) == false) { // if the object is not of type Box,
                                                             // return false
      isBoxAndSame = false;
    } else if (this.color != ((Box) other).color || this.weight != ((Box) other).weight) {
      // return true only when the boxes have same color and weight
      isBoxAndSame = false;
    }
    return isBoxAndSame; // return boolean
  }

  /**
   * compareTo method defined in Comparable<Box> interface. Returns a negative integer, a positive
   * integer, or zero as this box is lighter than, heavier than, or has the same weight as the
   * specified otherBox.
   * 
   * @param otherBox the other box for comparison
   * @return the integer for difference in weight
   */
  @Override
  public int compareTo(Box otherBox) {
    int diff = 0; // initialize the difference
    diff = this.weight - otherBox.weight;
    return diff; // return difference in integer
  }

  /**
   * Getter for the instance field color of this box.
   * 
   * @return color of box
   */
  public int getColor() {
    return this.color;
  }

  /**
   * Getter for the instance field weight of this box.
   * 
   * @return weight of box
   */
  public int getWeight() {
    return this.weight;
  }
}
