import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] ex1 = {2, 1, 3, 4, 1};
        int[] ex2 = {5, 0, 2, 7};
        System.out.println(Arrays.toString(solution(ex1)));
        System.out.println(Arrays.toString(solution(ex2)));
    }

    public static int[] solution(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}