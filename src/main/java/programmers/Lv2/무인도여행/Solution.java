package programmers.Lv2.무인도여행;

import java.util.*;

class Solution {
    private int n, m;
    private int[][] board;
    private int[] answer;
    private boolean[][] visited;
    private List<Integer> list;
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int[] solution(String[] maps) {
        init(maps);
        solve();

        return answer;
    }


    private void solve(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] != 0 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        if(list.isEmpty()){
            answer = new int[]{-1};
            return;
        }

        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
    }

    private void bfs(int r, int c){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(r, c, board[r][c]));
        visited[r][c] = true;
        int sum = 0;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            sum += poll.num;

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && board[nr][nc] != 0){
                    visited[nr][nc] = true;
                    queue.add(new Pos(nr, nc, board[nr][nc]));
                }
            }
        }

        list.add(sum);
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= n || c >= m){
            return false;
        }

        return true;
    }

    private void init(String[] maps){
        n = maps.length;
        m = maps[0].length();

        board = new int[n][m];
        visited = new boolean[n][m];
        list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) == 'X'){
                    continue;
                }

                board[i][j] = Integer.parseInt(maps[i].substring(j, j + 1));
            }
        }
    }

    private class Pos{
        int r;
        int c;
        int num;

        public Pos(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        int[] solution2 = sol.solution(new String[]{"XXX", "XXX", "XXX"});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
