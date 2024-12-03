package boj.이분탐색.좌표압축_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1 {
    static int N;
    static int[] nums;
    static int[] arr;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(map.get(n)).append(" ");
        }

        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        arr = new int[N];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            nums[i] = input;
            arr[i] = input;
        }

        Arrays.sort(nums);

        int cur = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, cur);
                cur++;
            }
        }
    }
}
