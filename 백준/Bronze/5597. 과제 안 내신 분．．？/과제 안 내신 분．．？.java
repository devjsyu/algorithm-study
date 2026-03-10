import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isSubmitted = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int index = Integer.parseInt(br.readLine()) - 1;
            isSubmitted[index] = true;
        }

        int i = 0;
        int notSubmitted = 0;
        while (notSubmitted < 2) {
            if (!isSubmitted[i]) {
                sb.append(i + 1).append('\n');
                notSubmitted++;
            }
            i++;
        }

        System.out.println(sb);
    }
}