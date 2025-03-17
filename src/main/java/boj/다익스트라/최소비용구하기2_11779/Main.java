package boj.다익스트라.최소비용구하기2_11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m, start, end;
    private static int[] dijkstra, pre;
    private static List<List<Pos>> map;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Pos(start, 0));
        dijkstra[start] = 0;

        while (!pq.isEmpty()) {
            Pos poll = pq.poll();

            if (poll.weight != dijkstra[poll.v]) {
                continue;
            }

            for (Pos vertex : map.get(poll.v)) {
                int curWeight = poll.weight + vertex.weight;

                if (curWeight < dijkstra[vertex.v]) {
                    dijkstra[vertex.v] = curWeight;
                    pre[vertex.v] = poll.v;
                    pq.add(new Pos(vertex.v, curWeight));
                }
            }
        }

        int min = dijkstra[end];
        int count = 1;
        List<Integer> list = new ArrayList<>();
        list.add(end);
        while (end != start) {
            end = pre[end];
            list.add(end);
            count++;
        }

        System.out.println(min);
        System.out.println(count);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dijkstra = new int[n + 1];
        pre = new int[n + 1];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        map = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(r).add(new Pos(c, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
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
