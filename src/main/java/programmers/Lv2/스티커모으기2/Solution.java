package programmers.Lv2.스티커모으기2;

import java.util.*;

class Solution {
    private int[] dp;
    private int answer;
    private int N;
    public int solution(int sticker[]) {
        init(sticker);
        solve(sticker);

        return answer;
    }

    private void solve(int[] sticker){
        if(N == 1){
            answer = sticker[0];
            return;
        }

        dp[0] = sticker[0];
        dp[1] = dp[0];

        for(int i = 2; i < N - 1; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        answer = dp[N - 2];

        dp[0] = 0;
        dp[1] = sticker[1];

        for(int i = 2; i < N; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        answer = Math.max(answer, dp[N - 1]);
    }

    private void init(int[] sticker){
        answer = 0;
        N = sticker.length;
        dp = new int[N];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10});
        int solution2 = sol.solution(new int[]{1, 3, 2, 5, 4});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}