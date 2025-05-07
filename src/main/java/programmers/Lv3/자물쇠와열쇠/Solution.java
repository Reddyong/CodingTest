package programmers.Lv3.자물쇠와열쇠;

import java.util.*;

class Solution {
    private int[][] board;
    private int[] min, max;
    private int len, N, M;
    private boolean answer;
    public boolean solution(int[][] key, int[][] lock) {
        // 변수 초기화
        init(key, lock);
        // 풀이 과정
        solve(key, lock);

        return answer;
    }

    private void solve(int[][] key, int[][] lock){
        // key를 lock의 모든부분에 조금이라도 걸칠 수 있게 하도록 board 생성
        // lock을 가운데 오게 하고, 한 변의 길이를 N + 2 * (M - 1)로 가지는 board 생성
        makeBoard(lock);

        // board 돌면서, key와 비교하기
        // 한번 비교할때, 90도씩 돌린 4가지 방법 모두 비교
        compareWithKey(key);
    }

    private void compareWithKey(int[][] key){
        for(int i = 0; i < len - M + 1; i++){
            for(int j = 0; j < len - M + 1; j++){
                for(int dir = 0; dir < 4; dir++){
                    // 올바른 key인지 확인
                    if(isCorrectKey(i, j, key)){
                        answer = true;
                        return;
                    }

                    // 방향 오른쪽으로 90도 회전
                    key = changeDirection(key);
                }
            }
        }

        answer = false;
    }

    private int[][] changeDirection(int[][] key){
        int[][] tempKey = new int[M][M];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                tempKey[i][j] = key[j][M - i - 1];
            }
        }

        key = tempKey;

        return key;
    }

    private boolean isCorrectKey(int r, int c, int[][] key){
        int[][] tempBoard = new int[len][len];

        // board 복사
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                tempBoard[i][j] = board[i][j];
            }
        }

        // key 값 tempBoard에 대입
        for(int i = r; i < r + M; i++){
            for(int j = c; j < c + M; j++){
                tempBoard[i][j] += key[i - r][j - c];
            }
        }

        // key 일치 여부 확인
        for(int i = M - 1; i < M + N - 1; i++){
            for(int j = M - 1; j < M + N - 1; j++){
                if(tempBoard[i][j] == 0 || tempBoard[i][j] == 2){
                    return false;
                }
            }
        }

        return true;
    }

    private void makeBoard(int[][] lock){
        len = N + 2 * (M - 1);
        board = new int[len][len];

        // board 중앙에 lock 오게 하기
        for(int i = M - 1; i < M + N - 1; i++){
            for(int j = M - 1; j < M + N - 1; j++){
                board[i][j] = lock[i - M + 1][j - M + 1];
            }
        }
    }

    private void init(int[][] key, int[][] lock){
        N = lock.length;
        M = key.length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean solution = sol.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});

        System.out.println("solution = " + solution);
    }
}
