# Specifications
## Objective
Develop a particle fountain simulation in Java to create and animate particles moving in a fountain-like pattern on the screen.

## Particle Class
Implement a `Particle` class to represent individual particles. Each particle should have attributes for position, velocity, and color.
```{java}
public class Particle {
    private float x;
    private float y;
    private float velocityX;
    private float velocityY;
    private Color color;

    // Constructor, getters, setters, and other methods
}
```

## Fountain Class
Implement a `Fountain` class to manage the collection of particles and handle their creation, movement, and rendering.
```{java}
public class Fountain {
    private List<Particle> particles;
    private Random rand;

    public Fountain() {
        particles = new ArrayList<>();
        rand = new Random();
    }

    public void createParticle() {
        // Implementation to create a new particle
    }

    public void updateParticles() {
        // Implementation to update particle positions
    }

    public void drawParticles(Graphics g) {
        // Implementation to draw particles on the screen
    }
}
```

## GUI Interaction
Develop a graphical user interface to allow user interaction with the simulation. The user should be able to start/stop the fountain and adjust settings like particle speed and fountain size.
```{java}
public class ParticleFountainApp extends JFrame {
    private Fountain fountain;
    private boolean running;

    public ParticleFountainApp() {
        fountain = new Fountain();
        running = false;
        // Set up GUI components
    }

    public void startFountain() {
        running = true;
        // Implementation to start the fountain
    }

    public void stopFountain() {
        running = false;
        // Implementation to stop the fountain
    }

    public void updateSettings() {
        // Implementation to update fountain settings
    }
}
```

## Testing and Validation
Implement test-driven development (TDD) to ensure code reliability and maintainability. Write unit tests for each method to verify its functionality and handle edge cases.

### Example Unit Test
```{java}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParticleTest {

    @Test
    public void testParticleMovement() {
        Particle particle = new Particle(0, 0, 1, 1, Color.RED);
        particle.updatePosition();
        assertEquals(1, particle.getX());
        assertEquals(1, particle.getY());
    }

    // Additional tests for other methods
}
```

### Example Unit Test for Fountain
```{java}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FountainTest {

    @Test
    public void testCreateParticle() {
        Fountain fountain = new Fountain();
        fountain.createParticle();
        assertEquals(1, fountain.getParticles().size());
    }

    // Additional tests for other methods
}
```

For more information, refer to the [original assignment page](https://web.archive.org/web/20190204205638/http://cs300-www.cs.wisc.edu/wp/2019/01/17/p02-particle-fountain/).