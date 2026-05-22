class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || str.charAt(i) != strs[j].charAt(i)) {
                    if (i == 0) {
                        return "";
                    }
                    return str.substring(0, i);
                }
            }
        }
        return str;
    }
}