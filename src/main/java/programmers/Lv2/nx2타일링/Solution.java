package programmers.Lv2.nx2타일링;

class Solution {
    private int[] dp;
    private int answer;
    private final int MOD = 1000000007;
    public int solution(int n) {
        solve(n);

        return answer;
    }

    private void solve(int n){
        dp = new int[n + 1];

        if(n == 1){
            answer = 1;
            return;
        }

        if(n == 2){
            answer = 2;
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD;
        }

        answer = dp[n] % MOD;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(4);

        System.out.println("solution = " + solution);
    }
}