package swea.SW문제해결기본1일차Flatten_1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int dump;
    static int[] boxes;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = 10;
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            dump = Integer.parseInt(st.nextToken());
            boxes = new int[100];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++){
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            int ans = solve();
            System.out.println("#" + t + " " + ans);
        }

    }

    private static int solve(){
        int ans = 0;

        for(int i = 0; i < dump; i++){
            Arrays.sort(boxes);
            boxes[99] -= 1;
            boxes[0] += 1;

            Arrays.sort(boxes);
            ans = boxes[99] - boxes[0];

            if(ans < 2){
                return ans;
            }
        }

        return ans;
    }
}
