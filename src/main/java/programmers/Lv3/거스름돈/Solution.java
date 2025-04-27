package programmers.Lv3.거스름돈;

class Solution {
    private int answer;
    private int[] dp;
    private final int MOD = 1000000007;
    public int solution(int n, int[] money) {
        solve(n, money);

        return answer;
    }

    private void solve(int n, int[] money){
        dp = new int[n + 1];
        dp[0] = 1;
        answer = 0;

        for(int i = 0; i < money.length; i++){
            for(int j = 1; j <= n; j++){
                if(j >= money[i]){
                    dp[j] += (dp[j - money[i]] % MOD);
                }
            }
        }

        answer = dp[n] % MOD;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(5, new int[]{1, 2, 5});

        System.out.println("solution = " + solution);
    }
}
