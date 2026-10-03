/**
is num the one of the elements from the target array?
    yes?    -> push
    no?     -> push and pop
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();

        int i = 0;
        for (int num = 1; num <= n; num++) {
            if (i >= target.length) {
                break;
            }

            if (target[i] == num) {
                answer.add("Push");
                i++;
            } else {
                answer.add("Push");
                answer.add("Pop");
            }
        }

        return answer;
    }
}