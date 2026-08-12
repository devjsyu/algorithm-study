class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            str[i++] = String.valueOf(num);
        }
        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (str[0].startsWith("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : str) {
            sb.append(string);
        }
        return sb.toString();
    }
}