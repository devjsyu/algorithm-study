import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            Queue<int[]> queue = new ArrayDeque<>();
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int M = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            ArrayList<Integer> order = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int element = Integer.parseInt(st2.nextToken());
                arr[j] = element;
                queue.add(new int[]{j, element});
            }
            Arrays.sort(arr);
            for (int j = N - 1; j >= 0; j--) {
                int largest = arr[j];
                while (queue.peek()[1] != largest) {
                    queue.add(queue.poll());
                }
                order.add(queue.poll()[0]);
            }
            sb.append(order.indexOf(M) + 1).append('\n');
        }
        System.out.print(sb);
    }
}