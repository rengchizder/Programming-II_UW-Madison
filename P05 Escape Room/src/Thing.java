//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P05 Escape Room
// Files: EscapeRoom.java, Action.java, Thing.java, VisibleThing.java, ClickableThing.java,
//////////////////// DraggableThing.java, DragAndDroppableThing.java
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
import processing.core.PApplet;

/**
 * This class models a Thing object that organize the capabilities that are common to all
 * interactive things in our game.
 *
 */
public class Thing {
  // instance fields
  private final String NAME; // the constant name identifying this object
  private boolean isActive; // active means thing is visible and can be interacted with

  // static fields
  private static PApplet processing = null; // processing field so that we can use PApplet's
                                            // capabilities for Thing object

  /**
   * Set the processing field of this Thing
   * 
   * @param processing processing field
   */
  public static void setProcessing(PApplet processing) {
    Thing.processing = processing; // initializes processing field
  }

  /**
   * Accessor method to retrieve this the PApplet processing field.
   * 
   * @return the processing field
   */
  protected static PApplet getProcessing() {
    return Thing.processing;
  }

  /**
   * Create a new Thing with the name provided.
   * 
   * @param name name of this thing
   */
  public Thing(String name) {
    this.NAME = name; // initialize name
    this.isActive = true; // set isActive to true
  }

  /**
   * Returns true only when contents of name equal NAME.
   * 
   * @param name name of this Thing
   * @return true if the contents of name equal NAME
   */
  public boolean hasName(String name) {
    boolean equal = false; // initialize the boolean
    if (name.equals(NAME)) {
      equal = true; // if the contents of name equal NAME, return true
    }
    return equal; // return true or false
  }

  /**
   * Returns true only when isActive is true.
   * 
   * @return true if isActive is true.
   */
  public boolean isActive() {
    boolean result = false; // initialize the boolean
    if (isActive == true) {
      result = true; // if isActive field of this Thing returns true, then return true
    }
    return result; // return true or false
  }

  /**
   * A method to activate this Thing.
   */
  public void activate() {
    this.isActive = true; // changes isActive to true
  }

  /**
   * A method to deactivate this Thing.
   */
  public void deactivate() {
    this.isActive = false; // changes isActive to false
  }

  /**
   * Method to call update method for this Thing. However, it is set to return null for the common
   * Thing so that it will be overrode by subclass
   * 
   * @return null nothing will be returned
   */
  public Action update() {
    // this method returns null subclass types will override this update() method to do more
    // interesting things
    return null;
  }

}
