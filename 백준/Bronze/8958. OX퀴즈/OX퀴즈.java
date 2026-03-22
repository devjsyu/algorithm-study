import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            String line = br.readLine();
            int sum = 0;
            int add = 0;
            boolean isConsecutive = false;
            for (char c : line.toCharArray()) {
                if (c == 'O') {
                    add++;
                    sum += add;
                    isConsecutive = true;
                } else {
                    isConsecutive = false;
                    add = 0;
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}