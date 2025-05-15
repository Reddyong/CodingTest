package programmers.Lv2.혼자서하는틱택토;

class Solution {
    private int answer, O, X;
    private int[] dr = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    private int[] dc = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    public int solution(String[] board) {
        // o, x 갯수 판단하기
        init(board);
        // 풀이 과정
        solve(board);

        return answer;
    }

    private void solve(String[] board){
        // O, X가 각각 이겼는지 판단
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');

        if(O < X){
            answer = 0;
            return;
        }

        if(O - X > 1){
            answer = 0;
            return;
        }

        if(oWin && xWin){
            answer = 0;
            return;
        }

        if(oWin && O != X + 1){
            answer = 0;
            return;
        }

        if(xWin && O == X + 1){
            answer = 0;
            return;
        }

        answer = 1;
    }

    private boolean isWin(String[] board, char check){
        // 가로
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == check && board[i].charAt(1) == check && board[i].charAt(2) == check){
                return true;
            }
        }

        // 세로
        for(int i = 0; i < 3; i++){
            if(board[0].charAt(i) == check && board[1].charAt(i) == check && board[2].charAt(i) == check){
                return true;
            }
        }

        // 대각선
        if(board[0].charAt(0) == check && board[1].charAt(1) == check && board[2].charAt(2) == check){
            return true;
        }

        if(board[0].charAt(2) == check && board[1].charAt(1) == check && board[2].charAt(0) == check){
            return true;
        }

        return false;
    }

    private void init(String[] board){
        answer = 0;
        O = 0;
        X = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char cur = board[i].charAt(j);

                if(cur == 'O'){
                    O++;
                } else if(cur == 'X'){
                    X++;
                } else{
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new String[]{"O.X", ".O.", "..X"});
        int solution2 = sol.solution(new String[]{"OOO", "...", "XXX"});
        int solution3 = sol.solution(new String[]{"...", ".X.", "..."});
        int solution5 = sol.solution(new String[]{"...", "...", "..."});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution5 = " + solution5);
    }
}
