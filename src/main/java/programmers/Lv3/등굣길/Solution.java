package programmers.Lv3.등굣길;

class Solution {
    private int[][] map;
    private int[][] dp;
    private int answer;
    public int solution(int m, int n, int[][] puddles) {
        solve(m, n, puddles);

        return answer;
    }

    private void solve(int m, int n, int[][] puddles){
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        dp[1][1] = 1;

        for(int[] puddle : puddles){
            map[puddle[1]][puddle[0]] = -1;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                if(map[i][j] == -1){
                    continue;
                }

                dp[i][j] = dp[i - 1][j] % 1000000007 + dp[i][j - 1] % 1000000007;
            }
        }

        answer = dp[n][m] % 1000000007;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(4, 3, new int[][]{{2, 2}});

        System.out.println("solution = " + solution);
    }
}
