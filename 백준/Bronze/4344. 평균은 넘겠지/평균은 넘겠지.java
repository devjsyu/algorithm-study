import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                int score = Integer.parseInt(st.nextToken());
                list.add(score);
                sum += score;
            }

            float avg = (float) sum / size;
            int count = 0;

            for (int j = 0; j < size; j++) {
                if (list.get(j) > avg) {
                    count++;
                }
            }

            float aboveAvg = (float) count / size * 100;
            String formatted = String.format("%.3f", aboveAvg);
            sb.append(formatted).append("%").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}