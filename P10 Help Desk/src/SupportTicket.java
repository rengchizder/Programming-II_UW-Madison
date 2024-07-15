//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Help Desk
// Files: SupportTicket.java, HelpDesk.java, HelpDeskTestSuite.java, HelpDeskInterface.java
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
 * This class implements a SupportTicket used in a HelpDesk that implements
 * Comparable<SupportTicket>
 *
 */
public class SupportTicket implements Comparable<SupportTicket> {
  // instance field
  private String string; // string of message

  /**
   * Construct a new SupportTicket with string message
   * 
   * @param string string of message
   */
  public SupportTicket(String string) {
    if (string == null) { // throw NullPointerException when string is reference to null
      throw new NullPointerException("String is reference to null");
    } else {
      this.string = string; // initialize the string
    }
  }

  /**
   * This method return the string of message of this ticket
   * 
   * @return string of message
   */
  public String toString() {
    return this.string;
  }

  /**
   * This method compare the strings in two SupportTicket. It returns positive value if this
   * SupportTicket has longer length than the other one, or negative otherwise. If length is the
   * same, the strings are compared lexographically
   * 
   * @param another SupportTicket
   * @return the result of comparison in integer
   */
  @Override
  public int compareTo(SupportTicket o) {
    if (string.length() < o.string.length()) { // return negative if length less than the other
      return -10;
    } else if (string.length() > o.string.length()) { // return positive if string length more than
                                                      // the other
      return 10;
    } else {
      return (string.compareTo(o.string)); // if same length, compare lexographical order
    }
  }
}
