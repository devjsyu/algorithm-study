import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char color = row.charAt(j);
                board[i][j] = color == 'B' ? true : false;
            }
        }

        int min = 64;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int temp = getMinCount(board, i, j);
                if (min > temp) {
                    min = temp;
                }
            }
        }
        System.out.println(min);
    }

    private static int getMinCount(boolean[][] board, int i, int j) {
        int count = 0;
        boolean isBlack = board[i][j];
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if (isBlack != board[k][l]) {
                    count++;
                }
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }
        return Math.min(count, 64 - count);
    }
}