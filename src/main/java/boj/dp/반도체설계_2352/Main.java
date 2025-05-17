package boj.dp.반도체설계_2352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] line;
    private static List<Pos> list;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < line.length; i++) {
            if (list.isEmpty()) {
                list.add(new Pos(line[i][0], line[i][1]));
                continue;
            }

            Pos back = list.get(list.size() - 1);

            if (back.from < line[i][0] && back.to < line[i][1]) {
                list.add(new Pos(line[i][0], line[i][1]));
            } else {
                list.set(binarySearch(line[i]), new Pos(line[i][0], line[i][1]));
            }
        }

        System.out.println(list.size());
    }

    private static int binarySearch(int[] target) {
        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;
            Pos pos = list.get(mid);

            if (pos.from < target[0] && pos.to < target[1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        line = new int[N][2];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i][0] = i + 1;
            line[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static class Pos {
        int from;
        int to;

        public Pos(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
