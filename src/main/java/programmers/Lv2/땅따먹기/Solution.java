package programmers.Lv2.땅따먹기;

import java.util.*;

class Solution {
    private int N;
    private int answer;
    private int[][] dp;
    int solution(int[][] land) {
        init(land);
        solve(land);

        return answer;
    }

    private void solve(int[][] land){
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 4; j++){
                int max = 0;
                for(int k = 0; k < 4; k++){
                    if(j == k){
                        continue;
                    }

                    max = Math.max(max, dp[i - 1][k]);
                }

                dp[i][j] = land[i][j] + max;
            }
        }

        for(int i = 0; i < 4; i++){
            answer = Math.max(dp[N - 1][i], answer);
        }
    }

    private void init(int[][] land){
        N = land.length;
        answer = 0;
        dp = new int[N][4];

        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});

        System.out.println("solution = " + solution);
    }
}
