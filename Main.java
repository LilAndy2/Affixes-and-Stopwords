import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Affix> importAffixes() throws IOException {
        ArrayList<Affix> affixes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("utils/affixes.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.split(" # ");
            if (info[1].equals("suffix")) {
                info[0] = "-" + info[0];
            } else if (info[1].equals("prefix")) {
                info[0] = info[0] + "-";
            }
            Affix current = new Affix(info[0], info[1], info[3], info[2], info[5], info[4], info[6], info[7]);
            affixes.add(current);
        }
        return affixes;
    }

    private static ArrayList<StopWord> importStopWords() throws IOException {
        ArrayList<StopWord> stopWords = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("utils/stopwords.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.split(" # ");
            StopWord current = new StopWord(info[1], info[0], info[3], info[2]);
            stopWords.add(current);
        }
        return stopWords;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Affix> affixes = Main.importAffixes();
        ArrayList<StopWord> stopWords = Main.importStopWords();

        MyPage page = new MyPage();
        page.setAffixes(affixes);
        page.setStopWords(stopWords);

        page.getAffixButton().addActionListener(e -> {
            Main.hideIntroPage(page);
            page.initAffixesPage();
            page.getBackButton().addActionListener(e1 -> {
                Main.hideAffixesPage(page);
            });
        });

        page.getStopWordButton().addActionListener(e -> {
            Main.hideIntroPage(page);
            page.initStopWordsPage();
            page.getBackButton().addActionListener(e1 -> {
                Main.hideStopWordsPage(page);
            });
        });

        page.getInstructionsButton().addActionListener(e -> {
            Main.hideIntroPage(page);
            page.initInstructionsPage();
            page.getBackButton().addActionListener(e1 -> {
                Main.hideInstructionsPage(page);
            });
        });
    }

    private static void hideIntroPage(MyPage page) {
        page.getLogoPanel().setVisible(false);
        page.getInstructionsButton().setVisible(false);
        page.getStopWordButton().setVisible(false);
        page.getAffixButton().setVisible(false);
        page.getTitlePanel().setVisible(false);
    }

    private static void showIntroPage(MyPage page) {
        page.getLogoPanel().setVisible(true);
        page.getInstructionsButton().setVisible(true);
        page.getStopWordButton().setVisible(true);
        page.getAffixButton().setVisible(true);
        page.getTitlePanel().setVisible(true);
    }

    private static void hideAffixesPage(MyPage page) {
        Main.showIntroPage(page);
        page.getBackButton().setVisible(false);
        page.getAffixTitle().setVisible(false);
        page.getAffixInfo().setVisible(false);
        page.getNextButton().setVisible(false);
        page.getPreviousButton().setVisible(false);
    }

    private static void hideStopWordsPage(MyPage page) {
        Main.showIntroPage(page);
        page.getBackButton().setVisible(false);
        page.getStopWordsTitle().setVisible(false);
        page.getNextButton2().setVisible(false);
        page.getPreviousButton2().setVisible(false);
        page.getStopWordsInfo().setVisible(false);
    }

    private static void hideInstructionsPage(MyPage page) {
        Main.showIntroPage(page);
        page.getBackButton().setVisible(false);
        page.getInstructionsTitle().setVisible(false);
        page.getInstructionsText().setVisible(false);
    }
}
