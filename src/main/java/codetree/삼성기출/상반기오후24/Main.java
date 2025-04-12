package codetree.삼성기출.상반기오후24;

import java.util.*;
import java.io.*;

public class Main {
    private static int R, C, K, id, answer;
    private static int[][] forest;
    private static Golem golem;
    private static List<Golem> golems;
    private static Map<Integer, Golem> golemDB;
    private static int[] dr = new int[] {-1, 0, 1, 0};
    private static int[] dc = new int[] {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        // 초기 변수, 골렘 출발 위치 및 방향 초기화
        init();

        // 풀이 과정 진행
        solve();
    }

    private static void solve() {
        // 골렘 순차적으로 진행
        for(int i = 0; i < K; i++) {
            // 현재 단계 골렘 객체
            Golem curGolem = golems.get(i);

            // 골렘이 더 이상 움직일 수 없을때 까지 이동
            // (남, 서쪽으로 돌기, 동쪽으로 돌기 순서)
            curGolem = moveGolem(curGolem);

            // 가장 최근에 이동한 골렘의 위치가 forest 범위 밖이면 answer 증가 없음
            // forest 배열 초기화 후 다음 단계 진행
            if(!isInBoard(curGolem.r - 2, curGolem.c)) {
                forest = new int[R + 1][C + 1];
                continue;
            }

            // 정령을 최대한 남쪽지점까지 이동시키기
            // 이 단계 시작 직전엔 forest[][]에 현재 골렘들의 위치 저장되어 있음
            // 정답 변수에 최종 남쪽 지점 행 번호 더함
            answer += getFinalLocation(curGolem);

        }

        System.out.println(answer);
    }

    private static int getFinalLocation(Golem golem) {
        // bfs 로 이동 가능한 지점 탐색
        int loc = golem.r;
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R + 1][C + 1];
        queue.add(new Pos(golem.r, golem.c));
        visited[golem.r][golem.c] = true;

