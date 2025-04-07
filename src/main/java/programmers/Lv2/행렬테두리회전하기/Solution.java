package programmers.Lv2.행렬테두리회전하기;

import java.util.*;

class Solution {
    private int[][] board;
    private int[] answer;
    private int temp;
    private int min;
    private int[] dr = new int[]{0, 1, 0, -1};
    private int[] dc = new int[]{1, 0, -1, 0};
    public int[] solution(int rows, int columns, int[][] queries) {
        init(rows, columns, queries);
        solve(rows, columns, queries);

        return answer;
    }

    private void solve(int rows, int columns, int[][] queries){
        for(int i = 0; i < queries.length; i++){
            int r = queries[i][0] - 1;
            int c = queries[i][1] - 1;
            min = board[r][c];
            temp = board[r][c];
            for(int j = 0; j < 4; j++){
                while(true){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if(!isInBoard(nr, nc, queries[i])){
                        break;
                    }

                    r += dr[j];
                    c += dc[j];

                    move(r, c);
                }
            }

            answer[i] = min;
        }
    }

    private void move(int r, int c){
        int tmp = board[r][c];
        board[r][c] = temp;
        temp = tmp;

        min = Math.min(min, temp);
    }

    private boolean isInBoard(int r, int c, int[] query){
        int r1 = query[0] - 1;
        int r2 = query[2] - 1;
        int c1 = query[1] - 1;
        int c2 = query[3] - 1;

        if(r <= r2 && r >= r1 && c <= c2 && c >= c1){
            return true;
        }

        return false;
    }

    private void init(int rows, int columns, int[][] queries){
        answer = new int[queries.length];
        board = new int[rows][columns];

        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = num++;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        int[] solution2 = sol.solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
        int[] solution3 = sol.solution(100, 97, new int[][]{{1, 1, 100, 97}});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
