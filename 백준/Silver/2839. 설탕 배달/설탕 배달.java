import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getMin(N));
    }

    private static int getMin(int N) {
        int modByFive = N % 5;
        if (modByFive == 0) {
            return N / 5;
        } else if (modByFive % 3 == 0) {
            return N / 5 + modByFive / 3;
        } else {
            for (int i = N / 5 - 1; i >= 0; i--) {
                if ((N - 5 * i) % 3 == 0) {
                    return i + (N - 5 * i) / 3;
                }
            }
        }
        return -1;
    }
}