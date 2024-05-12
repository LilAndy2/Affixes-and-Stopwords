import javax.swing.*;
import java.awt.*;

public class MyPage {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    private MyFrame frame;
    private JPanel titlePanel;
    private JPanel logoPanel;
    private JButton affixButton;
    private JButton stopWordButton;
    private JButton instructionsButton;
    ////////////////////////////// ATTRIBUTES //////////////////////////////

    ////////////////////////////// CONSTRUCTOR //////////////////////////////
    public MyPage() {
        this.initTitlePanel();
        this.initLogoPanel();
        this.initFrame();

        this.frame.add(this.logoPanel, BorderLayout.NORTH);
        this.frame.add(this.titlePanel, BorderLayout.CENTER);

        this.frame.setVisible(true);
    }
    ////////////////////////////// CONSTRUCTOR //////////////////////////////

    ////////////////////////////// GETTERS //////////////////////////////
    public JFrame getFrame() {
        return frame;
    }
    public JPanel getLogoPanel() {
        return logoPanel;
    }
    public JPanel getTitlePanel() {
        return titlePanel;
    }
    ////////////////////////////// GETTERS //////////////////////////////

    ////////////////////////////// ADDITIONAL METHODS //////////////////////////////
    private void initFrame() {
        this.frame = new MyFrame();
    }

    private void initTitlePanel() {
        JLabel titleLabel = new JLabel("<html><div style='font-size: 100pt; text-align: center; margin-bottom: -20px;'>" +
                "Affixes and Stopwords</div><br><div style='font-size: 30pt; text-align: center;'>Get your grammar knowledge together!" +
                "</div></html>");
        titleLabel.setVisible(true);
        titleLabel.setForeground(Color.BLACK);

        this.titlePanel = new JPanel();
        this.titlePanel.setOpaque(false);
        this.titlePanel.setVisible(true);
        this.titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

        this.titlePanel.add(titleLabel);
    }

    private void initLogoPanel() {
        JLabel logoLabel = new JLabel("<html>University of West Attica <br> Methodologies of Applications Development</html>");
        logoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        logoLabel.setVisible(true);
        logoLabel.setForeground(Color.BLACK);

        ImageIcon logo = new ImageIcon("utils/images/west attica.png");
        logoLabel.setIcon(logo);

        this.logoPanel = new JPanel();
        this.logoPanel.setOpaque(false);
        this.logoPanel.setVisible(true);
        this.logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

        this.logoPanel.add(logoLabel);
    }
    ////////////////////////////// ADDITIONAL METHODS //////////////////////////////
}