import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();

        int[] baskets = new int[n];

        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1; // 바구니 번호는 1번부터 시작하므로 초기값을 i+1로 설정
        }

        for (int k = 0; k < m; k++) {
            int i = nextInt() - 1;
            int j = nextInt() - 1;

            int temp = baskets[i];
            baskets[i] = baskets[j];
            baskets[j] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append(baskets[k]);
            if (k < n - 1) {
                sb.append(' ');
            }
        }
        System.out.println(sb);
    }
}