package programmers.Lv3.파괴되지않은건물;

class Solution {
    private int N, M, answer;
    private int[][] sum;
    public int solution(int[][] board, int[][] skill) {
        // 풀이 과정
        solve(board, skill);

        return answer;
    }

    private void solve(int[][] board, int[][] skill){
        N = board.length;
        M = board[0].length;
        sum = new int[N + 1][M + 1];

        // skill들을 돌면서 하나씩 진행
        for(int[] s : skill){
            // 각 스킬을 적용한 누적합 저장
            changeBoard(s, board);
        }

        // 누적합 진행
        calc();

        // 최종 보드판을 돌면서 누적합 비교하며 남아있는 건물 갯수 판단
        answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] + sum[i][j] > 0){
                    answer++;
                }
            }
        }
    }

    private void calc(){
        // 가로 방향 누적합 계산
        for(int i = 0; i < N + 1; i++){
            for(int j = 1; j < M + 1; j++){
                sum[i][j] += sum[i][j - 1];
            }
        }

        // 세로 방향 누적합 계산
        for(int j = 0; j < M + 1; j++){
            for(int i = 1; i < N + 1; i++){
                sum[i][j] += sum[i - 1][j];
            }
        }
    }

    private void changeBoard(int[] s, int[][] board){
        int degree = s[5];

        // 공격인 경우
        if(s[0] == 1){
            degree *= -1;
        }

        // 누적합 할 값 저장
        sum[s[1]][s[2]] += degree;
        sum[s[1]][s[4] + 1] -= degree;
        sum[s[3] + 1][s[2]] -= degree;
        sum[s[3] + 1][s[4] + 1] += degree;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}});
        int solution2 = sol.solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
