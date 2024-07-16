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
/**
 * This class models a linked node in our application.
 */
public class LinkedBoxNode {
  // instance fields
  private Box box; // box that represents the data for this Linked node
  private LinkedBoxNode next; // reference to the next Linked Box Node

  // constructors
  /**
   * Creates a new LinkedBoxNode object with a given box and without referring to any next
   * LinkedBoxNode.
   * 
   * @param box the box that represents data
   */
  public LinkedBoxNode(Box box) {
    this.box = box; // initialize the box for this node
  }

  /**
   * Creates a new LinkedBoxNode object and sets its instance fields box and next to the specified
   * ones.
   * 
   * @param box  box that represents the data for this Linked node
   * @param next reference to the next Linked Box Node
   */
  public LinkedBoxNode(Box box, LinkedBoxNode next) {
    this.box = box; // initialize the box
    this.next = next; // initialize the reference to next Linked Box Node
  }

  // getters and setters methods
  /**
   * This method return the reference to the next Linked Box Node
   * 
   * @return reference to the next Linked Box Node
   */
  public LinkedBoxNode getNext() {
    return this.next;
  }

  /**
   * This method set the reference to the next Linked Box Node to the linked node given.
   * 
   * @param next reference to a Linked Box Node
   */
  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }

  /**
   * This method return the box that represents the data for this Linked node.
   * 
   * @return the box that represents the data for this Linked node
   */
  public Box getBox() {
    return this.box;
  }

  /**
   * This method set the box for this node to the box given.
   * 
   * @param box box to be set to this node's box.
   */
  public void setBox(Box box) {
    this.box = box;
  }
}
