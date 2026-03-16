import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        // store x, y coordinate in an array
        
        // initialize x, y coordinate
        int x = 5;
        int y = 5;
        
        // initialize the commands with HashMap
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('R', new int[]{1, 0});
        map.put('L', new int[]{-1, 0});

        // store every path with HashSet
        HashSet<String> set = new HashSet<>();

        // for-loop
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = map.get(dirs.charAt(i)); // offset for the given command
            int xMoved = x + offset[0];
            int yMoved = y + offset[1];
            
            // continue the loop if it's not valid
            if (!isValid(xMoved, yMoved)) {
                continue;
            }

            // double the path and divide it with 2 at the end
            set.add(x + " " + y + " " + xMoved + " " + yMoved);
            set.add(xMoved + " " + yMoved + " " + x + " " + y);
            
            // update x, y coordinate for the next loop
            x = xMoved;
            y = yMoved;
        }
        
        return set.size() / 2;
    }

    // isValid
    private boolean isValid(int xMoved, int yMoved) {
        return 0 <= xMoved && xMoved < 11 && 0 <= yMoved && yMoved < 11;
    }
}