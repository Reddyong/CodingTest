package programmers.Lv2.게임맵최단거리;

import java.util.*;

class Solution {
    private int N;
    private int M;
    private int answer;
    private boolean[][] visited;
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int solution(int[][] maps) {
        init(maps);
        bfs(maps);

        return answer;
    }

    private void bfs(int[][] maps){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            if(poll.r == N - 1 && poll.c == M - 1){
                answer = poll.depth;
                return;
            }

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1){
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr, nc, poll.depth + 1));
                }
            }
        }
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= M){
            return false;
        }

        return true;
    }

    private void init(int[][] maps){
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        answer = -1;
    }

    private class Pos{
        int r;
        int c;
        int depth;

        public Pos(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        int solution2 = sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}