import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public String solution(int[] numbers) {
        // Comparator
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num1 = o1;
                int o1Digit = num1 == 0 ? 1 : 0;
                while (num1 > 0) {
                    num1 /= 10;
                    o1Digit++;
                }

                int num2 = o2;
                int o2Digit = num2 == 0 ? 1 : 0;
                while (num2 > 0) {
                    num2 /= 10;
                    o2Digit++;
                }

                // comparison between ab ba
                return (int) ((o2 * Math.pow(10, o1Digit) + o1) - (o1 * Math.pow(10, o2Digit) + o2));
            }
        };
        // Stream
        Stream<Integer> boxed = Arrays.stream(numbers).boxed();
        String answer = boxed.sorted(comparator).map(String::valueOf).collect(Collectors.joining());

        if (answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}