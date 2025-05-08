package programmers.Lv3.합승택시요금;

import java.util.Arrays;

class Solution {
    private int answer, min;
    private int[][] map;
    private final int INF = 1000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // map 초기화
        init(n, fares);
        // 풀이 과정
        solve(n, s, a, b);

        return answer;
    }

    private void solve(int n, int s, int a, int b){
        // 플로이드 알고리즘을 통해 정점사이의 최단거리 구하기
        floyd(n);

        // 합승한 경우 최솟값 구하기
        min = togetherMinimum(s, n, a, b);

        // 합승한 경우와 안했을 때 중 최솟값을 정답으로 반환
        answer = Math.min(min, map[s][a] + map[s][b]);
    }

    private int togetherMinimum(int start, int n, int a, int b){
        min = Integer.MAX_VALUE;

        for(int mid = 1; mid <= n; mid++){
            min = Math.min(min, map[start][mid] + map[mid][a] + map[mid][b]);
        }

        return min;
    }

    private void floyd(int n){
        for(int mid = 1; mid <= n; mid++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    map[i][j] = Math.min(map[i][j], map[i][mid] + map[mid][j]);
                }
            }
        }
    }

    private void init(int n, int[][] fares){
        map = new int[n + 1][n + 1];
        for(int[] m : map){
            Arrays.fill(m, INF);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    map[i][j] = 0;
                }
            }
        }

        // 인접 배열 초기화
        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int weight = fare[2];

            map[from][to] = Math.min(map[from][to], weight);
            map[to][from] = Math.min(map[to][from], weight);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
        int solution2 = sol.solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}});
        int solution3 = sol.solution(6, 4, 5, 6, new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}