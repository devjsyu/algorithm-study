import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int N = reader.nextInt();
        int M = reader.nextInt();

        int[] baskets = new int[N];
        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        int[] temp = new int[N];

        for (int k = 0; k < M; k++) {
            int i = reader.nextInt() - 1;
            int j = reader.nextInt() - 1;

            for (int l = i; l <= j; l++) {
                temp[l] = baskets[l];
            }

            for (int l = j; l >= i; l--) {
                baskets[i + j - l] = temp[l];
            }

            for (int l = i; l <= j; l++) {
                temp[l] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(baskets[i]);
            if (i < N - 1) {
                sb.append(' ');
            }
        }
        System.out.println(sb);
    }

    static class FastReader {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        public FastReader() {
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}