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
 * This class models a DraggableThing that extends VisibleThing, that allows the user to drag it
 * around the screen.
 */
public class DraggableThing extends VisibleThing {
  // instance fields
  private boolean mouseWasPressed; // similar to use in ClickableThing
  private boolean isDragging; // true when this object is being dragged by the user
  private int oldMouseX; // horizontal position of mouse during last update
  private int oldMouseY; // vertical position of mouse during last update

  /**
   * This creates a draggable thing with these parameters and initializes the new thing
   * 
   * @param filename name of this object
   * @param x        the horizontal position (in pixels of this thing's left side)
   * @param y        the vertical position (in pixels of this thing's top side)
   */
  public DraggableThing(String filename, int x, int y) { // initialize new thing
    super(filename, x, y); // call parent class method
    mouseWasPressed = false; // initialize mouseWasPressed as false
    isDragging = false; // initialize isDragging as false
    this.oldMouseX = x; // initialize the x position of this object at x
    this.oldMouseY = y; // initialize the y position of this object at y
  }

  /**
   * calls VisibleThing update(), then moves according to mouse drag each time isDragging changes
   * from true to false, the drop() method below will be called once and any action objects returned
   * from that method should then be returned from update()
   * 
   * return Action null nothing is returned 
   */
  @Override
  public Action update() {
    super.update(); // call VisibleThing update()
    // changes mouseWasPressed and isDragging to true only when mouse was not pressed, is pressed
    // now and is on the object
    if (mouseWasPressed == false && getProcessing().mousePressed == true
        && isOver(getProcessing().mouseX, getProcessing().mouseY) == true) {
      mouseWasPressed = true;
      isDragging = true;
    } else if (mouseWasPressed == false && getProcessing().mousePressed == true
        && isOver(getProcessing().mouseX, getProcessing().mouseY) == false) {
      mouseWasPressed = true; // want to prevent moving resulting from pressing the mouse at other
                              // points and slid over the object
      isDragging = false;
    } else if (getProcessing().mousePressed == false) {
      mouseWasPressed = false; // revert mouseWasPressed to false so that this method can run
                               // repeatedly
      isDragging = false; // revert isDragging to false so that this object will not continue to
                          // move when not needed
    }
    // when it is dragging and mouseWasPressed is true and is pressed now, move the object to where
    // the mouse is moving
    if (isDragging == true && mouseWasPressed == true && getProcessing().mousePressed == true) {
      int distX = (getProcessing().mouseX - oldMouseX);
      int distY = (getProcessing().mouseY - oldMouseY);
      move(distX, distY);
      oldMouseX = oldMouseX + distX; // update the x position of this object
      oldMouseY = oldMouseY + distY; // update the y position of this object
      mouseWasPressed = true;
    }

    // to make sure that isDragging is switched back to false when it is not pressed now so that we
    // can return drop() later
    // to make sure that mouseWasPressed is set back to false when it is not being pressed
    if (mouseWasPressed == true && getProcessing().mousePressed == false && isDragging == true) {
      isDragging = false;
      mouseWasPressed = false;
    }

    if (isDragging == false) {
      return drop(); // drop the object and stop the object from doing anything else when is
                     // dragging is false
    }
    return null;
  }

  /**
   * this method returns null, subclass types will override this drop() method to do more
   * interesting things
   * 
   * @return null nothing is returned
   */
  protected Action drop() {
    return null;
  }
}
