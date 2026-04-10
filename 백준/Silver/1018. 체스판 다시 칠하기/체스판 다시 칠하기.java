import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 이미 8X8 크기가 정해져 있다고 가정하자. 이 경우의 최소값은 아래와 같이 정한다.
            // 좌측 상단이 B/W 2가지 경우에 따라서 칠해져야 하는 최종 형태는 이미 정해져 있다.
            // 8X8 크기이기 때문에, 모든 정사각형을 바꿔 칠할 경우 그 횟수는 64회가 최대이다.
            // 한 가지 경우의 수에 대해 계산한다면, 나머지 다른 경우의 수에 대해 알 수 있다.
            // 다시 말해, 좌측 상단이 B일 경우 칠해야 하는 횟수가 x이라는 것만 안다면, 좌측 상단이 W일 경우, (64-x)회 칠해야 한다.
            // 이후 x와 (64-x)를 서로 비교해서 최소값을 도출할 수 있다.
        // 그렇다면 8X8 크기를 어느 좌표에서 할 건지 결정은 어떻게 할 수 있는가? 어떻게 해야 최소값이 나오게 하는 좌표를 알 수 있을까?
            // 이번 문제는 단순하게 모든 경우의 수를 찾는 브루트 포스 알고리즘을 사용해도 무방하다
            // 시간복잡도 O(N^2)이지만 N이 50 이하이기 때문에 충분히 사용 가능하기 때문이다
        // 이 문제의 B/W를 어떤 자료구조에 담는 게 효율적일까?
            // A two-dimensional array of a primitive boolean type
        // 어떤 흐름으로 문제를 풀어야 할까?
            // 일단 입력값을 통해 전체 보드판을 boolean[][] 배열으로 저장하고 이중 반복문 구조를 만든다
            // 이중반복문을 통해 순회하며 기준점이 되는 좌측 상단의 좌표를 지정한다.
            // 좌측 상단에 칠해져 있는 색깔을 기준으로 행마다, 열마다, 차례대로 반전해가며 칠해야 하는 색깔을 알아낼 수 있다.
            // 주어진 배열의 특정 요소와 칠해야 하는 색깔과 비교 후 다시 칠해야 할 횟수를 누적 집계한다.
            // 최종 누적 집계된 경우를 64에서 뺀 경우와 비교하여 최소값을 도출한다. 해당 값은 주어진 크기에서의 최소값이다.
            // 위 이중반복문에서 각 주어진 크기에서의 최소값 중에서 최소값을 출력한다.
        // 이때 최소값을 굳이 저장할 필요없이 갱신하는 방식으로 대체한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'B') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int min = 64;
        // 정해진 크기 기준 직접 찾아야 하는 경우의 수는 (N - 8 + 1) * (M - 8 + 1)
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int temp = findMin(arr, i, j);
                if (min > temp) {
                    min = temp;
                }
            }
        }

        System.out.println(min);
    }

    private static int findMin(boolean[][] arr, int y, int x) {
        int count = 0;
        // 좌측 상단 좌표가 기준점
        boolean isBlack = arr[y][x];
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (isBlack != arr[i][j]) {
                    count++;
                }
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }
        return count < 32 ? count : 64 - count;
    }
}