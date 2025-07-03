package boj.위상정렬.문제집_1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<List<Integer>> map;
    private static List<Integer> answer;
    private static int[] indegree;
    private static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        // 초기 map 설정
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        // indegree 0인 노드 pq에 넣기
        saveInitNodes();

        // pq 에서 노드 하나씩 꺼내면서, 연결되어있는 노드의 연결선 제거
        // 제거 후, indegree 0인 노드들 pq에 추가
        findResult();

        // 정답 출력
        printResult();
    }

    private static void printResult() {
        for (Integer ans : answer) {
            System.out.print(ans + " ");
        }
    }

    private static void findResult() {
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            answer.add(poll);

            for (int next : map.get(poll)) {
                if (indegree[next] == 0) {
                    continue;
                }

                indegree[next]--;

                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
    }

    private static void saveInitNodes() {
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        map = new ArrayList<>();
        pq = new PriorityQueue<>();
        answer = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map.get(from).add(to);
            indegree[to]++;
        }
    }
}
