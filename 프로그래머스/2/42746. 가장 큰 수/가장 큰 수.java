import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Arrays.stream(numbers).mapToObj(String::valueOf).sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                sb2.append(s1).append(s2);
                String string1 = sb2.toString();
                sb2.setLength(0);

                sb2.append(s2).append(s1);
                String string2 = sb2.toString();
                sb2.setLength(0);

                return string1.compareTo(string2);
            }
        }.reversed()).forEach(sb1::append);
        String answer = sb1.toString();
        if (answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}