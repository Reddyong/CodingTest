package programmers.Lv2.서버증설횟수;

class Solution {
    private int[] arr;
    private int answer;
    public int solution(int[] players, int m, int k) {
        init(players);
        solve(players, m, k);

        return answer;
    }

    private void solve(int[] players, int m, int k){
        for(int i = 0; i < players.length; i++){
            int cur = players[i];

            if(cur < m){
                continue;
            }

            int temp = cur / m;

            if(arr[i] < temp){
                int plus = temp - arr[i];

                answer += plus;
                for(int j = i; j < i + k; j++){
                    if(j >= players.length){
                        break;
                    }
                    arr[j] += plus;
                }
            }
        }
    }

    private void init(int[] players){
        arr = new int[players.length];
        answer = 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5);
        int solution2 = sol.solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}, 5, 1);
        int solution3 = sol.solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
