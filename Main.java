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

    public static void main(String[] args) {

    }
}
