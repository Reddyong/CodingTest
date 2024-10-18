package boj.재귀.곱셈_1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// NOTE : 이 문제를 풀기 위한 지식
//  1. a^n * a^m = a^(n + m)
//  2. (a * b) % c = (a % c) * (b % c) % c
public class Main {
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        System.out.println(pow(A, B, C));
    }

    private static long pow(int A, int exponent, int mod) {
        if (exponent == 1) {
            return A % mod;
        }

        long temp = pow(A, exponent / 2, mod);
        temp = temp * temp % mod;

        if (exponent % 2 == 1) {
            return temp * A % mod;
        }

        return temp;
    }
}
