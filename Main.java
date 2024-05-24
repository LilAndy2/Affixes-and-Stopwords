import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Affix> importAffixes() throws IOException {
        ArrayList<Affix> affixes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("utils/affixes.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.split(" # ");
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
            StopWord current = new StopWord(info[0], info[1], info[2], info[3]);
            stopWords.add(current);
        }
        return stopWords;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Affix> affixes = Main.importAffixes();
        ArrayList<StopWord> stopWords = Main.importStopWords();

        MyPage page = new MyPage();

        page.getAffixButton().addActionListener(e -> {
            Main.hideIntroPage(page);
        });

        page.getStopWordButton().addActionListener(e -> {
            Main.hideIntroPage(page);
        });

        page.getInstructionsButton().addActionListener(e -> {
            Main.hideIntroPage(page);
        });
    }

    private static void hideIntroPage(MyPage page) {
        page.getLogoPanel().setVisible(false);
        page.getInstructionsButton().setVisible(false);
        page.getStopWordButton().setVisible(false);
        page.getAffixButton().setVisible(false);
        page.getTitlePanel().setVisible(false);
    }
}
