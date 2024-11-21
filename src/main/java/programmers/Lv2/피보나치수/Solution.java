package programmers.Lv2.피보나치수;

public class Solution {
    private int[] dp;
    public int solution(int n) {

        init(n);

        return solve(n);
    }

    private int solve(int n){
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
        }

        return dp[n] % 1234567;
    }

    private void init(int n){
        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(3);
        int solution2 = sol.solution(5);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
