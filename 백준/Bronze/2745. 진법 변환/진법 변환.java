import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] N = st.nextToken().toCharArray();
        int[] digits = new int[N.length];

        // 주어진 N에서 각 자리 숫자를 10진법으로 치환한 배열 생성
        for (int i = N.length - 1; i >= 0 ; i--) {
            if (Character.isAlphabetic(N[i])) {
                digits[i] = ((int) N[i]) - 55; // 'A' ~ 'Z'의 ASCII value에서 55 차감하여 문제 조건과 일치시킴
            } else {
                digits[i] = ((int) N[i]) - 48; // '0' ~ '9'의 ASCII value에서 48 차감하여 문제 조건과 일치시킴
            }
        }

        int B = Integer.parseInt(st.nextToken());

        int decimal = 0;
        int k = 0;
        for (int i = N.length - 1; i >= 0 ; i--) {
            // 10진법으로 치환된 각 자리 숫자와 각 자리의 B진법 제곱을 곱한 결과를 십진법 숫자 변수에 누적 합산
            decimal += (int) Math.pow(B, k) * digits[i];
            k++;
        }

        System.out.println(decimal);
    }
}