        while(!queue.isEmpty()) {
            Pos poll = queue.poll();

            // 행의 최댓값 갱신 후 저장
            loc = Math.max(loc, poll.r);

            for(int i = 0; i < 4; i++) {
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];

                // 범위 안에 있고, 방문하지 않았던 곳이며, 골렘이 위치해있는 지점이어야함.
                if(isInBoard(nr, nc) && !visited[nr][nc] && forest[nr][nc] != 0) {
                    // 현재 지점과 이후 지점이 같을 경우
                    // 단순히 큐에 삽입
                    if(forest[poll.r][poll.c] == forest[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new Pos(nr, nc));
                    } else {
                        // 현재 지점과 이후 지점이 다른 경우 -> 다른 골렘
                        // 현재 지점이 출구인지 확인
                        // 출구가 맞으면 이동, 출구가 아니면 패스

                        // 골렘 DB에서 골렘 객체 가져오기
                        int curGolemNum = forest[poll.r][poll.c];
                        Golem tempGolem = golemDB.get(curGolemNum);

                        // 출구 위치 저장
                        int tempR = tempGolem.r + dr[tempGolem.exitDir];
                        int tempC = tempGolem.c + dc[tempGolem.exitDir];

                        if(poll.r == tempR && poll.c == tempC) {
                            visited[nr][nc] = true;
                            queue.add(new Pos(nr, nc));
                        } else {
                            continue;
                        }
                    }
                }
            }
        }


        return loc;
    }

    private static Golem moveGolem(Golem golem) {
        // 골렘이 더 이상 이동 가능한지 여부 : true (이동 가능), false (이동 불가능)
        boolean flag = true;

        // 1. 남쪽 아래 3칸이 비어있어 내려갈 수 있을 때 까지 남쪽으로 이동
        while(flag) {
            // 만약 현재 골렘 위치가 가장 남쪽이면 중단
            if(isFinalSouth(golem)) {
                break;
            }

            // 현재 골렘 위치에서 남쪽 3칸 비어있는지 판단
            // 비어있다면 다음 위치로 이동
            if(canMove(golem, 2)) {
                int nr = golem.r + dr[2];
                int nc = golem.c + dc[2];

                golem = new Golem(nr, nc, golem.exitDir);
                continue;
            }

            // 2. 남쪽으로 이동 불가능해서 서쪽으로 이동후 방향 회전
            // 서쪽으로 이동이 가능하면 회전 후 반복문 처음으로
            // 서쪽으로 이동이 불가능하면 동쪽 단계로 이동
            if(canMove(golem, 3)) {
                int nr = golem.r + dr[3];
                int nc = golem.c + dc[3];

                // 반시계 90도 방향으로 회전
                int nExitDir = golem.exitDir - 1;

                if(nExitDir == -1) {
                    nExitDir = 3;
                }

                // 서쪽으로 이동한 지점에서 남쪽으로 이동할 수 있는지 체크
                // 이동한 지점에서 남쪽으로 이동할 수 있는 경우만 다시 남쪽으로 이동하러 복귀
                // 남쪽으로 이동 불가하면 동쪽 단계로 이동
                Golem checkSouthGolem = new Golem(nr, nc, nExitDir);
                if(canMove(checkSouthGolem, 2)) {
                    golem = new Golem(nr, nc, nExitDir);

                    // 다시 남쪽으로 이동하러 복귀
                    continue;
                }
            }

            // 3. 서쪽으로도 불가능해서 동쪽으로 이동 후 회전
            // 동쪽으로 이동이 가능하면 회전 후 반복문 처음으로
            // 동쪽으로 이동이 불가능하면 flag = false 로 만든다
            if(canMove(golem, 1)) {
                int nr = golem.r + dr[1];
                int nc = golem.c + dc[1];

                // 시계 방향 90도 회전
                int nExitDir = golem.exitDir + 1;

                if(nExitDir == 4) {
                    nExitDir = 0;
                }

                // 동쪽으로 이동한 지점에서 남쪽으로 이동할 수 있는지 체크
                // 이동한 지점에서 남쪽으로 이동할 수 있는 경우만 다시 남쪽으로 이동하러 복귀
                // 남쪽으로 이동 불가하면 끝
                Golem checkSouthGolem = new Golem(nr, nc, nExitDir);
                if(canMove(checkSouthGolem, 2)) {
                    golem = new Golem(nr, nc, nExitDir);

                    // 다시 남쪽으로 이동하러 복귀
                    continue;
                }
            }

            flag = false;
        }

        // 최종 골렘의 위치가 forest 범위 밖인 경우
        // forest 배열에 저장하지 않고 반환
        if(!isInBoard(golem.r - 1, golem.c)) {
            return golem;
        }

        // 최종 골렘 위치 forest 에 표시
        forest[golem.r][golem.c] = id;
        forest[golem.r - 1][golem.c]= id;
        forest[golem.r][golem.c + 1] = id;
        forest[golem.r + 1][golem.c] = id;
        forest[golem.r][golem.c - 1] = id;

        // 표시한 골렘을 골렘 사전에 저장
        golemDB.put(id++, golem);

        return golem;
    }

    private static boolean isFinalSouth(Golem golem) {
        if(golem.r == R - 1) {
            return true;
        }

        return false;
    }

    private static boolean canMove(Golem golem, int moveDir) {
        int r = golem.r;
        int c = golem.c;
        int checkR1, checkR2, checkR3;
        int checkC1, checkC2, checkC3;

        // 이동 방향 남쪽
        if(moveDir == 2) {
            checkR1 = r + 1;
            checkC1 = c - 1;
            checkR2 = r + 2;
            checkC2 = c;
            checkR3 = r + 1;
            checkC3 = c + 1;
        } else if(moveDir == 3) {
            // 이동 방향 서쪽
            checkR1 = r - 1;
            checkC1 = c - 1;
            checkR2 = r;
            checkC2 = c - 2;
            checkR3 = r + 1;
            checkC3 = c - 1;

            // 행의 위치가 0보다 작아지는 경우가 시작지점 근처에서 존재하기 때문에
            // 그 부분은 상관없어서 전부 제일 아래 칸으로 대체
            if(checkR1 < 0) {
                checkR1 = checkR3;
                checkC1 = checkC3;
            }

            if(checkR2 < 0) {
                checkR2 = checkR3;
                checkC2 = checkC3;
            }
        } else {
            // 이동 방향 동쪽
            checkR1 = r - 1;
            checkC1 = c + 1;
            checkR2 = r;
            checkC2 = c + 2;
            checkR3 = r + 1;
            checkC3 = c + 1;

            // 행의 위치가 0보다 작아지는 경우가 시작지점 근처에서 존재하기 때문에
            // 그 부분은 상관없어서 전부 제일 아래 칸으로 대체
            if(checkR1 < 0) {
                checkR1 = checkR3;
                checkC1 = checkC3;
            }

            if(checkR2 < 0) {
                checkR2 = checkR3;
                checkC2 = checkC3;
            }
        }

        // 한군데라도 숲을 벗어나면 false 반환
        if(!isInBoard(checkR1, checkC1) || !isInBoard(checkR2, checkC2) || !isInBoard(checkR3, checkC3)) {
            return false;
        }

        // 모두 0으로 이동가능해야 true 반환
        if(forest[checkR1][checkC1] == 0 && forest[checkR2][checkC2] == 0 && forest[checkR3][checkC3] == 0) {
            return true;
        }

        // 나머지는 모두 false 반환
        return false;

    }

    private static boolean isInBoard(int r, int c) {
        if(r < 0 || c < 1 || r > R || c > C) {
            return false;
        }

        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // R, C, K, golems, forest 초기화
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;
        id = 1;
        golems = new ArrayList<>();
        forest = new int[R + 1][C + 1];
        golemDB = new HashMap<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = -1;
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            golems.add(new Golem(r, c, dir));
        }
    }

    private static class Pos{
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static class Golem{
        int r;
        int c;
        int exitDir;

        public Golem(int r, int c, int exitDir) {
            this.r = r;
            this.c = c;
            this.exitDir = exitDir;
        }

        @Override
        public String toString() {
            return "Golem [r=" + r + ", c=" + c + ", exitDir=" + exitDir + "]";
        }

    }
}
