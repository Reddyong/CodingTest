package programmers.Lv2.하노이의탑;

import java.util.*;

class Solution {
    private int[][] answer;
    private List<int[]> list;
    public int[][] solution(int n) {
        solve(n);

        return answer;
    }

    private void solve(int n){
        list = new ArrayList<>();

        hanoi(1, 2, 3, n);

        answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            int[] cur = list.get(i);
            answer[i][0] = cur[0];
            answer[i][1] = cur[1];
        }
    }

    private void hanoi(int from, int mid, int to, int size){
        if(size == 1){
            list.add(new int[]{from, to});
            return;
        }

        // 제일 긴 것 제외한 나머지 mid로 이동
        hanoi(from, to, mid, size - 1);
        // 제일 긴 것 to로 이동
        hanoi(from, mid, to, 1);
        // mid에 담아뒀던 것 to로 이동
        hanoi(mid, from, to, size - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] solution = sol.solution(2);

        for (int[] s : solution) {
            System.out.println(Arrays.toString(s));
        }
    }
}
