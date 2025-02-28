package programmers.Lv2.쿼드압축후개수세기;

import java.util.Arrays;

class Solution {
    private int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        answer = new int[2];
        dfs(0, 0, arr.length, arr);

        return answer;
    }

    private void dfs(int r, int c, int n, int[][] arr){
        int cur = arr[r][c];

        if(n == 1 || isAllSame(r, c, n, arr)){
            answer[cur]++;
            return;
        }

        dfs(r, c, n / 2, arr);
        dfs(r, c + n / 2, n / 2, arr);
        dfs(r + n / 2, c, n / 2, arr);
        dfs(r + n / 2, c + n / 2, n / 2, arr);

    }

    private boolean isAllSame(int r, int c, int n, int[][] arr){
        int cur = arr[r][c];

        for(int i = r; i < r + n; i++){
            for(int j = c; j < c + n; j++){
                if(cur != arr[i][j]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        int[] solution2 = sol.solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
