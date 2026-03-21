import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sqrt = (int) Math.sqrt(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <=sqrt ; i++) {
            while (N % i == 0) {
                N = N / i;
                sb.append(i).append('\n');
            }
            if (N == 1) {
                break;
            }
        }
        if (N != 1) {
            sb.append(N).append('\n');
        }
        System.out.print(sb);
    }
}