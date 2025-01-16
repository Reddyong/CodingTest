package boj.해시.나는야포켓몬마스터이다솜_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static Map<String, Integer> map1;
    private static Map<Integer, String> map2;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map1.put(name, i);
            map2.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String cur = br.readLine();

            if (map1.containsKey(cur)) {
                System.out.println(map1.get(cur));
            } else {
                System.out.println(map2.get(Integer.parseInt(cur)));
            }
        }
    }
}
