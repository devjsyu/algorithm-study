import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += list.get(i);
        }

        boolean found = false;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int num1 = list.get(i);
                int num2 = list.get(j);
                int remainder = sum - 100 - num1;

                if (num2 == remainder) {
                    list.remove(Integer.valueOf(num1));
                    list.remove(Integer.valueOf(num2));
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        list.stream().sorted().forEach(o -> sb.append(o).append('\n'));
        System.out.print(sb);
    }
}