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
 * This class models a ClickableThing that extends VisibleThing, represents object that we want to interact with by clicking.  
 */
public class ClickableThing extends VisibleThing {
  // instance fields
  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

  /**
   * Create a clickable thing with the parameters and initializes this new object.
   * 
   * @param name   name of this object
   * @param x      the horizontal position (in pixels of this thing's left side)
   * @param y      the vertical position (in pixels of this thing's top side)
   * @param action action returned from update when this object is clicked
   */
  public ClickableThing(String name, int x, int y, Action action) {
    super(name, x, y); // call parent class method
    this.action = action; // initialize action
    mouseWasPressed = false; // initialize mouseWasPressed as false
  }

  /**
   * calls VisibleThing update, then returns action only when mouse is first clicked
   * 
   * return action only when mouse is first clicked, null is returned otherwise
   */
  @Override
  public Action update() {
    super.update(); // call parent class update method
    // action will only be returned if mouse was not pressed but is pressed now and the mouse is on
    // the object, else return null
    if (mouseWasPressed == false && getProcessing().mousePressed == true
        && isOver(getProcessing().mouseX, getProcessing().mouseY) == true) {
      mouseWasPressed = true;
      return action;
    } else if (getProcessing().mousePressed == false) {
      mouseWasPressed = false; // changes mouseWasPressed to false if mousePressed equals false to
                               // keep this method running
      return null;
    } else if (getProcessing().mousePressed == true // we need to make sure that mouseWasPressed
                                                    // changes to true ig it was pressed
        && isOver(getProcessing().mouseX, getProcessing().mouseY) == false) {
      mouseWasPressed = true;
      return null;
    } else {
      return null;
    }
  }
}

