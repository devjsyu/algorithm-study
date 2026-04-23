import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (N == 1) {
            return;
        }
        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            while (N % i == 0) {
                N /= i;
                sb.append(i).append('\n');
            }
        }
        if (N != 1) {
            sb.append(N).append('\n');
        }
        System.out.println(sb);
    }
}