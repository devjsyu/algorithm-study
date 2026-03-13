import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[3];

        // Arrays API
        for (int i = 0; i < 3; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints);

        System.out.println(ints[1]);
    }
}