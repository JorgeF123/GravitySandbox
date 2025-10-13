package sim;

/**
 * Vec2 represents a 2D vector with basic math operations.
 * Used for position, velocity, acceleration, and forces
 * in the Gravity / Particle Sandbox simulation.
 */
public class Vec2 {
    public float x;
    public float y;

    public Vec2(float x, float y) {
        this.x = x;     // x-coordinate
        this.y = y;     // y-coordinate
    }

    // Add another vector > new Vec2
    public Vec2 add(Vec2 v) {
        return new Vec2(this.x + v.x, this.y + v.y);
    }

    // Subtract another vector > new Vec2
    public Vec2 sub(Vec2 v) {
        return new Vec2(this.x - v.x, this.y - v.y);
    }

    // Multiply by scalar > new Vec2
    public Vec2 mult(float s) {
        return new Vec2(this.x * s, this.y * s);
    }

    // Vector length
    public float mag() {
        return (float) Math.sqrt(x * x + y * y);
    }
    
    // Normalize > direction only
    public Vec2 normalize() {
        float m = mag();
        return (m != 0) ? new Vec2(x / m, y / m) : new Vec2(0, 0);
    }

    // Limit length to max
    public Vec2 limit(float max) {
        if (mag() > max) {
            return normalize().mult(max);
        }
        return this.copy();
    }

    // Copy this vector
    public Vec2 copy() {
        return new Vec2(x, y);
    }
}
