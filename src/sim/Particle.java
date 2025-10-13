package sim;
import java.awt.Graphics;

class Particle {
    Vec2 pos;
    Vec2 vel;
    Vec2 acc;
    Vec2 prevPos;
    float maxSpeed;

    // Constructor
    public Particle(float x, float y){
        pos = new Vec2(x, y);
        vel = new Vec2(0,0);
        acc = new Vec2(0,0);
        prevPos = pos.copy();
        maxSpeed = 4f;
    } 

    // Add external force 
    public void applyForce(Vec2 force){
        acc = acc.add(force);
    }

    // Update velocity and position each frame
    public void update(){
        vel = vel.add(acc);
        if (vel.mag() > maxSpeed) {
            vel = vel.normalize().mult(maxSpeed);   // clamp speed 
        }

        pos = pos.add(vel);
        acc = new Vec2(0, 0);   // reset acceleration
    }

    // Wrap particle around screen edges
    public void edges(int width, int height) {
        boolean wrapped = false;

        // Handle X edges
        if (pos.x >= width) {
            pos.x = 0;
            wrapped = true;
        } else if (pos.x < 0) {
            pos.x = width;
            wrapped = true;
        }

        // Handle Y edges
        if (pos.y >= height) {
            pos.y = 0;
            wrapped = true;
        } else if (pos.y < 0) {
            pos.y = height;
            wrapped = true;
        }

        if (wrapped) {
            prevPos = pos.copy(); // reset trail continuity
        }
    }

    // Draw a motion trail between old and new positions
    public void draw(Graphics g) {
        g.drawLine((int) prevPos.x, (int) prevPos.y,
                   (int) pos.x, (int) pos.y);
        prevPos = pos.copy(); // store current as new previous
    }


    

}