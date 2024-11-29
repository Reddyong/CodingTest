package boj.수학.소인수분해_11653;

import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        int i = 2;

        while (i * i <= N) {
            if (N % i == 0) {
                System.out.println(i);
                N /= i;
                continue;
            }

            i++;
        }

        if (N != 1) {
            System.out.println(N);
        }
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
    }
}
