package boj.이분탐색.좌표압축_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static Set<Integer> set;
    static List<Integer> list;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int cur : nums) {
            int min = 0;
            int max = list.size();

            while (min < max) {
                int mid = (min + max) / 2;

                if (list.get(mid) < cur) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }

            sb.append(min).append(" ");
        }

        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            set.add(input);
            nums[i] = input;
        }

        list = set.stream().sorted().collect(Collectors.toList());
    }
}
