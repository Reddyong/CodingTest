package boj.백트래킹.소문난칠공주_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int answer;
    private static String[][] board;
    private static Set<List<String>> set;
    private static boolean[][] visited;
    private static int[] dr = new int[]{1, 0, -1, 0};
    private static int[] dc = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visited = new boolean[5][5];
                visited[i][j] = true;
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i, j});
                dfs(i, j, list);
            }
        }

        System.out.println("set = " + set);
        System.out.println(set.size());
    }

    private static void dfs(int r, int c, List<int[]> list) {
        if (list.size() == 7) {
            // 소문난 칠공주인지 판단
            if (isSevenPrincess(list)) {
//                for (int[] l : list) {
//                    System.out.print(Arrays.toString(l));
//                }
//                System.out.println("=====");
                List<String> temp = changeToStringArr(list);
                set.add(temp);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInBoard(nr, nc) && !visited[nr][nc]) {
                list.add(new int[]{nr, nc});
                visited[nr][nc] = true;
                dfs(nr, nc, list);
                list.remove(list.size() - 1);
                visited[nr][nc] = false;
            }
        }
    }

    private static List<String> changeToStringArr(List<int[]> list) {
        List<String> temp = new ArrayList<>();
        for (int[] l : list) {
            temp.add(String.valueOf(l[0]) + String.valueOf(l[1]));
        }

        Collections.sort(temp);

        return temp;
    }

    private static boolean isSevenPrincess(List<int[]> list) {
        int count = 0;
        for (int[] pos : list) {
            if (board[pos[0]][pos[1]].equals("S")) {
                count++;
            }
        }

        if (count >= 4) {
            return true;
        }

        return false;
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= 5 || c >= 5) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        board = new String[5][5];
        answer = 0;
        set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                board[i][j] = split[j];
            }
        }
    }
}
