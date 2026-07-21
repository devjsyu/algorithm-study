import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        // phone_book 배열 순회하여 HashSet 초기화
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        // 모든 단어에 대해 순회
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = 0; j < s.length(); j++) {
                // 각 단어에 대해 한 글자씩 substring 늘려가며 HashSet에 해당 substring이 존재하는지 검사
                String substring = s.substring(0, j);
                if (set.contains(substring)) {
                    return false;
                }
            }
        }

        return true;
    }
}