import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().trim();
        if (sentence.isBlank()) {
            System.out.println(0);
            return;
        }
        String[] words = sentence.split("\\s");
        System.out.println(words.length);
    }
}