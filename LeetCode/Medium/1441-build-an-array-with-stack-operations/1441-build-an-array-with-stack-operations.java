/**
Two Pointers
matched? -> push, index update
not matched? -> push, pop
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();

        int index = 0;
        for (int num = 1; num <= n; num++) {
            if (target.length - 1 < index) {
                break;
            }

            // matched
            if (target[index] == num) {
                answer.add("Push");
                index++;
            } else {
                answer.add("Push");
                answer.add("Pop");
            }
        }

        return answer;
    }
}