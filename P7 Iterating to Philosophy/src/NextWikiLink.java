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
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * This class model an object that implements Function<String, String>
 *
 */
public class NextWikiLink implements Function<String, String> {
  
  /**
   * This method follow the link in one Wikipedia page to the next
   * 
   * @return a string that has link attribute from first element of this list
   */
  @Override
  public String apply(String t) {
    try {
      // Download a Wikipedia page, using t in their internal link format: /wiki/Some_Subject
      Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
      // Use .css selector to retrieve a collection of links from this page's description
      // "p a" selects links within paragraphs
      // ":not([title^='Help'])" skips pronunciations
      // ":not(sup a)" skips citations
      Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
      // return the link attribute from the first element of this list
      return links.get(0).attr("href");
      // Otherwise return an appropriate error message:
    } catch (IOException | IllegalArgumentException e) {
      return "FAILED to find wikipedia page: " + t;
    } catch (IndexOutOfBoundsException e) {
      return "FAILED to find a link in wikipedia page: " + t;
    }
  }

  /**
   * Main method that implement Wikipedia crawling application
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    // prompt the user to enter a topic name and number of iterations to follow
    System.out.print("Enter a wikipedia page topic: ");
    String word = scnr.nextLine();
    System.out.print("Enter the number of pages you'd like to step through: ");
    int page = scnr.nextInt();
    // prepend "/wiki/" to the user's input, and replace spaces with underscores
    word = word.trim().replace(" ", "_");
    String prependedWord = "/wiki/" + word;
    NextWikiLink wikiLink = new NextWikiLink();
    Generator<String> wikiGen = new Generator<>(prependedWord, wikiLink, page);
    // use a for-each loop to iterate through the number of links requested
    for (String string : wikiGen) {
      if (string.startsWith("FAILED to find ")) { // if error message was sent from apply() method
        System.out.println(string);
        break;
      } else {
        System.out.println(string);
      }
    }
  }
}
