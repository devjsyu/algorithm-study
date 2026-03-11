import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 주어진 수를 두 인수의 곱으로 나타낼 때, 적어도 한 인수는 주어진 수의 제곱근보다 작거나 같다.
        int sqrt = (int) Math.sqrt(N);

        // 2부터 주어진 수의 제곱근까지 검사하면서, 나누어떨어지는 동안 해당 인수를 출력하고 계속 나눈다.
        for (int i = 2; i <= sqrt; i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }

        // 반복문이 끝난 뒤 N이 1이 아니라면, 남은 N은 소수이다.
        if (N != 1) {
            System.out.println(N);
        }
    }
}