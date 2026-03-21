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

        int[][] index = new int[M][2];
        int largest = 0;
        for (int k = 0; k < M; k++) {
            StringTokenizer indexes = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(indexes.nextToken());
            int j = Integer.parseInt(indexes.nextToken());
            if (j > largest) {
                largest = j;
            }
            index[k][0] = i;
            index[k][1] = j;
        }

        int sum = 0;
        for (int i = 1; i <= largest; i++) {
            int num = Integer.parseInt(sequence.nextToken());
            sum += num;
            arr[i][0] = sum;
            arr[i][1] = num;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            int i = index[k][0];
            int j = index[k][1];

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