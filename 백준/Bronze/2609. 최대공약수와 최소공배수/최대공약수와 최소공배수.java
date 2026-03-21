import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int multiplied = num1 * num2;

        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        while (num2 != 0) {
            int remainder = num1 - num2 * (num1 / num2);
            num1 = num2;
            num2 = remainder;
        }
        int gcd = num1;
        int lcm = multiplied / gcd;

        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append('\n').append(lcm);

        System.out.println(sb);
    }
}