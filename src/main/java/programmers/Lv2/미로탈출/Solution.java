package programmers.Lv2.미로탈출;

import java.util.*;

class Solution {
    private int answer, N, M;
    private int[] start, lever, end;
    private char[][] map;
    private boolean[][] visited;
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int solution(String[] maps) {
        init(maps);
        solve();

        return answer;
    }

    private void solve(){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        int temp = -1;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            if(lever[0] == poll.r && lever[1] == poll.c){
                temp = poll.depth;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'X'){
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr, nc, poll.depth + 1));
                }
            }
        }

        if(temp == -1){
            return;
        }

        queue = new LinkedList<>();
        queue.add(new Pos(lever[0], lever[1], temp));
        visited = new boolean[N][M];
        visited[lever[0]][lever[1]] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            if(end[0] == poll.r && end[1] == poll.c){
                answer = poll.depth;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'X'){
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

    private void init(String[] maps){
        answer = -1;
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];

        start = new int[2];
        lever = new int[2];
        end = new int[2];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = maps[i].charAt(j);

                if(map[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }

                if(map[i][j] == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }

                if(map[i][j] == 'E'){
                    end[0] = i;
                    end[1] = j;
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
        int solution1 = sol.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
        int solution2 = sol.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
