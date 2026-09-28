// Two pointer pattern
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        
        int targetIndex = 0;
        for (int num = 1; num <= n; num++) {
            if (targetIndex == target.length) {
                break;
            }

            list.add("Push");

            if (num == target[targetIndex]) {
                // 일치
                targetIndex++; // Pointer update
            } else {
                // 불일치
                list.add("Pop");
            }
        }

        return list; 
    }
}