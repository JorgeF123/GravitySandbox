package app;

import javax.swing.*;
import java.awt.*;
import sim.SimulationPanel;

// Sets up the fullscreen window and starts the main simulation panel.
public class App {
    public static void main(String[] args) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int W = (int) screen.getWidth();
        int H = (int) screen.getHeight();

        JFrame frame = new JFrame("FlowField Particle Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // fullscreen window
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setContentPane(new SimulationPanel(W, H));
        frame.setSize(W, H);
        frame.setLocation(0, 0);
        frame.setAlwaysOnTop(false);

        // ESC to quit
        frame.getRootPane().registerKeyboardAction(
            e -> System.exit(0),
            KeyStroke.getKeyStroke("ESCAPE"),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        frame.setVisible(true);
    }
}
