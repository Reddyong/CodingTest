package programmers.Lv2.숫자변환하기;

import java.util.*;

class Solution1 {
    private int answer;
    private int[] dp;
    public int solution(int x, int y, int n) {
        solve(x, y, n);

        return answer;
    }

    private void solve(int x, int y, int n){
        dp = new int[y + 1];

        for(int i = x; i <= y; i++){
            if(i != x && dp[i] == 0){
                dp[i] = -1;
                continue;
            }

            if(i + n <= y){
                dp[i + n] = dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i + n], dp[i] + 1);
            }
            if(i * 2 <= y){
                dp[i * 2] = dp[i * 2] == 0 ? dp[i] + 1 : Math.min(dp[i * 2], dp[i] + 1);
            }
            if(i * 3 <= y){
                dp[i * 3] = dp[i * 3] == 0 ? dp[i] + 1 : Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        answer = dp[y];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(10, 40, 5);
        int solution2 = sol.solution(10, 40, 30);
        int solution3 = sol.solution(2, 5, 4);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }

}