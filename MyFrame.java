import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static helpers.Constants.Colors.BACKGROUND_COLOR;
import static helpers.Constants.Colors.BACKGROUND_COLOR_2;

public class MyFrame extends JFrame {
    private final JPanel animatedPanel;
    private Color startColor;
    private Color endColor;
    private float colorPosition;

    public MyFrame() {
        //setTitle("Animated Gradient Background");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(1800, 960);
        this.setSize(1800, 960);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Affixes and Stopwords");

        ImageIcon image = new ImageIcon("utils/images/logo.jpg");
        this.setIconImage(image.getImage());
        setLocationRelativeTo(null);
        setResizable(false);

        // Initialize start and end colors
        startColor = BACKGROUND_COLOR;
        endColor = BACKGROUND_COLOR_2;

        // Initialize animated panel
        animatedPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Calculate the current color based on colorPosition
                Color currentColor = new Color(
                        (int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * colorPosition),
                        (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * colorPosition),
                        (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * colorPosition)
                );
                // Fill the background with the current color
                g.setColor(currentColor);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(animatedPanel);

        // Initialize timer to update colors
        // Update color position
        // Swap start and end colors
        // Reset color position
        // Repaint the panel
        Timer timer = new Timer(50, e -> {
            // Update color position
            colorPosition += 0.01f;
            if (colorPosition >= 1.0f) {
                // Swap start and end colors
                Color tempColor = startColor;
                startColor = endColor;
                endColor = tempColor;
                // Reset color position
                colorPosition = 0.0f;
            }
            // Repaint the panel
            animatedPanel.repaint();
        });
        // Start the timer
        timer.start();
    }
}