package programmers.Lv2.방문길이;

import java.util.*;

class Solution {
    private int answer = 0;
    // U : 0, R : 1, D : 2, L : 3
    private int[] dr = new int[]{-1, 0, 1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    private boolean visited[][][];
    public int solution(String dirs) {
        solve(dirs);

        return answer;
    }

    private void solve(String dirs){
        visited = new boolean[11][11][4];
        int r = 5;
        int c = 5;
        int d = 0;

        for(int i = 0; i < dirs.length(); i++){
            char dir = dirs.charAt(i);

            if(dir == 'U'){
                d = 0;
            } else if(dir == 'R'){
                d = 1;
            } else if(dir == 'D'){
                d = 2;
            } else{
                d = 3;
            }

            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isInBoard(nr, nc)){
                continue;
            }

            if(!visited[nr][nc][d]){
                answer++;
                visited[nr][nc][d] = true;
                d = (d % 2 == 0) ? 2 - d : 4 - d;
                visited[r][c][d] = true;;
            }

            r = nr;
            c = nc;
        }
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= 11 || c >= 11){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("ULURRDLLU");
        int solution2 = sol.solution("LULLLLLLU");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
