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
import java.util.ArrayList;

/**
 * This class models an Action that represent the response to an object being clicked or dragged
 * onto another
 */
public class Action {
  // instance fields
  private String message; // message printed by this action (or null to do nothing)
  private Thing thing; // Thing so that this Action class can activate things


  /**
   * Creates a new Action with given message
   * 
   * @param message message printed by this action (or null to do nothing)
   */
  public Action(String message) {
    this.message = message; // initialize this new action
  }


  /**
   * Creates a new Action with given Thing
   * 
   * @param thing Thing so that this Action class can activate things
   */
  public Action(Thing thing) {
    this.thing = thing; // initialize this Thing object
  }

  /**
   * Creates a new Action with given message and Thing
   * 
   * @param message message printed by this action (or null to do nothing)
   * @param thing   Thing so that this Action class can activate things
   */
  public Action(String message, Thing thing) { //
    this.message = message; // initialize this new action
    this.thing = thing; // initialize this Thing object
  }

  /**
   * Call on an action on the array list
   * 
   * @param arrayThing array to have the Things
   */
  public void act(ArrayList<Thing> arrayThing) {
    // when message is not null, message is printed to System.out
    if (this.message != null) { //
      System.out.println(message);
    }
    // when the thing is not null, do some actions on it 
    if (this.thing != null) {
      this.thing.activate(); // activate the Thing if it is not null
      arrayThing.add(this.thing); // all the Thing to the array list
      this.thing = null; // change the thing field to null so that each thing is only activated once
    }
  }
}
