//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P02 Particle Fountain
// Files: Fountain.java
// Course: cs300 Spring 2019
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
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////
import java.util.Random;

/**
 * This file contains the methods for good functioning of the fountain and also the graphical
 * implementation of a particle system using P2ParticleFountain.jar methods.
 * <p>
 * The program will allow the user to move the fountain around by pressing the mouse and to take
 * screenshot pressing 'p' on the keyboard.
 */
public class Fountain {
  private static Random randGen = new Random();
  private static Particle[] particles;
  private static int positionX; // middle of the screen (left to right): 400
  private static int positionY; // middle of the screen (top to bottom): 300
  private static int startColor; // blue: Utility.color(23,141,235)
  private static int endColor; // lighter blue: Utility.color(23,200,255)

  /**
   * Calls Utility class method runApplication() to create new graphical window for this program.
   * 
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Utility.runApplication();
  }

  /**
   * Creates a new particle array with size 800 and initialize the fields for this program.
   */
  public static void setup() {
    particles = new Particle[800];
    // we test to see if the updateParticle(0 and removeOldParticles() methods work correctly before
    // the program runs
    if (testUpdateParticle() == false || testRemoveOldParticles() == false) {
      System.out.print("FAILED");
    }
    positionX = 400;
    positionY = 300;
    startColor = Utility.color(23, 141, 235);
    endColor = Utility.color(23, 200, 255);
  }

  /**
   * Updates the background and creates new particles each time this method is called. It also
   * updates the position of the particles and remove old particles.
   */
  public static void update() {
    // We use the background method in update so that the moving particles would not create trails
    Utility.background(Utility.color(235, 213, 186));
    createNewParticles(10); // create 10 new particles each times update() method is called
    for (int i = 0; i < particles.length; i++) {
      if (particles[i] != null) {
        updateParticle(i);
      }
    }
    removeOldParticles(80);
  }

  /**
   * When this method is called, it updates the new position and increases the age of the particular
   * particle called.
   * 
   * @param index index of the particle in the array
   */
  private static void updateParticle(int index) {
    Utility.fill(particles[index].getColor(), particles[index].getTransparency());
    Utility.circle(particles[index].getPositionX(), particles[index].getPositionY(),
        particles[index].getSize());
    float x = particles[index].getPositionX();
    float y = particles[index].getPositionY();
    float veloX = particles[index].getVelocityX();
    float veloY = particles[index].getVelocityY();
    veloY = veloY + 0.3f; // 0.3 is added to the y velocity to create gravitational effect
    particles[index].setPositionX(x + veloX);
    particles[index].setPositionY(y + veloY);
    particles[index].setAge(1 + particles[index].getAge());
  }

  /**
   * Looks for null references in the particle array and create new particle with randomized initial
   * states to create a flurry of particles.
   * 
   * @param input the number of particles creating
   */
  private static void createNewParticles(int input) {
    int j = 0;
    for (int i = 0; i < particles.length; i++) {
      if (particles[i] == null) {
        particles[i] = new Particle();
        particles[i].setAge(randGen.nextInt(41 - 0) + 0);
        float y = randGen.nextFloat();
        particles[i].setPositionX(
            randGen.nextFloat() * ((positionX + 3) - (positionX - 3)) + (positionX - 3));
        particles[i].setPositionY(
            randGen.nextFloat() * ((positionY + 3) - (positionY - 3)) + (positionY - 3));
        particles[i].setSize(randGen.nextFloat() * (11 - 4) + 4);
        particles[i].setColor(Utility.lerpColor(startColor, endColor, y));
        particles[i].setVelocityX(randGen.nextFloat() * (1 + 1) - 1);
        particles[i].setVelocityY(randGen.nextFloat() * ((-5 + 10)) - 10);
        particles[i].setAge(randGen.nextInt(41));
        particles[i].setTransparency(randGen.nextInt(128 - 32) + 32);
        j++;
      }
      if (j >= input) { // this if statement is needed to control the number of particles created
        break;
      }
    }
  }

  /**
   * Removes particles that are old, exceeding maxAge from the particle array to allow the fountain
   * to run forever.
   * 
   * @param maxAge the maximum age of particles specified to have
   */
  private static void removeOldParticles(int maxAge) {
    for (int i = 0; i < particles.length; i++) {
      if (particles[i] != null) {
        if (particles[i].getAge() > maxAge) {
          particles[i] = null;
        }
      }
    }
  }

  /**
   * Allow the user to click on the mouse to move the fountain around.
   *
   * @param xPos x-position of the mouse pressed
   * @param yPos y-position of the mouse pressed
   */
  public static void mousePressed(int xPos, int yPos) {
    Fountain.positionX = xPos;
    Fountain.positionY = yPos;
  }

  /**
   * Takes a screenshot of the graphic when the keyboard key 'p' is pressed.
   * 
   * @param key keyboard key pressed
   */
  public static void keyPressed(char key) {
    if (key == 'p') {
      Utility.save("screenshot.png");
    }
  }

  /**
   * Creates a single particle at position (3,3) with velocity (-1,-2). Then checks whether calling
   * updateParticle() on this particle's index correctly results in changing its position to
   * (2,1.3).
   * 
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateParticle() {
    boolean testPassed = true;
    particles[0] = new Particle();
    particles[0].setPositionX(3);
    particles[0].setPositionY(3);
    particles[0].setVelocityX(-1);
    particles[0].setVelocityY(-2);
    updateParticle(0);
    if (particles[0].getPositionX() != 2f || particles[0].getPositionY() != 1.3f) {
      testPassed = false;
    }
    particles[0] = null;
    return testPassed;
  }

  /**
   * Calls removeOldParticles(6) on an array with three particles (two of which have ages over six
   * and another that does not). Then checks whether the old particles were removed and the young
   * particle was left alone.
   * 
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldParticles() {
    boolean testPassed = true; // boolean local variable evaluated to true
    particles[0] = new Particle();
    particles[1] = new Particle();
    particles[2] = new Particle();
    particles[0].setAge(8);
    particles[1].setAge(10);
    particles[2].setAge(4);
    removeOldParticles(6);
    if (particles[0] != null || particles[1] != null || particles[2] == null) {
      testPassed = false;
    }
    particles[2] = null;
    return testPassed;
  }
}
