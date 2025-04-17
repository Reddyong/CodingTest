package programmers.Lv2.우박수열정적분;

import java.util.*;

class Solution {
    private int N;
    private double[] answer;
    private List<Integer> list;
    public double[] solution(int k, int[][] ranges) {
        init(ranges);
        solve(k, ranges);

        return answer;
    }

    private void solve(int k, int[][] ranges){
        // 1. 주어진 초항 k로 우박 수열 리스트와 N값 구하기
        makeList(k);

        // 2. 주어진 ranges 돌면서 각각의 범위에 대한 정적분 값 구하기
        getResult(ranges);
    }

    private void getResult(int[][] ranges){
        for(int i = 0; i < ranges.length; i++){
            answer[i] = integrate(ranges[i]);
        }
    }

    private double integrate(int[] range){
        int x1 = range[0];
        int x2 = N + range[1];

        if(x1 > x2){
            return -1.0;
        }

        if(x1 == x2){
            return 0.0;
        }

        double sum = 0;
        while(x1 < x2){
            int num1 = list.get(x1);
            int num2 = list.get(x1 + 1);

            sum += ((double) Math.min(num1, num2) + Math.abs(num1 - num2) / 2.0);
            x1++;
        }

        return sum;
    }

    private void makeList(int k){
        // 초기항 대입
        list.add(k);
        while(k > 1){
            if(k % 2 == 0){
                k /= 2;
            } else{
                k = k * 3 + 1;
            }

            list.add(k);
        }

        // 횟수기 때문에 1을 뺴준값
        N = list.size() - 1;
    }

    private void init(int[][] ranges){
        answer = new double[ranges.length];
        list = new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        double[] solution1 = sol.solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}});
        double[] solution2 = sol.solution(3, new int[][]{{0, 0}, {1, -2}, {3, -3}});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}