import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 크기가 작기 때문에 StringTokenizer 대신 간단한 split 사용
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        int[] baskets = new int[n];

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int ball = Integer.parseInt(input[2]);

            // 입력 범위가 1-based 이므로 배열 인덱스에 맞게 -1 보정
            for (int j = start - 1; j <= end - 1; j++) {
                baskets[j] = ball;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(baskets[i]);
            if (i < n - 1) {
                sb.append(' ');
            }
        }

        System.out.println(sb);
    }
}