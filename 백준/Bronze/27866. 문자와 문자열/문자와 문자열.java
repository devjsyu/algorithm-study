import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // try-with-resources for auto close
        try (
            // Create a BufferedReader class for faster input
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in))
        ) {
            // Assign variables
            String string = br.readLine();
            int index = Integer.parseInt(br.readLine()) - 1;

            // Prints charAt
            System.out.println(string.charAt(index));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
