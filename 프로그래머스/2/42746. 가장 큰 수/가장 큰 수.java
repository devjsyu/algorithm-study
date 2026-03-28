import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        if (!s1.equals("0") && !s2.equals("0")) {
                            return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
                        } else if (s1.equals("0")) {
                            return Integer.parseInt(s2 + s1) - Integer.parseInt(s2);
                        } else {
                            return Integer.parseInt(s1) - Integer.parseInt(s1 + s2);
                        }
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