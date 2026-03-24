import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String N = input[0];
        int exp = Integer.parseInt(input[1]);

        int length = N.length();
        int answer = 0;
        for (int i = 0; i < length; i++) {
            answer += (int) (Math.pow(exp, i) * Character.getNumericValue(N.charAt(length - 1 - i)));
        }

        System.out.println(answer);
    }
}