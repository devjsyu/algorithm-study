import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        for (int number : numbers) {
           if (number != 0) {
               return Arrays.stream(numbers).mapToObj(String::valueOf).sorted(new Comparator<String>() {
                   @Override
                   public int compare(String s1, String s2) {
                       return (s2+s1).compareTo(s1+s2);
                   }
               }).collect(Collectors.joining());       
           }
        }
        return "0";
    }
}