package programmers.Lv2.거리두기확인하기;

import java.util.*;

class Solution {
    private int[] answer;
    private char[][] p;
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int[] solution(String[][] places) {
        solve(places);

        return answer;
    }

    private void solve(String[][] places){
        answer = new int[5];

        for(int i = 0; i < 5; i++){
            answer[i] = getResult(places[i]);
        }
    }

    private int getResult(String[] place){
        p = new char[5][5];
        int ans = 1;

        // 각 방 초기화
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                p[i][j] = place[i].charAt(j);
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(p[i][j] == 'P'){
                    ans = bfs(i, j, p);

                    if(ans == 0){
                        return ans;
                    }
                }
            }
        }

        return ans;
    }

    private int bfs(int r, int c, char[][] p){
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new Pos(r, c, 0));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            if(poll.depth > 2){
                continue;
            }

            if(p[poll.r][poll.c] == 'P' && poll.depth > 0){
                return 0;
            }

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && p[nr][nc] != 'X'){
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr, nc, poll.depth + 1));
                }

            }

        }

        return 1;
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= 5 || c >= 5){
            return false;
        }

        return true;
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
        int[] solution = sol.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        System.out.println("solution = " + Arrays.toString(solution));
    }
}