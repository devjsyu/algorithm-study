import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                Integer polled = queue.poll();
                queue.add(polled);
            }
            Integer polled = queue.poll();
            list.add(polled);
        }

        StringBuilder sb = new StringBuilder();
        String string = list.stream().map(String::valueOf).collect(Collectors.joining(", "));
        sb.append("<").append(string).append(">");
        System.out.println(sb);
    }
}