class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change5 = 0;
        int change10 = 0;
        int change20 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                change5++;
            } else if (bill == 10) {
                if (change5 >= 1) {
                    change10++;
                    change5--;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (change10 >= 1 && change5 >= 1) {
                    change10--;
                    change5--;
                    change20++;
                } else if (change5 >= 3) {
                    change5 -= 3;
                    change20++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}