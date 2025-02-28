package programmers.Lv2.삼각달팽이;

import java.util.Arrays;

class Solution {
    private int[][] arr;
    private int num;
    private int r;
    private int c;
    private int count;
    private int[] dr = new int[]{1, 0, -1};
    private int[] dc = new int[]{0, 1, -1};
    private int[] answer;
    public int[] solution(int n) {
        init(n);
        solve(n);

        return answer;
    }

    private void solve(int n){
        while(count < n){
            arr[r][c] = num++;

            int nr = r + dr[count % 3];
            int nc = c + dc[count % 3];

            if(!isInBoard(nr, nc, n) || arr[nr][nc] != 0){
                count++;
            }

            r += dr[count % 3];
            c += dc[count % 3];
        }

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    continue;
                }

                answer[idx] = arr[i][j];
                idx++;
            }
        }
    }

    private boolean isInBoard(int r, int c, int n){
        if(r < 0 || c < 0 || r >= n || c >= n){
            return false;
        }

        return true;
    }

    private void init(int n){
        arr = new int[n][n];
        num = 1;
        r = 0;
        c = 0;
        count = 0;

        int temp = 0;
        for(int i = 1; i <= n; i++){
            temp += i;
        }

        answer = new int[temp];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(4);
        int[] solution2 = sol.solution(5);
        int[] solution3 = sol.solution(6);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
