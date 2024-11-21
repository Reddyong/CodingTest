package programmers.Lv2.카펫;

import java.util.Arrays;

public class Solution {
    public int[] solution(int brown, int yellow) {

        return solve(brown, yellow);
    }

    private int[] solve(int brown, int yellow){
        int[] ans = new int[2];

        int count = (brown - 4) / 2;

        for(int i = 1; i <= count; i++){
            int garo = count - i;
            int sero = i;

            if(garo * sero == yellow){
                ans[0] = garo + 2;
                ans[1] = sero + 2;

                break;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(10, 2);
        int[] solution2 = sol.solution(8, 1);
        int[] solution3 = sol.solution(24, 24);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
