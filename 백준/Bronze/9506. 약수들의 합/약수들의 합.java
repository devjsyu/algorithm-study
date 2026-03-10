import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int n;
        while ((n = Integer.parseInt(br.readLine())) > 0) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if ((n % i) == 0) {
                    sum += i;
                    list.add(i);
                }
                if (sum > n) {
                    break;
                }
            }
            if (sum == n) {
                StringBuilder sb = new StringBuilder();
                sb.append(n).append(" = ");
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    sb.append(list.get(i));
                    if (i < size - 1) {
                        sb.append(" + ");
                    }
                }
                System.out.println(sb);
            } else {
                System.out.printf("%d is NOT perfect.\n", n);
            }
            list.clear();
        }
    }
}