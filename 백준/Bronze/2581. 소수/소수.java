import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean isFirst = true;
        int min = 0;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                if (isFirst) {
                    min = i;
                    isFirst = false;
                }
                sum += i;
            }
        }

        // 지정된 범위 내 소수가 없는 경우
        if (isFirst) {
            System.out.println(-1);
        } else {
            // 지정된 범위 내 소수가 있는 경우
            System.out.println(sum);
            System.out.println(min);
        }
    }

    // 소수 판별 메서드
    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        if (num == 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else {
            for (int i = 2; i <= sqrt ; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}