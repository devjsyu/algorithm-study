import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(solution(arr));
    }
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
                    }
                })
                .forEach(sb::append);
        String answer = sb.toString();
        if (answer.startsWith("0")) {
            answer = "0";
        }
        return answer;
    }
}