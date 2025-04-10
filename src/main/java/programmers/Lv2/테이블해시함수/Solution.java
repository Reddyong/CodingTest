package programmers.Lv2.테이블해시함수;

import java.util.*;

class Solution {
    private int sortCol;
    private int answer;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        sorting(data, col);
        solve(data, row_begin, row_end);

        return answer;
    }

    private void solve(int[][] data, int row_begin, int row_end){
        List<Integer> list = new ArrayList<>();

        for(int i = row_begin - 1; i <= row_end - 1; i++){
            int num = i + 1;
            int sum = 0;
            for(int j = 0; j < data[i].length; j++){
                sum += (data[i][j] % num);
            }

            list.add(sum);
        }

        answer = list.get(0);
        for(int i = 1; i < list.size(); i++){
            answer = (answer ^ list.get(i));
        }
    }

    private void sorting(int[][] data, int col){
        sortCol = col - 1;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[sortCol] == o2[sortCol]){
                return o2[0] - o1[0];
            }

            return o1[sortCol] - o2[sortCol];
        });
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3);
        System.out.println("solution = " + solution);
    }
}