package swea.최장증가부분수열.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static int T, N, answer;
    private static List<Integer> list;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int num = 1; num <= T; num++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            getResult();
            print(num);
        }
    }

    private static void getResult() {
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
            } else {
                list.set(binarySearch(arr[i]), arr[i]);
            }
        }

        answer = list.size();
    }

    private static int binarySearch(int target) {
        int st = 0;
        int en = list.size();

        while (st < en) {
            int mid = (st + en) / 2;

            if (list.get(mid) < target) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }

        return en;
    }

    private static void print(int num) {
        System.out.println("#" + num + " " + answer);
    }
}
