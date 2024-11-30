package programmers.Lv2.멀리뛰기;

public class Solution {
    private long[] dp;
    public long solution(int n) {
        init(n);

        return solve(n);
    }

    private long solve(int n){
        if(n == 1){
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
        }

        return dp[n] % 1234567;
    }

    private void init(int n){
        dp = new long[n + 1];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution1 = sol.solution(4);
        long solution2 = sol.solution(3);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
