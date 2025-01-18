package boj.이진검색트리.이중우선순위큐_7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static int T;
    private static int K;
    private static TreeMap<Integer, Integer> tm;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            tm = new TreeMap<>();

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                } else {
                    if (tm.isEmpty()) {
                        continue;
                    }

                    int key;

                    if (num == 1) {
                        key = tm.lastKey();
                    } else {
                        key = tm.firstKey();
                    }

                    if (tm.get(key) - 1 > 0) {
                        tm.put(key, tm.get(key) - 1);
                    } else {
                        tm.remove(key);
                    }
                }
            }

            if (tm.isEmpty()) {
                sb.append("EMPTY\n");

            } else {
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
