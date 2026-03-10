import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 변수 할당
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] baskets = new int[n];

        // 바구니 초기화
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1; // 인덱스 + 1
        }

        // 변수 선언
        int i;
        int j;
        int temp;

        // 반복문
        for (int k = 0; k < m; k++) {
            input = br.readLine().split(" ");
            // 인덱스 기준으로 계산하기 위해 -1 보정
            i = Integer.parseInt(input[0]) - 1;
            j = Integer.parseInt(input[1]) - 1;

            // 교환
            temp = baskets[i];
            baskets[i] = baskets[j];
            baskets[j] = temp;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append(baskets[k]);
            if (k < n - 1) {
                sb.append(' ');
            }
        }
        System.out.println(sb);

        // 리소스 관리
        br.close();
    }
}