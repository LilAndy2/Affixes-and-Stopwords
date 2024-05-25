import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static helpers.Constants.Colors.BUTTON_BACKGROUND;
import static helpers.Constants.Colors.BUTTON_BORDER;
import static helpers.Constants.Colors.ANSI_RED;
import static helpers.Constants.Colors.ANSI_RESET;

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
    private int currentIndexAffixes = 0;
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

        /* StopWords Page */
    private ArrayList<StopWord> stopWords;
    private JPanel stopWordsTitle;
    private JButton nextButton2;
    private JButton previousButton2;
    private int currentIndexStopWords = 0;
    private JPanel stopWordsInfo;
    private JLabel stopWordLabel;
    private JPanel stopWordPanel;
    private JLabel stopWordRomanianLabel;
    private JPanel stopWordRomanianPanel;
    private JLabel stopWordSentenceLabel;
    private JPanel stopWordSentencePanel;
    private JLabel stopWordSentenceRomanianLabel;
    private JPanel stopWordSentenceRomanianPanel;
        /* StopWords Page */
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
    public JPanel getStopWordsTitle() {
        return stopWordsTitle;
    }
    public JButton getNextButton2() {
        return nextButton2;
    }
    public JButton getPreviousButton2() {
        return previousButton2;
    }
    public JPanel getStopWordsInfo() {
        return stopWordsInfo;
    }

    public void setAffixes(ArrayList<Affix> affixes) {
        this.affixes = affixes;
    }
    public void setStopWords(ArrayList<StopWord> stopWords) {
        this.stopWords = stopWords;
    }
    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////

    ////////////////////////////// ADDITIONAL METHODS //////////////////////////////
        /* Intro Page */
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
        /* Intro Page */

        /* Affixes Page */
    public void initAffixesPage() {
        this.initBackButton();
        this.initAffixesTitle();
        this.initAffixesInfo();
        this.initNavigationButtonsAffixes();
        this.currentIndexAffixes = 0;

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
        this.affixInfo.add(Box.createVerticalGlue());
        this.affixInfo.add(this.affixPanel);
        this.affixInfo.add(this.typePanel);
        this.affixInfo.add(this.exampleLemmaPanel);
        this.affixInfo.add(this.exampleLemmaRomanianPanel);
        this.affixInfo.add(this.exampleWithAffixPanel);
        this.affixInfo.add(this.exampleWithAffixRomanianPanel);
        this.affixInfo.add(this.morphologicalProcessPanel);
        this.affixInfo.add(this.exampleExplanationPanel);
        this.affixInfo.add(Box.createVerticalGlue());
    }

    private void initNavigationButtonsAffixes() {
        ImageIcon nextIcon = new ImageIcon("utils/images/next.png");
        this.nextButton = new JButton(nextIcon);
        this.nextButton.setBorder(BorderFactory.createEmptyBorder());
        this.nextButton.setContentAreaFilled(false);
        this.nextButton.addActionListener(e -> {
            if (currentIndexAffixes == this.affixes.size() - 1) {
                currentIndexAffixes = 0;
            } else {
                currentIndexAffixes++;
            }

            setNewTextAffixes(currentIndexAffixes);
        });

        ImageIcon previousIcon = new ImageIcon("utils/images/previous.png");
        this.previousButton = new JButton(previousIcon);
        this.previousButton.setBorder(BorderFactory.createEmptyBorder());
        this.previousButton.setContentAreaFilled(false);
        this.previousButton.addActionListener(e -> {
            if (currentIndexAffixes == 0) {
                currentIndexAffixes = this.affixes.size() - 1;
            } else {
                currentIndexAffixes--;
            }

            setNewTextAffixes(currentIndexAffixes);
        });

        this.nextButton.setPreferredSize(new Dimension(80,80));
        this.previousButton.setPreferredSize(new Dimension(80,80));
    }

    private void setNewTextAffixes(int currentIndexAffixes) {
        this.affixLabel.setText("Affix: " + affixes.get(currentIndexAffixes).getAffix());
        this.typeLabel.setText("Type: " + affixes.get(currentIndexAffixes).getType());
        this.exampleLemmaLabel.setText("Example Lemma: " + affixes.get(currentIndexAffixes).getExampleLemma());
        this.exampleLemmaRomanianLabel.setText("Example Lemma in Romanian: " + affixes.get(currentIndexAffixes).getExampleLemmaRomanian());
        this.exampleWithAffixLabel.setText("Example with affix: " + affixes.get(currentIndexAffixes).getExampleWithAffix());

        int wordLength = affixes.get(currentIndexAffixes).getAffix().length() - 1;
        String myWord = affixes.get(currentIndexAffixes).getExampleWithAffixRomanian();
        String firstPart = myWord.substring(0, myWord.length() - wordLength);
        String secondPart = myWord.substring(myWord.length() - wordLength);

        String htmlText = String.format("<html>Example with affix in Romanian: %s<font color='red'>%s</font></html>", firstPart, secondPart);
        this.exampleWithAffixRomanianLabel.setText(htmlText);

        this.morphologicalProcessLabel.setText("Morphological Process: " + affixes.get(currentIndexAffixes).getMorphologicalProcess());
        this.exampleExplanationLabel.setText("<html><body style='width: 550px'>Example Explanation:<br>" + affixes.get(currentIndexAffixes).getExampleExplanation()
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
        int wordLength = affixes.getFirst().getAffix().length() - 1;
        String myWord = affixes.getFirst().getExampleWithAffixRomanian();
        String firstPart = myWord.substring(0, myWord.length() - wordLength);
        String secondPart = myWord.substring(myWord.length() - wordLength);

        String htmlText = String.format("<html>Example with affix in Romanian: %s<font color='red'>%s</font></html>", firstPart, secondPart);
        this.exampleWithAffixRomanianLabel = new JLabel(htmlText);
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
        /* Affixes Page */

        /* StopWords Page */
    public void initStopWordsPage() {
        this.initBackButton();
        this.initStopWordsTitle();
        this.initNavigationButtonsStopWords();
        this.initStopWordsInfo();
        this.currentIndexStopWords = 0;

        this.frame.add(this.backButton);
        this.frame.add(this.stopWordsTitle);
        this.frame.add(this.nextButton2);
        this.frame.add(this.previousButton2);
        this.frame.add(this.stopWordsInfo);

        this.frame.setLayout(null);
        this.backButton.setBounds(10, 10, 100, 50);
        this.stopWordsTitle.setBounds(550, 80, 600, 150);
        this.previousButton2.setBounds(470,475,50,50);
        this.nextButton2.setBounds(1220,475,50,50);
        this.stopWordsInfo.setBounds(520, 250, 900, 500);
    }

    private void initStopWordsTitle() {
        JLabel titleLabel = new JLabel("<html><div style='font-size: 100pt; border-bottom: solid black;'>Stop Words</div></html>");
        titleLabel.setVisible(true);
        titleLabel.setForeground(Color.BLACK);

        this.stopWordsTitle = new JPanel();
        this.stopWordsTitle.setOpaque(false);
        this.stopWordsTitle.setVisible(true);

        this.stopWordsTitle.add(titleLabel);
    }

    private void initNavigationButtonsStopWords() {
        ImageIcon nextIcon = new ImageIcon("utils/images/next.png");
        this.nextButton2 = new JButton(nextIcon);
        this.nextButton2.setBorder(BorderFactory.createEmptyBorder());
        this.nextButton2.setContentAreaFilled(false);
        this.nextButton2.addActionListener(e -> {
            if (currentIndexStopWords == this.stopWords.size() - 1) {
                currentIndexStopWords = 0;
            } else {
                currentIndexStopWords++;
            }

            setNewTextStopWords(currentIndexStopWords);
        });

        ImageIcon previousIcon = new ImageIcon("utils/images/previous.png");
        this.previousButton2 = new JButton(previousIcon);
        this.previousButton2.setBorder(BorderFactory.createEmptyBorder());
        this.previousButton2.setContentAreaFilled(false);
        this.previousButton2.addActionListener(e -> {
            if (currentIndexStopWords == 0) {
                currentIndexStopWords = this.stopWords.size() - 1;
            } else {
                currentIndexStopWords--;
            }

            setNewTextStopWords(currentIndexStopWords);
        });

        this.nextButton2.setPreferredSize(new Dimension(80,80));
        this.previousButton2.setPreferredSize(new Dimension(80,80));
    }

    private void setNewTextStopWords(int currentIndexStopWords) {
        this.stopWordLabel.setText("Stop Word: " + stopWords.get(currentIndexStopWords).getStopWord());
        this.stopWordRomanianLabel.setText("Stop Word in Romanian: " + stopWords.get(currentIndexStopWords).getStopWordRomanian());
        this.stopWordSentenceLabel.setText("<html><body style='width: 550px'>Stop Word Sentence:<br>" +
                stopWords.get(currentIndexStopWords).getStopWordSentence() + "</body></html>");
        this.stopWordSentenceRomanianLabel.setText("<html><body style='width: 550px'>Stop Word Sentence in Romanian:<br>" +
                stopWords.get(currentIndexStopWords).getStopWordSentenceRomanian() + "</body></html>");
    }

    private void initStopWordsInfo() {
        this.initStopWordsExample();

        this.stopWordsInfo = new JPanel();
        this.stopWordsInfo.setOpaque(false);
        this.stopWordsInfo.setVisible(true);

        this.stopWordPanel.setPreferredSize(new Dimension(900, 40));
        this.stopWordRomanianPanel.setPreferredSize(new Dimension(900, 40));
        this.stopWordSentencePanel.setPreferredSize(new Dimension(900, 40));
        this.stopWordSentenceRomanianPanel.setPreferredSize(new Dimension(900, 40));

        this.stopWordsInfo.setLayout(new BoxLayout(this.stopWordsInfo, BoxLayout.Y_AXIS));

        this.stopWordsInfo.add(Box.createVerticalGlue());
        this.stopWordsInfo.add(this.stopWordPanel);
        this.stopWordsInfo.add(this.stopWordRomanianPanel);
        this.stopWordsInfo.add(this.stopWordSentencePanel);
        this.stopWordsInfo.add(this.stopWordSentenceRomanianPanel);
        this.stopWordsInfo.add(Box.createVerticalGlue());
    }

    private void initStopWordsExample() {
        /* Stop Word */
        this.stopWordLabel = new JLabel("Stop Word: " + stopWords.getFirst().getStopWord());
        this.stopWordLabel.setForeground(Color.BLACK);
        this.stopWordLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.stopWordPanel = new JPanel(new BorderLayout());
        this.stopWordPanel.setOpaque(false);
        this.stopWordPanel.add(this.stopWordLabel, BorderLayout.WEST);
        /* Stop Word */

        /* Stop Word Romanian */
        this.stopWordRomanianLabel = new JLabel("Stop Word in Romanian: " + stopWords.getFirst().getStopWordRomanian());
        this.stopWordRomanianLabel.setForeground(Color.BLACK);
        this.stopWordRomanianLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.stopWordRomanianPanel = new JPanel(new BorderLayout());
        this.stopWordRomanianPanel.setOpaque(false);
        this.stopWordRomanianPanel.add(this.stopWordRomanianLabel, BorderLayout.WEST);
        /* Stop Word Romanian */

        /* Stop Word Sentence */
        this.stopWordSentenceLabel = new JLabel("<html><body style='width: 550px'>Stop Word Sentence:<br>" +
                stopWords.getFirst().getStopWordSentence() + "</body></html>");
        this.stopWordSentenceLabel.setForeground(Color.BLACK);
        this.stopWordSentenceLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.stopWordSentencePanel = new JPanel(new BorderLayout());
        this.stopWordSentencePanel.setOpaque(false);
        this.stopWordSentencePanel.add(this.stopWordSentenceLabel, BorderLayout.WEST);
        /* Stop Word Sentence */

        /* Stop Word Sentence Romanian */
        this.stopWordSentenceRomanianLabel = new JLabel("<html><body style='width: 550px'>Stop Word Sentence in Romanian:<br>" +
                stopWords.getFirst().getStopWordSentenceRomanian() + "</body></html>");
        this.stopWordSentenceRomanianLabel.setForeground(Color.BLACK);
        this.stopWordSentenceRomanianLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        this.stopWordSentenceRomanianPanel = new JPanel(new BorderLayout());
        this.stopWordSentenceRomanianPanel.setOpaque(false);
        this.stopWordSentenceRomanianPanel.add(this.stopWordSentenceRomanianLabel, BorderLayout.WEST);
        /* Stop Word Sentence Romanian */
    }
        /* StopWords Page */
    ////////////////////////////// ADDITIONAL METHODS //////////////////////////////
}
