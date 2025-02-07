package programmers.Lv3.정수삼각형;

import java.util.*;

class Solution {
    private int[][] dp;
    private int answer;
    public int solution(int[][] triangle) {
        solve(triangle);

        return answer;
    }

    private void solve(int[][] triangle){
        answer = 0;
        dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }

        for(int i = 0; i < triangle.length; i++){
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});

        System.out.println("solution = " + solution);
    }
}
