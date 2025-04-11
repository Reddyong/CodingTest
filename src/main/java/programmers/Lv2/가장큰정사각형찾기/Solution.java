package programmers.Lv2.가장큰정사각형찾기;

class Solution
{
    private int N, M, cur, answer;
    private int[][] dp;
    public int solution(int [][]board)
    {
        init(board);
        solve(board);

        return answer;
    }

    private void solve(int[][] board){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = board[i][j];
                    } else{
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }

                    cur = Math.max(cur, dp[i][j]);
                }
            }
        }

        answer = cur * cur;
    }

    private void init(int[][] board){
        N = board.length;
        M = board[0].length;
        answer = 0;
        cur = 0;
        dp = new int[N][M];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}});
        int solution2 = sol.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}});
        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
