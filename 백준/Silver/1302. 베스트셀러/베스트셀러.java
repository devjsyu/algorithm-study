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
            if (map.containsKey(title)) {
                Integer count = map.get(title);
                count++;
                map.put(title, count);
            } else {
                map.put(title, 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                if (t1.getValue() > t2.getValue()) {
                    return -1;
                } else if (t1.getValue() < t2.getValue()) {
                    return 1;
                } else {
                    return t1.getKey().compareTo(t2.getKey());
                }
            }
        });

        System.out.println(list.get(0).getKey());
    }
}
