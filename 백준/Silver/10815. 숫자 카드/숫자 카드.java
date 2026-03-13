import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stN = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(stN.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (set.contains(Integer.parseInt(stM.nextToken()))) {
                sb.append('1').append(' ');
            } else {
                sb.append('0').append(' ');
            }
        }

        System.out.println(sb.toString().trim());
    }
}