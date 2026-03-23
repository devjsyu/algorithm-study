import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        int[] coordinate = new int[]{0, 0};
        HashMap<Character, Integer[]> commands = new HashMap<>();
        commands.put('U', new Integer[]{0, 1});
        commands.put('D', new Integer[]{0, -1});
        commands.put('R', new Integer[]{1, 0});
        commands.put('L', new Integer[]{-1, 0});

        HashSet<String> paths = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            Integer[] move = commands.get(c);
            int x = coordinate[0];
            int y = coordinate[1];
            int xMove = move[0];
            int yMove = move[1];
            int xMoved = x + xMove;
            int yMoved = y + yMove;
            if (!isOutOfRange(xMoved, yMoved)) {
                coordinate[0] = xMoved;
                coordinate[1] = yMoved;
                
                paths.add(x + " " + xMoved + " " + y + " " + yMoved);
                paths.add(xMoved + " " + x + " " + yMoved + " " + y);
            }
        }

        int answer = paths.size() / 2;
        return answer;
    }

    private static boolean isOutOfRange(int xMoved, int yMoved) {
        int xMovedAbs = Math.abs(xMoved);
        int yMovedAbs = Math.abs(yMoved);
        return xMovedAbs > 5 || yMovedAbs > 5;
    }
}