package programmers.Lv2.전력망을둘로나누기;

import java.util.*;

class Solution {
    private int answer;
    private boolean[] visited;
    private int[][] map;
    public int solution(int n, int[][] wires) {
        init(n, wires);
        solve(n, wires);

        return answer;
    }

    private void solve(int n, int[][] wires){
        for(int i = 0; i < wires.length; i++){
            int r = wires[i][0];
            int c = wires[i][1];

            map[r][c] = 0;
            map[c][r] = 0;
            getResult(r, wires, n);
            map[r][c] = 1;
            map[c][r] = 1;

        }
    }

    private void getResult(int r, int[][] wires, int n){
        Queue<Pos> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        queue.add(new Pos(r, 1));
        visited[r] = true;

        int count = 0;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            count++;

            for(int i = 1; i < map[poll.r].length; i++){
                if(!visited[i] && map[poll.r][i] == 1){
                    visited[i] = true;
                    queue.add(new Pos(i, poll.depth + 1));
                }
            }
        }

        answer = Math.min(answer, Math.abs((n - count) - count));

    }

    private void init(int n, int[][] wires){
        answer = Integer.MAX_VALUE;
        map = new int[n + 1][n + 1];

        for(int[] wire : wires){
            int r = wire[0];
            int c = wire[1];

            map[r][c] = 1;
            map[c][r] = 1;
        }
    }

    private class Pos{
        int r;
        int depth;

        public Pos(int r, int depth){
            this.r = r;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        int solution2 = sol.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}});
        int solution3 = sol.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
