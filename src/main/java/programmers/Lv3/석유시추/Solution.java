package programmers.Lv3.석유시추;

import java.util.*;

class Solution {
    private boolean[][] visited;
    private boolean[] check;
    private int[] dp;
    private int answer, N, M;
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int solution(int[][] land) {
        // 초기화
        init(land);
        // 풀이 과정
        solve(land);

        return answer;
    }

    private void solve(int[][] land){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    bfs(i, j, land);
                }
            }
        }

        for(int i = 0; i < M; i++){
            answer = Math.max(answer, dp[i]);
        }
    }

    private void bfs(int r, int c, int[][] land){
        Queue<Pos> queue = new LinkedList<>();
        check = new boolean[M];
        queue.add(new Pos(r, c));
        visited[r][c] = true;
        check[c] = true;

        int sum = 0;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            sum++;

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && land[nr][nc] == 1){
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr, nc));

                    if(!check[nc]){
                        check[nc] = true;
                    }
                }
            }
        }

        for(int i = 0; i < M; i++){
            if(check[i]){
                dp[i] += sum;
            }
        }
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= M){
            return false;
        }

        return true;
    }

    private void init(int[][] land){
        answer = 0;
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        dp = new int[M];
    }

    private class Pos{
        int r;
        int c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
        int solution2 = sol.solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);

    }
}
