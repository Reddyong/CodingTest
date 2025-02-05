package programmers.Lv2.피로도;

import java.util.*;

class Solution {
    private int answer;
    private boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        init(dungeons);
        solve(k, dungeons);

        return answer;
    }

    private void solve(int k, int[][] dungeons){
        gaming(k, 0, dungeons);
    }

    private void gaming(int k, int depth, int[][] dungeons){
        answer = Math.max(answer, depth);

        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                gaming(k - dungeons[i][1], depth + 1, dungeons);
                visited[i] = false;
            }
        }

    }

    private void init(int[][] dungeons){
        answer = 0;
        visited = new boolean[dungeons.length];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});

        System.out.println("solution = " + solution);
    }
}