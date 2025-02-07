package programmers.Lv3.네트워크;
import java.util.*;

class Solution {
    private int answer;
    private boolean[] visited;
    public int solution(int n, int[][] computers) {
        init(n);
        solve(n, computers);

        return answer;
    }

    private void solve(int n, int[][] computers){
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, n, computers);
                answer++;
            }
        }
    }

    private void dfs(int idx, int n, int[][] computers){
        for(int i = 0; i < n; i++){
            if(!visited[i] && computers[idx][i] == 1){
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }

    private void init(int n){
        answer = 0;
        visited = new boolean[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        int solution2 = sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
