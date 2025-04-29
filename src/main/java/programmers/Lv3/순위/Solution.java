package programmers.Lv3.순위;

import java.util.*;

class Solution {
    private int answer;
    private int[][] floyd;
    private final int MAX = 450001;
    public int solution(int n, int[][] results) {
        // 플로이드 배열 초기화
        init(n, results);
        // 풀이 과정
        solve(n);

        return answer;
    }

    private void solve(int n){
        for(int mid = 1; mid <= n; mid++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][mid] + floyd[mid][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                // 최단거리가 존재하는 두 선수만 count 증가
                // 최단거리가 존재한다는 뜻은 승패를 가렸다는 의미
                // 모든 선수와 승패를 가렸다는 것은 순위를 결정할 수 있다는 뜻
                if(floyd[i][j] != MAX || floyd[j][i] != MAX){
                    count++;
                }
            }

            if(count == n){
                answer++;
            }
        }
    }

    private void init(int n, int[][] results){
        answer = 0;
        floyd = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i != j){
                    floyd[i][j] = MAX;
                }
            }
        }

        for(int[] result : results){
            int s = result[0];
            int e = result[1];

            floyd[s][e] = 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});

        System.out.println("solution = " + solution);
    }
}
