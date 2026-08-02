import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < target.length; i++) {
            if (num == target[i]) {
                list.add("Push");
                num++;
            } else {
                int additional = target[i] - num;
                for (int j = 0; j < additional; j++) {
                    list.add("Push");
                    list.add("Pop");
                    num++;
                }
                list.add("Push");
                num++;
            }
        }
        return list;
    }
}