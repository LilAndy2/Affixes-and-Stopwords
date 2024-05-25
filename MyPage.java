import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static helpers.Constants.Colors.BUTTON_BACKGROUND;
import static helpers.Constants.Colors.BUTTON_BORDER;

public class MyPage {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    private MyFrame frame;

        /* Intro Page */
    private JPanel titlePanel;
    private JPanel logoPanel;
    private JPanel buttonPanel;
    private JButton affixButton;
    private JButton stopWordButton;
    private JButton instructionsButton;
        /* Intro Page */

        /* Affixes Page */
    private ArrayList<Affix> affixes;
    private int currentIndex = 0;
    private JButton backButton;
    private JPanel affixTitle;
    private JPanel affixInfo;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel affixLabel;
    private JPanel affixPanel;
    private JLabel typeLabel;
    private JPanel typePanel;
    private JLabel exampleLemmaLabel;
    private JPanel exampleLemmaPanel;
    private JLabel exampleLemmaRomanianLabel;
    private JPanel exampleLemmaRomanianPanel;
    private JLabel exampleWithAffixLabel;
    private JPanel exampleWithAffixPanel;
    private JLabel exampleWithAffixRomanianLabel;
    private JPanel exampleWithAffixRomanianPanel;
    private JLabel morphologicalProcessLabel;
    private JPanel morphologicalProcessPanel;
    private JLabel exampleExplanationLabel;
    private JPanel exampleExplanationPanel;
        /* Affixes Page */
    ////////////////////////////// ATTRIBUTES //////////////////////////////

    ////////////////////////////// CONSTRUCTOR //////////////////////////////
    public MyPage() {
        this.initTitlePanel();
        this.initLogoPanel();
        this.initButtonsPanel();
        this.initFrame();

        this.frame.add(this.logoPanel, BorderLayout.NORTH);
        this.frame.add(this.titlePanel, BorderLayout.CENTER);
        this.frame.add(this.buttonPanel, BorderLayout.SOUTH);

        this.frame.setVisible(true);
    }
    ////////////////////////////// CONSTRUCTOR //////////////////////////////

    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public JPanel getLogoPanel() {
        return logoPanel;
    }
    public JPanel getTitlePanel() {
        return titlePanel;
    }
    public JButton getAffixButton() {
        return affixButton;
    }
    public JButton getStopWordButton() {
        return stopWordButton;
    }
    public JButton getInstructionsButton() {
        return instructionsButton;
    }
    public JButton getBackButton() {
        return backButton;
    }
    public JPanel getAffixTitle() {
        return affixTitle;
    }
    public JPanel getAffixInfo() {
        return affixInfo;
    }
    public JButton getNextButton() {
        return nextButton;
    }
    public JButton getPreviousButton() {
        return previousButton;
    }

    public void setAffixes(ArrayList<Affix> affixes) {
        this.affixes = affixes;
    }
    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////

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
        this.logoPanel.setBounds(110,0,400,200);
        this.logoPanel.setBackground(Color.WHITE);

