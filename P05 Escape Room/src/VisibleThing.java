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
import java.io.File;
import processing.core.PImage;

/**
 * This class models VisibleThing that extends Thing class, represents a visible object with a
 * graphical representation in our game.
 */
public class VisibleThing extends Thing {
  // instance fields
  private PImage image; // the graphical representation of this thing
  private int x; // the horizontal position (in pixels of this thing's left side)
  private int y; // the vertical position (in pixels of this thing's top side)

  /**
   * Create a new visible thing with the parameters and initialize this new thing
   * 
   * @param name name of the visible thing
   * @param x    horizontal position of the visible thing
   * @param y    vertical position of the visible thing
   */
  public VisibleThing(String name, int x, int y) {
    super(name); // call parent class method
    // the image for this visible thing should be loaded from : "images"+File.separator+ name
    // +".png"
    image = getProcessing().loadImage("images" + File.separator + name + ".png");
    this.x = x; // initialize x
    this.y = y; // initialize y
  }

  /**
   * Update method for the visible thing, it draws image at its position before returning null
   * 
   * return Action null is returned
   */
  @Override
  public Action update() {
    getProcessing().image(image, x, y); // draw image at this position, x and y
    return null;
  }

  /**
   * This method moves the object by dx for x and dy for y.
   * 
   * @param dx difference in x
   * @param dy difference in y
   */
  public void move(int dx, int dy) {
    // changes x by adding dx to it (and y by dy)
    this.x = x + dx;
    this.y = y + dy;
  }

  /**
   * This method checks if point x,y is over image and return true if it is.
   * 
   * @param x point x
   * @param y point y
   * @return true if point x,y is over image
   */
  public boolean isOver(int x, int y) { // return true only when point x,y is over image
    boolean over = true; // initialize the boolean
    if (this.x > x || (this.x + this.image.width) < x) { // this check if x is within the x
                                                         // coordinates that object is having
      over = false;
    }
    if (this.y > y || (this.y + this.image.height) < y) { // this check if y is within the y
                                                                 // coordinates that object is
                                                                 // having
      over = false;
    }
    return over; // return true if x,y is over image
  }

  /**
   * This method checks if other's image overlaps this one's
   * 
   * @param other other image
   * @return true only when other's image overlaps this one's
   */
  public boolean isOver(VisibleThing other) {
    boolean over = true; // initialize boolean
    // this check is other's x coordinates overlap with this object's x coordinates
    if (this.x + this.image.width < other.x || this.x > (other.x + other.image.width)) {
      over = false;
    } 
    if (this.y > (other.y + other.image.height) || (this.y + this.image.height) < other.y) {
      // this check is other's y coordinates overlap with this object's y coordinates
      over = false;
    }
    if (over == true) { // if any of the two dimensions does not overlap than it returns false, if
                        // not it means that they overlap
    }
    return over;
  }
}
