import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);

//            if (map.containsKey(title)) {
//                map.put(title, map.get(title) + 1);
//            } else {
//                map.put(title, 1);
//            }
        }

        int max = 0;
        String answer = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String title = entry.getKey();
            int count = entry.getValue();

            if (answer == null || count > max || (count == max && title.compareTo(answer) < 0)) {
                max = count;
                answer = title;
            }
        }

//        String answer = "";
//        for (String title : map.keySet()) {
//            Integer count = map.get(title);
//            if (max < count) {
//                max = count;
//                answer = title;
//            } else if (max == count) {
//                if (answer.compareTo(title) > 0) {
//                    answer = title;
//                }
//            }
//        }

        System.out.println(answer);
    }
}