        this.logoPanel.add(logoLabel);
    }

    private void initButtonsPanel() {
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
        this.buttonPanel.setOpaque(false);
        this.buttonPanel.setVisible(true);

        this.affixButton = createCustomButton("<html><div style='font-size: 30pt;'>Affixes</div></html>");
        this.stopWordButton = createCustomButton("<html><div style='font-size: 30pt;'>Stopwords</div></html>");
        this.instructionsButton = createCustomButton("<html><div style='font-size: 30pt;'>Instructions</div></html>");

        this.buttonPanel.add(this.affixButton);
        this.buttonPanel.add(this.stopWordButton);
        this.buttonPanel.add(this.instructionsButton);
    }

    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(BUTTON_BACKGROUND);
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(BUTTON_BORDER, 5));
        button.setFocusPainted(false);

        return button;
    }

    public void initAffixesPage() {
        this.initBackButton();
        this.initAffixesTitle();
        this.initAffixesInfo();
        this.initNavigationButtons();
        this.currentIndex = 0;

        this.frame.add(this.backButton);
        this.frame.add(this.affixTitle);
        this.frame.add(this.affixInfo);
        this.frame.add(this.nextButton);
        this.frame.add(this.previousButton);

        this.frame.setLayout(null);
        this.backButton.setBounds(10, 10, 100, 50);
        this.affixTitle.setBounds(600, 80, 500, 150);
        this.affixInfo.setBounds(520, 250, 900, 500);
        this.previousButton.setBounds(470,475,50,50);
        this.nextButton.setBounds(1220,475,50,50);
    }

    private void initBackButton() {
        this.backButton = createCustomButton("<html><div style='font-size: 20pt;'>Go Back</div></html>");
    }

    private void initAffixesTitle() {
        JLabel titleLabel = new JLabel("<html><div style='font-size: 100pt; border-bottom: solid black;'>Affixes</div></html>");
        titleLabel.setVisible(true);
        titleLabel.setForeground(Color.BLACK);

        this.affixTitle = new JPanel();
        this.affixTitle.setOpaque(false);
        this.affixTitle.setVisible(true);

        this.affixTitle.add(titleLabel);
    }

    private void initAffixesInfo() {
        this.initAffixExample();

        this.affixInfo = new JPanel();
        this.affixInfo.setOpaque(false);
        this.affixInfo.setVisible(true);

        // Set the size of each JPanel to ensure consistent spacing
        this.affixPanel.setPreferredSize(new Dimension(900, 40));
        this.typePanel.setPreferredSize(new Dimension(900, 40));
        this.exampleLemmaPanel.setPreferredSize(new Dimension(900, 40));
        this.exampleLemmaRomanianPanel.setPreferredSize(new Dimension(900, 40));
        this.exampleWithAffixPanel.setPreferredSize(new Dimension(900, 40));
        this.exampleWithAffixRomanianPanel.setPreferredSize(new Dimension(900, 40));
        this.morphologicalProcessPanel.setPreferredSize(new Dimension(900, 40));
        this.exampleExplanationPanel.setPreferredSize(new Dimension(900, 150));

        // Set the layout of the affixInfo panel to BoxLayout
        this.affixInfo.setLayout(new BoxLayout(this.affixInfo, BoxLayout.Y_AXIS));

        // Add the panels to the affixInfo panel
        this.affixInfo.add(Box.createVerticalGlue()); // Add some spacing at the top
        this.affixInfo.add(this.affixPanel);
        this.affixInfo.add(this.typePanel);
        this.affixInfo.add(this.exampleLemmaPanel);
        this.affixInfo.add(this.exampleLemmaRomanianPanel);
        this.affixInfo.add(this.exampleWithAffixPanel);
        this.affixInfo.add(this.exampleWithAffixRomanianPanel);
        this.affixInfo.add(this.morphologicalProcessPanel);
        this.affixInfo.add(this.exampleExplanationPanel);

        // Add some spacing at the bottom
        this.affixInfo.add(Box.createVerticalGlue());
    }

    private void initNavigationButtons() {
        ImageIcon nextIcon = new ImageIcon("utils/images/next.png");
        this.nextButton = new JButton(nextIcon);
        this.nextButton.setBorder(BorderFactory.createEmptyBorder());
        this.nextButton.setContentAreaFilled(false);
        this.nextButton.addActionListener(e -> {
            if (currentIndex == this.affixes.size() - 1) {
                currentIndex = 0;
            } else {
                currentIndex++;
            }

            setNewText(currentIndex);
        });

        ImageIcon previousIcon = new ImageIcon("utils/images/previous.png");
        this.previousButton = new JButton(previousIcon);
        this.previousButton.setBorder(BorderFactory.createEmptyBorder());
        this.previousButton.setContentAreaFilled(false);
        this.previousButton.addActionListener(e -> {
            if (currentIndex == 0) {
                currentIndex = this.affixes.size() - 1;
            } else {
                currentIndex--;
            }

            setNewText(currentIndex);
        });

        this.nextButton.setPreferredSize(new Dimension(80,80));
        this.previousButton.setPreferredSize(new Dimension(80,80));
    }

    private void setNewText(int currentIndex) {
        this.affixLabel.setText("Affix: " + affixes.get(currentIndex).getAffix());
        this.typeLabel.setText("Type: " + affixes.get(currentIndex).getType());
        this.exampleLemmaLabel.setText("Example Lemma: " + affixes.get(currentIndex).getExampleLemma());
        this.exampleLemmaRomanianLabel.setText("Example Lemma in Romanian: " + affixes.get(currentIndex).getExampleLemmaRomanian());
        this.exampleWithAffixLabel.setText("Example with affix: " + affixes.get(currentIndex).getExampleWithAffix());
        this.exampleWithAffixRomanianLabel.setText("Example with affix in Romanian: " + affixes.get(currentIndex).getExampleWithAffixRomanian());
        this.morphologicalProcessLabel.setText("Morphological Process: " + affixes.get(currentIndex).getMorphologicalProcess());
        this.exampleExplanationLabel.setText("<html><body style='width: 550px'>Example Explanation:<br>" + affixes.get(currentIndex).getExampleExplanation()
                + "</body></html>");
    }

    private void initAffixExample() {
        /* Affix */
        this.affixLabel = new JLabel("Affix: " + affixes.getFirst().getAffix());
        this.affixLabel.setForeground(Color.BLACK);
        this.affixLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.affixPanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.affixPanel.setOpaque(false);
        this.affixPanel.add(this.affixLabel, BorderLayout.WEST); // Align the label to the left

        /* Type */
        this.typeLabel = new JLabel("Type: " + affixes.getFirst().getType());
        this.typeLabel.setForeground(Color.BLACK);
        this.typeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.typePanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.typePanel.setOpaque(false);
        this.typePanel.add(this.typeLabel, BorderLayout.WEST); // Align the label to the left

        /* Example Lemma */
        this.exampleLemmaLabel = new JLabel("Example Lemma: " + affixes.getFirst().getExampleLemma());
        this.exampleLemmaLabel.setForeground(Color.BLACK);
        this.exampleLemmaLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.exampleLemmaPanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.exampleLemmaPanel.setOpaque(false);
        this.exampleLemmaPanel.add(this.exampleLemmaLabel, BorderLayout.WEST); // Align the label to the left

        /* Example Lemma in Romanian */
        this.exampleLemmaRomanianLabel = new JLabel("Example Lemma in Romanian: " + affixes.getFirst().getExampleLemmaRomanian());
        this.exampleLemmaRomanianLabel.setForeground(Color.BLACK);
        this.exampleLemmaRomanianLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.exampleLemmaRomanianPanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.exampleLemmaRomanianPanel.setOpaque(false);
        this.exampleLemmaRomanianPanel.add(this.exampleLemmaRomanianLabel, BorderLayout.WEST); // Align the label to the left

        /* Example with affix */
        this.exampleWithAffixLabel = new JLabel("Example with affix: " + affixes.getFirst().getExampleWithAffix());
        this.exampleWithAffixLabel.setForeground(Color.BLACK);
        this.exampleWithAffixLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.exampleWithAffixPanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.exampleWithAffixPanel.setOpaque(false);
        this.exampleWithAffixPanel.add(this.exampleWithAffixLabel, BorderLayout.WEST); // Align the label to the left

        /* Example with affix in Romanian */
        this.exampleWithAffixRomanianLabel = new JLabel("Example with affix in Romanian: " + affixes.getFirst().getExampleWithAffixRomanian());
        this.exampleWithAffixRomanianLabel.setForeground(Color.BLACK);
        this.exampleWithAffixRomanianLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.exampleWithAffixRomanianPanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.exampleWithAffixRomanianPanel.setOpaque(false);
        this.exampleWithAffixRomanianPanel.add(this.exampleWithAffixRomanianLabel, BorderLayout.WEST); // Align the label to the left

        /* Morphological Process */
        this.morphologicalProcessLabel = new JLabel("Morphological Process: " + affixes.getFirst().getMorphologicalProcess());
        this.morphologicalProcessLabel.setForeground(Color.BLACK);
        this.morphologicalProcessLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.morphologicalProcessPanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.morphologicalProcessPanel.setOpaque(false);
        this.morphologicalProcessPanel.add(this.morphologicalProcessLabel, BorderLayout.WEST); // Align the label to the left

        /* Example explanation */
        this.exampleExplanationLabel = new JLabel("<html><body style='width: 550px'>Example Explanation:<br>" + affixes.getFirst().getExampleExplanation()
                + "</body></html>");
        this.exampleExplanationLabel.setForeground(Color.BLACK);
        this.exampleExplanationLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.exampleExplanationPanel = new JPanel(new BorderLayout()); // Use BorderLayout for consistent alignment
        this.exampleExplanationPanel.setOpaque(false);
        this.exampleExplanationPanel.add(this.exampleExplanationLabel, BorderLayout.WEST); // Align the label to the left
    }

    ////////////////////////////// ADDITIONAL METHODS //////////////////////////////
}
