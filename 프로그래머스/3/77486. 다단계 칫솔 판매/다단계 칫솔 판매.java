import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 자료구조
        HashMap<String, String> memberToReferral = new HashMap<>(); // 자식 - 부모 매핑
        HashMap<String, Integer> memberToProfit = new HashMap<>(); // 회원 - 이익 매핑

        // 입력
        for (int i = 0; i < enroll.length; i++) {
            memberToReferral.put(enroll[i], referral[i]);
            memberToProfit.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            // 1차 판매 이익 계산
            int profit = amount[i] * 100 - amount[i] * 100 / 10;
            memberToProfit.put(seller[i], memberToProfit.getOrDefault(seller[i], 0) + profit);

            // "-" 나올 때까지 추천인에게 판매 이익 일부 증여 반복
            String currentMember = memberToReferral.get(seller[i]);
            int currentProfit = amount[i] * 100 / 10;
            while (!currentMember.equals("-") && currentProfit != 0) {
                memberToProfit.put(currentMember, memberToProfit.getOrDefault(currentMember, 0) + currentProfit - currentProfit / 10);
                currentMember = memberToReferral.get(currentMember);
                currentProfit /= 10;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = memberToProfit.get(enroll[i]);
        }
        return answer;
    }
}