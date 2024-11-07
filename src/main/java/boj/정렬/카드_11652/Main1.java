package boj.정렬.카드_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {
    static int N;
    static long maxNum;
    static long maxCount;
    static long count;
    static long[] numbers;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N - 1; i++) {
            if (numbers[i + 1] != numbers[i]) {
                if (count + 1 > maxCount) {
                    maxCount = count + 1;
                    maxNum = numbers[i];
                }
                count = 0;
                continue;
            }
            count++;
        }

        if (count + 1 > maxCount) {
            maxNum = numbers[N - 1];
        }

        System.out.println(maxNum);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maxCount = 0;
        count = 0;
        maxNum = Long.MIN_VALUE;
        numbers = new long[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(numbers);
    }
}
