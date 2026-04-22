import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> Dictionary = readFile("src/main/resources/diccionario.txt");
        BST<Association<String,String>> bst = new BST<>();

        for (String line : Dictionary){
            line = line.replace("(", "").replace(")", "");
            String[] word = line.split(", ");
            String key = word[0].toLowerCase();
            String value = word[1].toLowerCase();
            Association<String, String> add = new Association<>(key, value);
            bst.insert(add);
        }

        List<String> texto = readFile("src/main/resources/texto.txt");
        System.out.println(texto.toString());

        for (String line : texto) {
            String[] wordsInLine = line.split(" ");
            List<String> translatedLine = new ArrayList<>();

            for (String originalWord : wordsInLine) {
                String cleanWord = originalWord.replace(".", "").toLowerCase();
                cleanWord = cleanWord.replace(",","");

                Association<String, String> searchKey = new Association<>(cleanWord, null);
                Association<String, String> result = bst.contains(searchKey, bst.getRoot());

                if (result != null) {
                    translatedLine.add(result.value);
                    translatedLine.add(" ");
                } else {
                    translatedLine.add("*");
                    translatedLine.add(originalWord);
                    translatedLine.add("* ");
                }
            }
            String translatedText = String.join("", translatedLine).trim();
            System.out.println(translatedText);
        }
        System.out.println("\nBST inOrder: ");
        bst.inOrder();
    }

    public static List<String> readFile(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath));
    }
}
