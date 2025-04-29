package programmers.Lv1.택배상자꺼내기;

import java.util.*;

class Solution {
    private int answer;
    private int[][] board;
    private int[] dc = new int[]{1, -1};
    public int solution(int n, int w, int num) {
        // board에 상자 채우기
        init(n, w, num);
        // 풀이 과정
        solve(w, num);

        return answer;
    }

    private void solve(int w, int num){
        // 찾을 숫자의 행 판단
        int row = num / w;

        if(num % w == 0){
            row--;
        }

        // 찾을 숫자의 위치 판단
        int col = 0;
        for(int i = 1; i <= w; i++){
            if(board[row][i] == num){
                col = i;
                break;
            }
        }

        // 숫자의 위치 부터 아래쪽으로 내려가면서 상자 갯수 세기
        for(int i = row; i < board.length; i++){
            if(board[i][col] == 0){
                continue;
            }

            answer++;
        }
    }

    private void init(int n, int w, int num){
        answer = 0;

        // board의 행 길이 판단
        int r = n / w;
        if(n % w == 0){
            r--;
        }

        board = new int[r + 1][w + 1];

        // board 채우기
        int curR = 0;
        int curC = 1;
        int curNum = 1;
        int curDir = 0;

        while(n > 0){
            // board에 현재 숫자 대입
            board[curR][curC] = curNum;
            // 다음 위치로 이동
            curC += dc[curDir];

            // board 벗어나면 방향 변경 및 아래줄로 이동
            if(curC > w || curC < 1){
                curDir = 1 - curDir;
                curR++;
                curC += dc[curDir];
            }

            // 숫자 증가
            curNum++;
            n--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(22, 6, 8);
        int solution2 = sol.solution(13, 3, 6);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
