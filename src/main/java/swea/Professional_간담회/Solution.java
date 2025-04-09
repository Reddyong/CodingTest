package swea.Professional_간담회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int T, N, M, X;
    private static long answer;
    private static List<List<Pos>> list1, list2;
    private static int[] toX, fromX;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 19
        for(int i = 1; i <= T; i++){
            // 초기값 세팅
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();

            for (int v = 0; v <= N; v++) {
                list1.add(new ArrayList<>());
                list2.add(new ArrayList<>());
            }

            // 지도 초기 정보 세팅
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                list1.get(from).add(new Pos(to, weight));
                list2.get(to).add(new Pos(from, weight));
            }

            // 각 사람이 해당 X 강의실로 가는 경우.
            toX = dijkstraTo(X);

            // X 에서 각 강의실로 돌아가는 경우.
            fromX = dijkstraFrom(X);

            answer = 0;
            for (int idx = 1; idx <= N; idx++) {
                if (toX[idx] == Integer.MAX_VALUE || fromX[idx] == Integer.MAX_VALUE) {
                    continue;
                }
                answer = Math.max(answer, toX[idx] + fromX[idx]);
            }

            System.out.println("#" + i + " " + answer);
        }
    }

    private static int[] dijkstraFrom(int start) {
        int[] dijkstra = new int[N + 1];

        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        dijkstra[start] = 0;
        pq.add(new Pos(start, 0));

        while (!pq.isEmpty()) {
            Pos poll = pq.poll();

            if (poll.weight != dijkstra[poll.v]) {
                continue;
            }

            for (Pos vertex : list1.get(poll.v)) {
                int curWeight = poll.weight + vertex.weight;

                if (dijkstra[vertex.v] > curWeight) {
                    dijkstra[vertex.v] = curWeight;
                    pq.add(new Pos(vertex.v, curWeight));
                }
            }
        }

        return dijkstra;
    }

    private static int[] dijkstraTo(int start) {
        int[] dijkstra = new int[N + 1];
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        dijkstra[start] = 0;
        pq.add(new Pos(start, 0));

        while (!pq.isEmpty()) {
            Pos poll = pq.poll();

            if (poll.weight != dijkstra[poll.v]) {
                continue;
            }

            for (Pos vertex : list2.get(poll.v)) {
                int curWeight = poll.weight + vertex.weight;

                if (dijkstra[vertex.v] > curWeight) {
                    dijkstra[vertex.v] = curWeight;
                    pq.add(new Pos(vertex.v, curWeight));
                }
            }
        }

        return dijkstra;
    }

    private static class Pos{
        int v;
        int weight;

        public Pos(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
}
