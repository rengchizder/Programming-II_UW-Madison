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

/**
 * This class models a DragAndDroppableThing that extends DraggableThing, allows us to specify a
 * target for this kind of thing to be dropped on along with an action that is produced when this
 * happens.
 **/
public class DragAndDroppableThing extends DraggableThing {
  // instance fields
  private VisibleThing target; // object over which this object can be dropped
  private Action action; // action that results from dropping this object over target

  /**
   * Creates a new DragAndDroppableThing with the parameters and initialize the new object
   * 
   * @param name   name of this object
   * @param x      the horizontal position (in pixels of this thing's left side)
   * @param y      the vertical position (in pixels of this thing's top side)
   * @param target object over which this object can be dropped
   * @param action action that results from dropping this object over target
   */
  public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) {
    super(name, x, y); // call parent class method
    this.target = target; // initialize target
    this.action = action; // initialize action
  }

  /**
   * This method returns action and deactivates objects in response to successful drop When this
   * object is over its target and its target is active: deactivate both this object and the target
   * object, and return action, otherwise return null
   * 
   * return action of successful drop, otherwise return null
   */
  @Override
  protected Action drop() {
    boolean deactivated = false; // initialize boolean to false
    if (this.isOver(target) == true && target.isActive() == true) {
      // if it is on the target and the target is active, deactive both of the objects and change
      // boolean to true
      target.deactivate();
      this.deactivate();
      deactivated = true;
    }
    if (deactivated == true) { // if the objects are deactived, return action for successful drop
      return action;
    } else { // else return null
      return null;
    }
  } 
}
