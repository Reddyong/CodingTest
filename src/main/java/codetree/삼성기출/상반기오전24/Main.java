package codetree.삼성기출.상반기오전24;

import java.util.*;
import java.io.*;

public class Main {
    private static Pos cur;
    private static int K, M;
    private static int[][] board;
    private static boolean[][] visited;
    private static Queue<Integer> numbers;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};
    private static int[] angle = new int[]{90, 180, 270};
    private static int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        // 주어진 변수, 배열 초기화
        init();
        // 풀이 진행
        solve();
    }

    private static void solve(){
        // K번 턴 동안 진행
        for(int turn = 0; turn < K; turn++){
            int answer = 0;
            // 초기 턴 목표 객체 생성
            cur = new Pos(0, 360, 5, 5, null, null);

            // 중심 좌표를 기준으로 회전 및 조건을 만족하는 위치와 회전 각도 등의 유적지 반환
            find();

            // 유물 연쇄 획득
            while(true){
                int er = erase();

                if(er <= 0){
                    break;
                }

                answer += er;

                // 유물 벽면에서 빈칸에 채워넣기
                fillAgain();

                // 다시 유물 획득 부분 처리
                int total = getTotal(board);
                cur = new Pos(total, -1, -1, -1, board, visited);
            }

            if(answer > 0){
                System.out.println(answer);
            }
        }
    }

    private static void fillAgain(){
        for(int c = 0; c < 5; c++){
            for(int r = 4; r >= 0; r--){
                if(board[r][c] == -1){
                    if(numbers.isEmpty()){
                        return;
                    }
                    board[r][c] = numbers.poll();
                }
            }
        }
    }

    private static int erase(){
        board = cur.arr;
        int count = 0;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(cur.visited[i][j]){
                    board[i][j] = -1;
                    count++;
                }
            }
        }

        return count;
    }

    private static void find(){
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                // board 배열 복사
                int[][] temp = copyBoard();
                // 90, 180, 270도 회전
                for(int cnt = 0; cnt < 3; cnt++){
                    rotate(temp, i, j);

                    // 회전 목표 체크
                    // 유물 1차 획득 가치 확인
                    int total = getTotal(temp);
                    int ang = angle[cnt];
                    int row = i;
                    int col = j;

                    // 기존 선택 되어있던 목표와 비교 후 갱신
                    if(cur.total < total){
                        cur = new Pos(total, ang, row, col, temp, visited);
                        continue;
                    } else if(cur.total == total){
                        // 유물 획득 가치 같은 경우
                        if(cur.ang > ang){
                            cur = new Pos(total, ang, row, col, temp, visited);
                        } else if(cur.ang == ang){
                            // 각도까지 같은 경우
                            if(cur.row > row){
                                cur = new Pos(total, ang, row, col, temp, visited);
                            } else if(cur.row == row){
                                // 열까지 같은 경우
                                if(cur.col > col){
                                    cur = new Pos(total, ang, row, col, temp, visited);
                                } else{
                                    continue;
                                }
                            } else{
                                continue;
                            }
                        } else{
                            continue;
                        }
                    } else{
                        continue;
                    }
                }
            }
        }
    }

    private static int getTotal(int[][] temp){
        int count = 0;
        visited = new boolean[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!visited[i][j]){
                    count += bfs(i, j, temp);
                }
            }
        }

        return count;
    }

    private static int bfs(int r, int c, int[][] temp){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 1});
        visited[r][c] = true;
        int num = temp[r][c];
        int max = 0;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            max = Math.max(max, poll[2]);

            for(int i = 0; i < 4; i++){
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if(isInBoard(nr, nc) && !visited[nr][nc] && temp[nr][nc] == num){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, poll[2] + 1});
                }
            }
        }

        if(max < 3){
            return 0;
        }

        return max;
    }

    private static boolean isInBoard(int r, int c){
        if(r < 0 || c < 0 || r >= 5 || c >= 5){
            return false;
        }

        return true;
    }

    private static void rotate(int[][] temp, int r, int c){
        int[] tempNum = new int[8];

        for(int i = 0; i < 8; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            // 임시 배열에 기존 테두리 숫자들 저장
            tempNum[i] = temp[nr][nc];
        }

        for(int i = 0; i < 8; i++){
            int from = (i + 6) % 8;
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            // 90도 회전한 값 대입
            temp[nr][nc] = tempNum[from];
        }
    }

    private static int[][] copyBoard(){
        int[][] temp = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                temp[i][j] = board[i][j];
            }
        }

        return temp;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[5][5];
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        numbers = new LinkedList<>();
        for(int i = 0; i < M; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static class Pos{
        int total;
        int ang;
        int row;
        int col;
        int[][] arr;
        boolean[][] visited;

        public Pos(int total, int ang, int row, int col, int[][] arr, boolean[][] visited){
            this.total = total;
            this.ang = ang;
            this.row = row;
            this.col = col;
            this.arr = arr;
            this.visited = visited;
        }
    }
}
