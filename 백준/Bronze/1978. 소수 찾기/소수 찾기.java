import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (isPrime(num)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int num) {
        // 1은 소수가 아니기 때문에 제외하기
        if (num == 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        int sqrt = (int) Math.sqrt(num);

        // 2부터 주어진 수의 제곱근까지 나누어 나머지가 0인 경우가 있다면 제외하기
        for (int i = 2; i <= sqrt; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
}