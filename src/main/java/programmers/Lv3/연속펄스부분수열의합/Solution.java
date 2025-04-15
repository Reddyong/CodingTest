package programmers.Lv3.연속펄스부분수열의합;

import java.util.*;

class Solution {
    private int N;
    private long answer;
    private long[][] dp;
    private final int PULSE = -1;
    public long solution(int[] sequence) {
        // dp 배열 및 변수 초기화
        init(sequence);

        // 풀이 과정
        solve(sequence);

        return answer;
    }

    private void solve(int[] sequence){
        // 길이가 1인 경우
        if(N == 1){
            answer = Math.max(dp[0][0], dp[0][1]);
            return;
        }

        // dp 배열 채워나가며 최댓값 업데이트
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i - 1][1] + sequence[i], sequence[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + sequence[i] * PULSE, sequence[i] * PULSE);

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
    }

    private void init(int[] sequence){
        N = sequence.length;
        dp = new long[N][2];
        answer = 0;

        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0] * PULSE;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution = sol.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4});

        System.out.println("solution = " + solution);
    }
}