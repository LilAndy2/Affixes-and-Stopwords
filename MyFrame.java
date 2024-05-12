import javax.swing.*;
import java.awt.*;
import static helpers.Constants.Colors.BACKGROUND_COLOR;
import static helpers.Constants.Colors.BACKGROUND_COLOR_2;

public class MyFrame extends JFrame {
    private final JPanel animatedPanel;
    private Color startColor;
    private Color endColor;
    private float colorPosition;

    public MyFrame() {
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

        startColor = BACKGROUND_COLOR;
        endColor = BACKGROUND_COLOR_2;

        animatedPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color currentColor = new Color(
                        (int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * colorPosition),
                        (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * colorPosition),
                        (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * colorPosition)
                );
                g.setColor(currentColor);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(animatedPanel);

        Timer timer = new Timer(50, e -> {
            colorPosition += 0.01f;
            if (colorPosition >= 1.0f) {
                Color tempColor = startColor;
                startColor = endColor;
                endColor = tempColor;
                colorPosition = 0.0f;
            }
            animatedPanel.repaint();
        });

        timer.start();
    }
}