class Solution
{
    public int solution(int n, int a, int b)
    {
        return countRounds(1, a, b);
    }

    private int countRounds(int count, int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (a + 1 == b && b % 2 == 0) {
            return count;
        } else {
            return countRounds(++count, nextRound(a), nextRound(b));
        }
    }

    private int nextRound(int x) {
        if (x % 2 == 0) {
            x /= 2;
        } else {
            x = (x + 1) / 2;
        }
        return x;
    }
}