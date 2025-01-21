package boj.우선순위큐.카드정렬하기_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int N;
    private static int sum;
    private static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int third = first + second;

            sum += third;

            pq.add(third);
        }

        System.out.println(sum);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        sum = 0;

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
    }
}
