import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> userToBoss = new HashMap<>();

        // 회원 : 추천인 매핑
        for (int i = 0; i < enroll.length; i++) {
            userToBoss.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> userToProfit = new HashMap<>(); // 회원별 본인이 갖게 되는 돈 매핑
        for (int i = 0; i < seller.length; i++) {
            String currentName = seller[i];
            int money = amount[i] * 100;

            while (money > 0 && !currentName.equals("-")) {
                // 당사자가 갖게 될 기존 돈의 90%을 가산한다.
                userToProfit.put(currentName, userToProfit.getOrDefault(currentName, 0) + money - money / 10); 

                currentName = userToBoss.get(currentName); // 당사자의 추천인을 다음 차수의 당사자로 갱신한다
                money /= 10; // 다음 차수의 당사자에게 지급할 돈은 현재 당사자가 넘긴 돈이다.
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = userToProfit.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}