package programmers.Lv2.영어끝말잇기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<String> set;
    public int[] solution(int n, String[] words) {

        return solve(n, words);
    }

    private int[] solve(int n, String[] words){
        set = new HashSet<>();
        int count = 2;
        int turn = 1;
        set.add(words[0]);

        for(int i = 1; i < words.length; i++){
            String prev = words[i - 1];
            String cur = words[i];

            if(i % n == 0){
                count = 1;
                turn++;
            }

            if(prev.charAt(prev.length() - 1) != cur.charAt(0)){
                return new int[]{count, turn};
            }

            if(set.contains(words[i])){
                return new int[]{count, turn};
            }

            set.add(words[i]);
            count++;
        }

        return new int[]{0, 0};
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        int[] solution2 = sol.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        int[] solution3 = sol.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
