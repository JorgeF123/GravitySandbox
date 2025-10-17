package sim;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Handles particle updates and drawing inside a window
public class SimulationPanel extends JPanel {
    private final List<Particle> particles = new ArrayList<>();  // list of all particles
    private final FlowField field;                               // flow field for forces
    private final Timer timer;                                   // game loop timer

    public SimulationPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));  // window size
        setBackground(Color.BLACK);                      // background color
        field = new FlowField(width, height, 20);        // 20px grid cell size

        // create a bunch of random particles
        int count = 400;
        for (int i = 0; i < count; i++) {
            float x = (float) (Math.random() * width);
            float y = (float) (Math.random() * height);
            particles.add(new Particle(x, y));
        }

        // ~60 FPS timer → calls tick() repeatedly
        timer = new Timer(16, e -> tick());
        timer.start();
    
    }
    // Updates simulation each frame
    private void tick() {
        int w = getWidth();
        int h = getHeight();

        for (Particle p : particles) {
            Vec2 force = field.getForceAt(p.pos.x, p.pos.y);  // get flow vector
            p.applyForce(force.mult(0.2f));                   // scale force to keep motion smooth
            p.update();
            p.edges(w, h);
        }

        repaint(); // ask Swing to redraw the panel
    }

    // Draw all particles
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // keeps background clear each frame

        for (Particle p : particles) {
            
            float hue = 0.3f + 0.3f * (float)Math.sin(System.nanoTime() * 0.000000003);
            g.setColor(Color.getHSBColor(hue, 0.4f, 1f));
            p.draw(g);
        }
    }

}
