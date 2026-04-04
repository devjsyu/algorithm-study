import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int gcd = getGCD(num1, num2);
        int lcm = num1 / gcd * num2;
        
        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int getGCD(int num1, int num2) {
        if (num2 > num1) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num2  == 0) {
            return num1;
        } else {
            return getGCD(num2, num1 % num2);
        }
    }
}