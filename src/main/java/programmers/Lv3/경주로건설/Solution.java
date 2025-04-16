package programmers.Lv3.경주로건설;

import java.util.*;

class Solution {
    private int answer, N;
    private int[][][] dijkstra;
    // 남, 동, 북, 서
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    public int solution(int[][] board) {
        // 초기 값 및 dijkstra 배열 초기화
        init(board);
        solve(board);

        return answer;
    }

    private void solve(int[][] board){
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Pos(0, 0, 0, 0));

        while(!pq.isEmpty()){
            Pos poll = pq.poll();

            if(dijkstra[poll.r][poll.c][poll.dir] != poll.weight){
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                if(!isInBoard(nr, nc) || board[nr][nc] == 1){
                    continue;
                }

                int curWeight = 0;

                if(poll.r == 0 && poll.c == 0){
                    // 출발 지점인 경우
                    curWeight = poll.weight + 100;
                } else{
                    if(isLine(poll.dir, i)){
                        // 직선도로인 경우
                        curWeight = poll.weight + 100;
                    } else{
                        // 직각 코너인 경우
                        curWeight = poll.weight + 600;
                    }
                }

                if(dijkstra[nr][nc][i] > curWeight){
                    dijkstra[nr][nc][i] = curWeight;
                    pq.add(new Pos(nr, nc, i, curWeight));
                }
            }
        }

        answer = Math.min(dijkstra[N - 1][N - 1][0], Math.min(dijkstra[N - 1][N - 1][1], Math.min(dijkstra[N - 1][N - 1][2], dijkstra[N - 1][N - 1][3])));
    }

    private boolean isLine(int dir1, int dir2){
        int num = Math.abs(dir1 - dir2);

        if(num == 2 || num == 0){
            return true;
        } else{
            return false;
        }
    }

    private boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= N){
            return false;
        }

        return true;
    }

    private void init(int[][] board){
        answer = 0;
        N = board.length;
        dijkstra = new int[N][N][4];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 어느 방향에서 오는지에 따라 비용이 달라질 수 있기 때문에 3차원 배열로 설정
                Arrays.fill(dijkstra[i][j], Integer.MAX_VALUE);
            }
        }

        dijkstra[0][0][0] = 0;
        dijkstra[0][0][1] = 0;
        dijkstra[0][0][2] = 0;
        dijkstra[0][0][3] = 0;
    }

    // 이동 지점 노드 정보를 담을 클래스
    private class Pos{
        int r;
        int c;
        int dir;
        int weight;

        public Pos(int r, int c, int dir, int weight){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        int solution2 = sol.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}});
        int solution3 = sol.solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}});
        int solution4 = sol.solution(new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
    }
}
