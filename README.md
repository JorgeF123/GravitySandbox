# Particle Simulation (Java)

A Java-based particle simulation where hundreds of particles move according to a randomly generated vector flow field.  
Each frame, particles follow directional forces and wrap around screen edges creating smooth, flowing motion driven entirely by math.

---

## Features
- A **Flow Field** divides the screen into a grid of small cells.  
  Each cell has a random direction vector that points somewhere.  
- **Particles** look up which cell they’re in, grab that direction, and move that way.  
- **Velocity** and **acceleration** are handled by a simple `Vec2` class that I wrote.  
- The color changes smoothly over time using HSB values to give it motion and life.

---

## Project Structure

```bash
ParticleFlow/
 ├─ src/
 │   ├─ app/
 │   │   └─ App.java                → starts the program, sets up the window
 │   └─ sim/
 │       ├─ SimulationPanel.java    → main loop and rendering
 │       ├─ Particle.java           → handles movement and wrapping
 │       ├─ FlowField.java          → generates the directional grid
 │       └─ Vec2.java               → custom vector math class
 └─ README.md
```
---

## How to Run
```bash
javac -d bin src/app/*.java src/sim/*.java
java -cp bin app.App
```
---

## What You’ll See
You’ll see hundreds of particles moving smoothly around the screen, following the invisible forces of the flow field.
The colors shift slightly over time, giving it a soft, calming animation effect.

---

## Future Ideas 
- Add mouse gravity or repulsion
- Adjustable particle count and speed
- Add multiple color modes
- Click to spawn new particles
