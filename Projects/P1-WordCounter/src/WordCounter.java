import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class WordCounter {

    public static Map<String, Integer> countWords(String path) {
        File InputFile = new File(path);
        Scanner scanText = null;
        try {
            scanText = new Scanner(InputFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String[] words;
        Map<String, Integer> wordCount = new HashMap<>();

        while (scanText.hasNextLine()) {
            String current = scanText.nextLine();
            current = current.replaceAll("[^a-zA-Z0-9]", " ");
            words = current.split(" ", 0);
            for (String i : words) {
                if (!i.equals("")) {
                    if (wordCount.containsKey(i)) {
                        wordCount.put(i, wordCount.get(i) + 1);
                    } else {
                        wordCount.put(i, 1);
                    }
                }
            }
        }

        System.out.println(wordCount);
        scanText.close();
        return wordCount;
    }

    public static void outputFile(String path, String inputName,
            Map<String, Integer> wordCount) {
        File file = new File("output.txt");
        String block = "";
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        block = block + "<html>" + "\n";
        block = block + "<head>" + "\n";
        block = block + "<title>" + "Words Counted in " + inputName + "</title>"
                + "\n";
        block = block + "<body>" + "\n";
        block = block + "<h2>" + "Words Counted in " + inputName + "</h2>"
                + "\n";
        block = block + "<hr />" + "\n";
        //block = block + "table border=\"1\"" + "\n";
        block = block + "<table border='1'>" + "\n";
        block = block + "<tr>" + "\n";
        block = block + "<th>" + "Words" + "</th>" + "\n";
        block = block + "<th>" + "Counts" + "</th>" + "\n";
        block = block + "</tr>" + "\n";

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            block = block + "<tr>" + "\n";
            block = block + "<td>" + entry.getKey() + "</td>" + "\n";
            block = block + "<td>" + entry.getValue() + "</td>" + "\n";
            block = block + "</tr>" + "\n";
        }
        block = block + "</table>" + "\n";
        block = block + "</body>" + "\n";
        block = block + "</html>";

        System.out.println(block);
        out.write(block);
        out.close();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Name of Input?");
        String inName = in.nextLine();
        System.out.println("Name of Output?");
        String outName = in.nextLine();

        System.out.println(inName);
        Map<String, Integer> wordCount = countWords(inName);
        outputFile(outName, inName, wordCount);
        /*
         * Close input and output streams
         */
        in.close();
        //out.close();
    }

}
