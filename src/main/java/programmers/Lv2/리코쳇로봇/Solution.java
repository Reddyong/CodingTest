package programmers.Lv2.리코쳇로봇;

import java.util.*;

class Solution {
    private int[] R, G;
    private int N, M;
    private char[][] map;
    private boolean[][] visited;
    private int answer;
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int solution(String[] board) {
        init(board);
        solve();

        return answer;
    }

    private void solve(){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(R[0], R[1], 0));
        visited[R[0]][R[1]] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            if(poll.r == G[0] && poll.c == G[1]){
                answer = poll.depth;
                return;
            }

            for(int i = 0; i < 4; i++){
                int[] temp = getNextLocation(poll.r, poll.c, i);
                int nr = temp[0];
                int nc = temp[1];

                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr, nc, poll.depth + 1));
                }
            }
        }
    }

    private int[] getNextLocation(int r, int c, int dir){
        while(isInBoard(r, c) && map[r][c] != 'D'){
            r += dr[dir];
            c += dc[dir];
        }

        r -= dr[dir];
        c -= dc[dir];

        return new int[]{r, c};
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= M){
            return false;
        }

        return true;
    }

    private void init(String[] board){
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];
        answer = -1;

        for(int i = 0; i < N; i++){
            char[] c = board[i].toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = c[j];

                if(map[i][j] == 'R'){
                    R = new int[]{i, j};
                }

                if(map[i][j] == 'G'){
                    G = new int[]{i, j};
                }
            }
        }
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
        int solution1 = sol.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        int solution2 = sol.solution(new String[]{".D.R", "....", ".G..", "...D"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
