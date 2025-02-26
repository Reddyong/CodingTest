package programmers.Lv2.프렌즈4블록;

class Solution {
    private char[][] blocks;
    private int answer;
    public int solution(int m, int n, String[] board) {
        init(m, n, board);
        solve(m, n);

        return answer;
    }

    private void solve(int m, int n){
        while(true){
            boolean[][] check = new boolean[m][n];
            boolean flag = true;

            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    if(blocks[i][j] == '-'){
                        continue;
                    }

                    if(isPossible(i, j)){
                        check[i][j] = true;
                        check[i + 1][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j + 1] = true;
                        flag = false;
                    }
                }
            }

            if(flag){
                return;
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(check[i][j]){
                        answer++;
                        blocks[i][j] = '-';
                    }
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = m - 1; j >= 0; j--){
                    if(blocks[j][i] == '-'){
                        for(int k = j; k >= 0; k--){
                            if(blocks[k][i] == '-'){
                                continue;
                            }

                            blocks[j][i] = blocks[k][i];
                            blocks[k][i] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }

    private boolean isPossible(int i, int j){
        char cur = blocks[i][j];

        if(blocks[i + 1][j] == cur && blocks[i][j + 1] == cur && blocks[i + 1][j + 1] == cur){
            return true;
        }

        return false;
    }

    private void init(int m, int n, String[] board){
        blocks = new char[m][n];
        answer = 0;

        for(int i = 0; i < m; i++){
            blocks[i] = board[i].toCharArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        int solution2 = sol.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
