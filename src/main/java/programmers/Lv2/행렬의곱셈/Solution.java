package programmers.Lv2.행렬의곱셈;

import java.util.Arrays;

public class Solution {
    private int N;
    private int M;
    private int[][] answer;
    public int[][] solution(int[][] arr1, int[][] arr2) {
        init(arr1, arr2);
        solve(arr1, arr2);

        return answer;
    }

    private void solve(int[][] arr1, int[][] arr2){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < arr2.length; k++){
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
    }

    private void init(int[][] arr1, int[][] arr2){
        N = arr1.length;
        M = arr2[0].length;

        answer = new int[N][M];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] solution1 = sol.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        int[][] solution2 = sol.solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});

        for (int[] s1 : solution1) {
            System.out.println("s1 = " + Arrays.toString(s1));
        }

        for (int[] s2 : solution2) {
            System.out.println("s2 = " + Arrays.toString(s2));
        }
    }
}
