import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Affix> importAffixes() throws IOException {
        ArrayList<Affix> affixes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("utils/affixes.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.split("#");

        }
        return affixes;
    }

    private static ArrayList<StopWord> importStopWords() throws IOException {
        ArrayList<StopWord> stopWords = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("utils/stopwords.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.split("#");

        }
        return stopWords;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Affix> affixes = Main.importAffixes();
        ArrayList<StopWord> stopWords = Main.importStopWords();

        MyPage frame = new MyPage();

        frame.getAffixButton().addActionListener(e -> {
        });

        frame.getStopWordButton().addActionListener(e -> {
        });

        frame.getInstructionsButton().addActionListener(e -> {
            
        });
    }
}
