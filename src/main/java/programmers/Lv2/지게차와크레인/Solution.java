package programmers.Lv2.지게차와크레인;

import java.util.*;

class Solution {
    private int answer, N, M;
    private char[][] board;
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int solution(String[] storage, String[] requests) {
        // 초기화
        init(storage);
        // 풀이 과정
        solve(requests);

        return answer;
    }

    private void solve(String[] requests){
        for(String request : requests){
            // 타겟
            char target = request.charAt(0);

            if(request.length() == 1){
                // 지게차인 경우
                // bfs로 바깥 부분을 돌면서 해당하는 부분에 닿을 수 있으면 '-'로 변환
                bfs(target);
            } else{
                // 크레인인 경우
                // 해당 위치를 '-'로 모두 변환
                for(int i = 0; i < N + 2; i++){
                    for(int j = 0; j < M + 2; j++){
                        if(board[i][j] == target){
                            board[i][j] = '-';
                            answer--;
                        }
                    }
                }
            }
        }
    }

    private void bfs(char target){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 2][M + 2];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc]){
                    // target과 일치하는 경우
                    // 큐에는 담지 않고 해당 부분의 컨테이너를 꺼낸 후 체크해놓는다
                    if(board[nr][nc] == target){
                        board[nr][nc] = '-';
                        visited[nr][nc] = true;
                        answer--;
                        continue;
                    }

                    if(board[nr][nc] == '-'){
                        // 빈공간인 경우 지게차가 갈수 있는 구역이므로 이동
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N + 2 || c >= M + 2){
            return false;
        }

        return true;
    }

    private void init(String[] storage){
        N = storage.length;
        M = storage[0].length();
        answer = N * M;
        board = new char[N + 2][M + 2];

        for(char[] cur : board){
            Arrays.fill(cur, '-');
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                board[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[]{"A", "BB", "A"});
        int solution2 = sol.solution(new String[]{"HAH", "HBH", "HHH", "HAH", "HBH"}, new String[]{"C", "B", "B", "B", "B", "H"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
