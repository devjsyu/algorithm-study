import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer parameters = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(parameters.nextToken());
        int M = Integer.parseInt(parameters.nextToken());
        StringTokenizer sequence = new StringTokenizer(br.readLine());
        int[][] arr = new int[N + 1][2];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(sequence.nextToken());
            sum += num;
            arr[i][0] = sum;
            arr[i][1] = num;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            StringTokenizer indexes = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(indexes.nextToken());
            int j = Integer.parseInt(indexes.nextToken());
            int deducted = 0;
            if (i == j) {
                deducted = arr[i][1];
            }
            deducted = arr[j][0] - arr[i - 1][0];

            sb.append(deducted).append('\n');
        }
        System.out.println(sb);
    }
}